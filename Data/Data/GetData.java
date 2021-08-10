package Data.Data;

import java.io.*;
import java.util.*;
import Data.Lib.*;

public class GetData{
    public static Map<String, User> mapUser, mapUpdated;
    private static final String CARDS_FILE = "Data\\Data\\List_of_cards.csv";
    private static final String USERS_FILE = "Data\\Data\\List_of_users.csv";
    private static final String INFO_FILE = "Data\\Data\\Information_of_users.csv";

    public static void readUsersFile(String usersFile){
       
        try {
            BufferedReader br = new BufferedReader(new FileReader(usersFile));
            String line = br.readLine();
            while (line != null) {
                String userInfo[] = line.split(",");
                String userID = userInfo[0];
                String name = userInfo[1];
                mapUpdated.put(userID, new User(userID, name));
                line = br.readLine();
            }
            br.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){}
    }
    public static void readCardsFile(String cardsFile){
        try {
            BufferedReader br = new BufferedReader(new FileReader(cardsFile));
            String line = br.readLine();
            while (line != null) {
                String cardInfo[] = line.split(",");
                String userID = cardInfo[0];
                String cardNum = cardInfo[1];
                String regisDate = cardInfo[2];
                String type = cardInfo[3];
                long accBal = Integer.parseInt(cardInfo[4]);
                String password = cardInfo[5];
                boolean status = Boolean.parseBoolean(cardInfo[6]);
                User user = mapUpdated.get(userID);
                if (user != null)
                    if (type.contains("VIP")) 
                        user.addCard(new VIP_Card(cardNum, user.getName(), regisDate, type, accBal, password, status));
                    else user.addCard(new Card(cardNum, user.getName(), regisDate, type, accBal, password, status));
                else System.out.printf("UserID %s is not exists in our system!\n", userID);

                line = br.readLine();
            }
            br.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){}
    }
    public static void readAddressFlie(String infoFile){
        try {
            BufferedReader br = new BufferedReader(new FileReader(infoFile));
            String line = br.readLine();
            while (line != null) {
                String info[] = line.split(",");
                String userID = info[0];
                String idCard = info[1];
                String birthday = info[2];
                String phoneNum = info[3];
                String email = info[4];
                String address = info[5];
                User user = GetData.mapUpdated.get(userID);
                user.setInfo(new InfoUser(idCard, birthday, phoneNum, email, address));
                line = br.readLine();
            }
            br.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){}
    }
    public static void main(){
        mapUpdated = new HashMap<>();
        readUsersFile(USERS_FILE);
        readCardsFile(CARDS_FILE);
        readAddressFlie(INFO_FILE);
        mapUser = mapUpdated;
    }
}
