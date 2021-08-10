package User_Management.src;

import User_Management.Login.*;
import java.util.Scanner;
import Data.Data.*;
import Data.Lib.*;

public class DisplayAdmin {
    
    private static final String FUNCTION_1 = "1";
    private static final String FUNCTION_2 = "2";
    private static final String FUNCTION_3 = "3";
    private static final String FUNCTION_4 = "4";
    private static final String FUNCTION_5 = "5";
    private static final String FUNCTION_6 = "6";
    private static final String FUNCTION_7 = "7";
    private static final String FUNCTION_8 = "8";
    private static final String FUNCTION_9 = "9";
    private static final String EXIT = "0";

    private static final String ACCBALANCE = "accbal";

    private static Scanner sc = new Scanner(System.in);
    private static Manager mg = new Manager();

    private static void displayChoices(){
        System.out.println("""
        -----------------------------
        -----------Manager-----------
        -----------------------------

        1. Create a new User.
        2. Create a new Card.
        3. Lock a Card.
        4. Unlock a Card.
        5. Recharge for a Card.
        6. User information.
        7. Card information.
        8. Delete User.
        9. Delete Card.
        0. Exit.

        ------------------------------
        """);

        System.out.print("Enter your choice: ");
        String yourChoice = sc.nextLine();
        choose(yourChoice);
    }
    private static void choose(String yourChoice){
        System.out.println("\033\143");
        switch (yourChoice){
            case FUNCTION_1 -> {
                mg.create_User();
            }
            case FUNCTION_2 -> {
                mg.create_Card();
            }
            case FUNCTION_3 -> {
                String cardNum = Check.inputCardNum("Enter Card Number: ");
                Card card = mg.findCardNum(cardNum);
                if (card != null){
                    System.out.println(card);
                    mg.lockCard(card);   
                } else {
                    System.out.println("Card not found!");
                    try {
                        Thread.sleep(1500);
                    } catch (Exception ex) {}
                }
            }
            case FUNCTION_4 -> {
               String cardNum = Check.inputCardNum("Enter Card Number: ");
                Card card = mg.findCardNum(cardNum);
                if (card != null){
                    System.out.println(card);
                    mg.unLockCard(card);   
                } else {
                    System.out.println("Card not found!");
                    try {
                        Thread.sleep(1500);
                    } catch (Exception ex) {}
                }
            }
            case FUNCTION_5 -> {
                String cardNum = Check.inputCardNum("Enter Card Number: ");
                Card card = mg.findCardNum(cardNum);
                if (card != null) {
                    int cash = Check.inputInt("Enter Cash Amount: ");
                    mg.rechargeMoney(cash, card);
                    String accBal = Long.toString(card.getAccBal());
                    UpdateData.updateCard(card, accBal, ACCBALANCE);
                    System.out.println(card);
                    System.out.println("\nPress Enter to continue!");
                    sc.nextLine();
                } else {
                    System.out.println("Card not found!");
                    try {
                        Thread.sleep(1500);
                    } catch (Exception ex) {}
                }
                 
            }
            case FUNCTION_6 -> {
                String userID = Check.inputUserID("Enter User ID: ");
                User user = mg.findUserID(userID);
                try {
                    System.out.println("\033\143");
                    user.printInfor();
                    System.out.println("\nPress enter to continue!");
                    sc.nextLine();
                } catch (NullPointerException e) {
                    System.out.println("User not found!");
                    try {
                        Thread.sleep(1500);
                    } catch (Exception ex) {}
                }
            } 
            case FUNCTION_7 -> {
                String cardNum = Check.inputCardNum("Enter Card Number: ");
                Card card = mg.findCardNum(cardNum);
                if (card != null) {
                    System.out.println("\033\143");
                    System.out.println(card);
                    System.out.println("\nPress enter to continue!");
                    sc.nextLine();
                } else {
                    System.out.println("Card not found!");
                    try {
                        Thread.sleep(1500);
                    } catch (Exception ex) {}
                }
            }
            case FUNCTION_8 -> {
                String userID = Check.inputUserID("Enter User ID: ");
                User user = mg.findUserID(userID);
                try {
                    user.printInfor();
                    System.out.print("Do you want to delete this user? (Press 'Y' to delete or any key else to back menu.) ");
                    String choice = sc.nextLine();
                    if (choice.equals("Y")){
                        UpdateData.deleteUser(userID);
                        UpdateData.deleteInfo(userID);
                        for (String cardNum : GetData.mapUser.get(userID).getListCard().keySet()) 
                            UpdateData.deleteCard(cardNum);
                        mg.removeUser(user);
                        try {
                            System.out.println("Deleted successfully!");
                            Thread.sleep(1500);
                        } catch (Exception e) {}
                    }
                } catch (NullPointerException e) {
                    System.out.println("User not found!");
                    try {
                        Thread.sleep(1500);
                    } catch (Exception ex) {}
                }
            }
            case FUNCTION_9 -> {
                String cardNum = Check.inputCardNum("Enter Card Number: ");
                Card card = mg.findCardNum(cardNum);
                try {
                    System.out.println(card);
                    System.out.print("Do you want to delete this user? (Press 'Y' to delete or any key else to back menu.) ");
                    String choice = sc.next();
                    if (choice.equals("Y")) {
                        UpdateData.deleteCard(cardNum);
                        mg.removeCard(card);
                    }
                } catch (NullPointerException e) {
                    System.out.println("Card not found!");
                    try {
                        Thread.sleep(1500);
                    } catch (Exception ex) {}
                }
            }
            case EXIT -> {
                System.out.println("Exit Program!");   
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid choice!");
                try {Thread.sleep(1500);} catch (Exception e) {}
            }
        }
        System.out.println("\033\143");
    }
    public static void main() {
        Admin_Login.main();
        //GetData.main();
        while (true) displayChoices();
    }
}