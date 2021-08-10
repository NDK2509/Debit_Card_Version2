package User_Management.Login;
import java.util.*;
import java.io.*;

public class Admin_Login {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, String> mapAdmin = new HashMap<>();

    private static void putAdLoginData() {
        String url = "User_management\\Login\\Admin_Account.csv";
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(url));
            String line = input.readLine();
            while (line != null){
                String admin[] = line.split(",");
                mapAdmin.put(admin[0], admin[1]);
                line = input.readLine();
            }
        input.close();

        } catch (Exception e) {
            System.out.println("File Admin_Account.csv not found");
        }
    }
    private static boolean check_Admin_Acc(String adminAcc){
        if (mapAdmin.get(adminAcc) == null) return false;
        return true;
    }
    private static boolean check_Admin_Pass(String adminAcc, String pass){
        if (mapAdmin.get(adminAcc).equalsIgnoreCase(pass)) return true;
        return false;
    }
    private static void adminLoginDisplay(){
        System.out.println("\033\143");
        String adminAcc;
        while (true) {
            System.out.print("Enter Admin Account: ");
            adminAcc = sc.nextLine();
            if (check_Admin_Acc(adminAcc)) break;
            System.out.println("Account not found!");
        }
        while (true) {
            System.out.print("Enter Password: ");
            String pass = sc.nextLine();
            if (check_Admin_Pass(adminAcc, pass)) break;
            System.out.println("Password wrong!");
        }
        System.out.println("\033\143");
        System.out.println("Login successfully!");
        try {Thread.sleep(1000);} catch (InterruptedException e) {}
        System.out.println("\033\143");
    }
    public static void main() {
        putAdLoginData();
        adminLoginDisplay();
    }
}
