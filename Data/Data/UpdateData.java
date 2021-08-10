package Data.Data;

import java.io.*;
import java.util.*;
import Data.Lib.*;

public class UpdateData {
    private static final String CARDS_FILE = "Data\\Data\\List_of_cards.csv";
    private static final String USERS_FILE = "Data\\Data\\List_of_users.csv";
    private static final String INFO_FILE = "Data\\Data\\Information_of_users.csv";
    private static final String ACCBALANCE = "accbal";
    private static final String PASSWORD = "password";
    private static final String STATUS = "status";

    public static void updateCard(Card card, String value, String key){

        String tempFileUrl = "Data\\Data\\tempFile.txt";
        File file = new File(CARDS_FILE);
        File tempFile = new File(tempFileUrl);
        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            PrintWriter write = new PrintWriter(bw);
            
            String line = read.readLine();
            while (line != null){
                String content[] = line.split(",");
                String cardNum = content[1];
                if (card.getCardNum().equals(cardNum)){
                    switch (key){
                        case ACCBALANCE ->{content[4] = value;}
                        case PASSWORD -> {content[5] = value;}
                        case STATUS -> {content[6] = value;}
                    }
                }
                List<String> listWord = Arrays.asList(content); 
                write.println(String.join(",",listWord));
                line = read.readLine();
            }
            read.close();
            write.close();
            bw.close();
            file.delete();
            tempFile.renameTo(file);
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        
    }
    public static void deleteUser(String userID){
        String tempFileUrl = "Data\\Data\\tempFile.txt";
        File tempFile = new File(tempFileUrl);
        File file = new File(USERS_FILE);
        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            PrintWriter write = new PrintWriter(bw);
            
            String line = read.readLine();
            while (line != null){
                String content[] = line.split(",");
                if (!userID.equals(content[0])){
                    write.println(line);
                }
                line = read.readLine();
            }
            read.close();
            write.close();
            bw.close();
            file.delete();
            tempFile.renameTo(file);
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
    public static void deleteCard(String cardNum){
        String tempFileUrl = "Data\\Data\\tempFile.txt";
        File tempFile = new File(tempFileUrl);
        File file = new File(CARDS_FILE);
        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            PrintWriter write = new PrintWriter(bw);
            
            String line = read.readLine();
            while (line != null){
                String content[] = line.split(",");
                if (!cardNum.equals(content[1])){
                    write.println(line);
                }
                line = read.readLine();
            }
            read.close();
            write.close();
            bw.close();
            file.delete();
            tempFile.renameTo(file);
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
    public static void deleteInfo(String userID){
        String tempFileUrl = "Data\\Data\\tempFile.txt";
        File tempFile = new File(tempFileUrl);
        File file = new File(INFO_FILE);
        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            PrintWriter write = new PrintWriter(bw);
            
            String line = read.readLine();
            while (line != null){
                String content[] = line.split(",");
                if (!userID.equals(content[0])){
                    write.println(line);
                }
                line = read.readLine();
            }
            read.close();
            write.close();
            bw.close();
            file.delete();
            tempFile.renameTo(file);
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}
