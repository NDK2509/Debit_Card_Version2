package Data.Data;

import java.io.*;

public class PutData {
    private static final String CARDS_FILE = "Data\\Data\\List_of_cards.csv";
    private static final String USERS_FILE = "Data\\Data\\List_of_users.csv";
    private static final String INFO_FILE = "Data\\Data\\Information_of_users.csv";

    public static void write_User(String userID, String name) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_FILE, true));
            PrintWriter write = new PrintWriter(bw);
            write.print(userID + "," + name);
            write.println();
            try {
                System.out.println("Updated successfully!");
                Thread.sleep(1000);
            } catch (Exception e) {}
            write.close();
        } catch (Exception e) {
            try {
                System.out.println("Error! File didn't update.");
                Thread.sleep(1500);
            } catch (Exception ex) {}
        }
    }
    public static void write_Card(String userID, String cardNum, String date, String cardType, long accBal, String password, String status) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(CARDS_FILE, true));
            PrintWriter write = new PrintWriter(bw);
            write.print(userID + "," + cardNum + "," + date + "," + cardType + "," + accBal + "," + password + "," + status);
            write.println();
            try {
                System.out.println("Updated successfully!");
                Thread.sleep(1500);
            } catch (Exception e) {}
            write.close();
        } catch (Exception e) {
            try {
                System.out.println("Error! File didn't update.");
                Thread.sleep(1500);
            } catch (Exception ex) {}
        }
    }
    public static void write_Info(String userID, String idCard, String birthday, String phoneNum, String email, String address){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(INFO_FILE, true));
            PrintWriter write = new PrintWriter(bw);
            write.print(userID + "," + idCard + "," + birthday + "," + phoneNum + "," + email + "," + address);
            write.println();
            try {
                System.out.println("Updated user-information successfully!");
                Thread.sleep(1500);
            } catch (Exception e) {}
            write.close();
        } catch (Exception e) {
            try {
                System.out.println("Error! File didn't update.");
                Thread.sleep(1500);
            } catch (Exception ex) {}
        }
    }
}
