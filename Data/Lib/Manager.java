package Data.Lib;

import java.util.*;
import Data.Data.*;

public class Manager {
    private static Scanner sc = new Scanner(System.in);
    private static final String STATUS = "status"; 
    private static final String TRUE_STATUS = "true";
    //works of manager
    public void create_User(){
        String name;
        while (true){
            System.out.print("Enter User Name: ");
            name = sc.nextLine().toUpperCase();
            if (!name.isBlank()) break;
            System.out.println("Entering-error! Please enter User name again!");
        }
        String userID;
        while (true) {
            userID = Check.inputUserID("Enter User ID: ");
            if (Check.uniqueUserID(userID)) break;
            System.out.println("UserID is exists! Please enter again!");
        }  
        String idCard = Check.inputIDCard("Enter ID Card: ");
        String birthday = Check.inputDate("Enter User Birthday: ");
        String phoneNum = Check.inputPhoneNum("Enter User Phone Number: ");
        String email = Check.inputEmail("Enter User Email: ");
        System.out.print("Enter User Address: ");
            String address = sc.nextLine();

        PutData.write_User(userID, name);
        GetData.mapUser.put(userID, new User(userID, name));

        PutData.write_Info(userID, idCard, birthday, phoneNum, email, address);
        GetData.mapUser.get(userID).setInfo(new InfoUser(idCard, birthday, phoneNum, email, address));
    }

    public void create_Card(){
        String userID;
        while (true) {
            userID = Check.inputUserID("Enter UserID: ");
            if (findUserID(userID) != null) break;
            System.out.println("User isn't exists! Please enter again!");
        }
        String cardNum;
        System.out.println("*Attention: Card Number must be 9 numeric charecters!");
        while (true){
            cardNum = Check.inputCardNum("Enter Number Of Card: "); 
            if (Check.uniqueCardNum(cardNum)) break;
            System.out.println("CardNumber is exists! Please enter again!");
        }
        String regisDate = Check.inputDate("Enter Registration Date: ");
        System.out.print("Enter Card Type: ");
            String cardType = sc.nextLine();
        long accBal = Check.inputInt("Enter Account Balance: ");
        System.out.println("*Attention: Password of a card must be 8 numeric characters!");
        String password = Check.inputPassword("Enter Card Password: ");
        PutData.write_Card(userID, cardNum, regisDate, cardType, accBal, password, TRUE_STATUS);
        String userName = GetData.mapUser.get(userID).getName();
        GetData.mapUser.get(userID).addCard(new Card(cardNum, userName, regisDate, cardType, accBal, password, true));
        
    }
    public void unLockCard(Card card){
        if (card.isLocked()) {
            card.setStatus(true);
            UpdateData.updateCard(card, "true", STATUS);
            try {
                System.out.println("Unlock card successfully!");
                Thread.sleep(2000);
            } catch (Exception e) {}
            return;
        }
        try {
            System.out.println("Card has unlocked before!");
            Thread.sleep(2000);
        } catch (Exception e) {}
        
    }
    public void lockCard(Card card){
        if (!card.isLocked()) {
            card.setStatus(false);
            UpdateData.updateCard(card, "false", STATUS);
            try {
                System.out.println("Lock card successfully!");
                Thread.sleep(2000);
            } catch (Exception e) {}
            return;
        }
        try {
            System.out.println("Card has locked before!");
            Thread.sleep(1500);
        } catch (Exception e) {}
    }
    public void rechargeMoney(int cash, Card card){
        card.setAccBal(card.getAccBal() + cash);
    }
    public Card findCardNum(String cardNum){
        for (User user : GetData.mapUser.values()){
            Card card = user.getCard(cardNum);
            if (card != null) return card;
        }
        return null;
    }
    public User findUserID(String userID){
        return GetData.mapUser.get(userID);
    }
    public User userOf(Card card){
        Map<String, User> mapUser = GetData.mapUser;
        for (User user : mapUser.values())
            if (user.getCard(card.getCardNum()) != null ) return user;
        return null;
    }
    public void removeCard(Card card){
        User user = userOf(card);
        user.getListCard().remove(card.getCardNum());
    }
    public void removeUser(User user){
        GetData.mapUser.remove(user.getUserID());
    }
}
