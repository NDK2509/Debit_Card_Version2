package ATM_Machine.src;

import Data.Data.*;
import Data.Lib.*;
import java.util.Scanner;

public class Display{
    private static Scanner sc = new Scanner(System.in);
    private static Manager mg = new Manager();
    private static Card card;
    private static User user;
    private static String cardNum;
    public static boolean isLogin;

    private static final String FUNCTION_1 = "1";
    private static final String FUNCTION_2 = "2";
    private static final String FUNCTION_3 = "3";
    private static final String FUNCTION_4 = "4";
    private static final String LOG_OUT = "5";
    private static final String EXIT = "0";

    private static final String ACCBALANCE = "accbal";
    private static final String PASSWORD = "password";

    private static void startATM(){
        isLogin = false;
        System.out.println("\033\143");
        System.out.print("WELCOME TO K_ATM...");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        System.out.println("\033\143");
    }
    private static void helloUser(User user){
        System.out.println("\033\143");
        System.out.printf("HELLO %s...", user.getName());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {}
        System.out.println("\033\143");
    }
    private static void goodByeUser(User user){
        System.out.println("\033\143");
        System.out.printf("GOODBYE %s...", user.getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
    }
    private static boolean enterPassword(Card card){
        if (!card.isLocked()){
            for (byte time = 1; time <= 3; time++){
                String password = Check.inputPassword("ENTER YOUR PASSWORD: ");
                if (password.equals(card.getPassword())) return true;
                System.out.printf("Wrong Password! You have %d time(s) to enter your password!\n", 3 - time);
            }
            mg.lockCard(card);
        }
        return false;
    }
    private static void userLogin(){
        while (true){
            cardNum = Check.inputCardNum("ENTER YOUR CARD NUMBER: ");
            card = mg.findCardNum(cardNum);
            if (card != null) break;
            System.out.println("Card not found!");
            try {
                Thread.sleep(1500);
                System.out.println("\033\143");
            } catch (Exception ex) {}
        }
        if (!card.isLocked() && enterPassword(card)){
            user = mg.userOf(card);
            helloUser(user);
            isLogin = true;
            while (menu()) System.out.println("\033\143");
        } else 
            try {
                System.out.println("YOUR CARD IS LOCKED! Please, contact with our manager to unlock your card!");
                Thread.sleep(2000);
            } catch (Exception e){}
    }
    private static boolean menu(){
        System.out.println("""
        ---------------------------
        -----------K_ATM-----------
        ---------------------------

        1. Check Account Balance
        2. Draw Money
        3. Transfer Money
        4. Change Password
        5. Log Out
        6. Exit

        """);
        System.out.print("Enter your choice: ");
        String choice = sc.nextLine();
        return choose(choice);
        
    }
    private static boolean choose(String choice){
        if (card.isLocked()) {
            try {
                System.out.println("YOUR CARD IS LOCKED! Please, contact with our manager to unlock your card!");
                Thread.sleep(2500);
            } catch (Exception e){}
            return false;
        }
        System.out.println("\033\143");
        switch (choice){
            case FUNCTION_1 -> {
                System.out.printf("Your account balance is $%d.\n", card.getAccBal());
                System.out.println("\nPress Enter to continue!");
                sc.nextLine();
            }
            case FUNCTION_2 -> {
                int cash = Check.inputDrawing(card);
                user.drawMoney(cash, card);
                String accBal = Long.toString(card.getAccBal());
                UpdateData.updateCard(card, accBal, ACCBALANCE);
                System.out.printf("You have just drawn $%d.\n", cash);
                System.out.printf("Your account balance is $%s.\n", accBal);
                System.out.println("\nPress Enter to continue!");
                sc.nextLine();
            }
            case FUNCTION_3 -> {
                Card transfered_card;
                while (true){
                    String cardNum = Check.inputCardNum("Enter the card number which you want to transfer money: ");
                    transfered_card = mg.findCardNum(cardNum);
                    if (transfered_card != null && !cardNum.equals(card.getCardNum())) break;
                    System.out.println("Card not found!");
                    try {
                        Thread.sleep(1500);
                        System.out.println("\033\143");
                    } catch (Exception ex) {}
                }
                transfered_card.protectedInfo();
                
                int cash = Check.inputTransfering(card);
                user.transferMoney(cash, card, transfered_card);
                String accBal = Long.toString(transfered_card.getAccBal());
                UpdateData.updateCard(transfered_card, accBal, ACCBALANCE);
                accBal = Long.toString(card.getAccBal());
                UpdateData.updateCard(card, accBal, ACCBALANCE);
                System.out.println("\nTransfer successfully!");
                System.out.printf("You have just transfered $%d.\n", cash);
                System.out.printf("Your account balance is $%s.\n", accBal);
                System.out.println("\nPress Enter to continue!");
                sc.nextLine();     
            }
            case FUNCTION_4 -> {
                if (enterPassword(card)){
                    System.out.println("*Attention: New password must be 8 numeric characters!");
                    String newPassword = Check.inputPassword("Enter your new password: ");
                    card.setPassword(newPassword);
                    UpdateData.updateCard(card, newPassword, PASSWORD);
                    try {
                        System.out.println("Changed password successful!");
                        Thread.sleep(1500);
                    } catch (Exception e) {}
                }
                else {
                    try {
                        System.out.println("YOUR CARD IS LOCKED! Please, contact with our manager to unlock your card!");
                        Thread.sleep(2000);
                    } catch (Exception e){}
                    return false;
                }
            }
            case LOG_OUT -> {
                goodByeUser(user);
                return false;
            }
            case EXIT -> {
                System.out.println("Exit ATM Machine...");
                System.exit(0);
            }
            default -> {
                try {
                    System.out.println("Invalid choice!");
                    Thread.sleep(1500);
                } catch (Exception e) {}
            }
        }
        return true;
    }
    public static void reload(){
        if (isLogin){
            card = mg.findCardNum(cardNum);
            user = mg.userOf(card);
        }  
    }
    public static void main() { 
        startATM();
        userLogin();
    }
}