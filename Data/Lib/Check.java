package Data.Lib;

import java.util.Scanner;
import Data.Data.GetData;

public class Check {
    private static Scanner sc = new Scanner(System.in);
    private static Manager mg = new Manager();

    private static boolean isLong(String strNum){
        try {
            return Long.parseLong(strNum) > 0;
        } catch (Exception e) {return false;}
    }
    public static boolean uniqueUserID(String userID){
        if (GetData.mapUser.get(userID) == null) return true;
        return false;
    }
    public static String inputUserID(String content){
        while (true){
            System.out.print(content);
                String userID = sc.nextLine();
            if (isLong(userID) && userID.length() >= 4 && userID.length() <= 8) return userID;
            System.out.println("Card number-entering error! Please, enter again!");
        }
    }
    public static boolean uniqueCardNum(String cardNum){
        if (mg.findCardNum(cardNum) == null) return true;
        return false;
    }
    public static String inputCardNum(String content){
        while (true){
            System.out.print(content);
                String cardNum = sc.nextLine();
            if (isLong(cardNum) && cardNum.length() == 9) return cardNum;
            System.out.println("Card number-entering error! Please, enter again!");
        }
    }
    public static int inputInt(String content){
        while (true){
            System.out.print(content);
                String num = sc.nextLine();
            if (isLong(num) && num.length() <= 8) return Integer.parseInt(num);
            System.out.println("Entering error! Please, enter again!");
        }
    }
    public static String inputDate(String content){
        while (true){
            System.out.print(content);
                String date = sc.nextLine();
            if (Date.isTrue(date)) return date;
            System.out.println("Date invalid! Please, enter again!");
        }
    }
    public static boolean uniqueIDCard(String idCard){
        for (User user : GetData.mapUser.values())
            if (idCard.equals(user.getInfo().getIdCard())) return false;
            return true;
    }
    public static String inputIDCard(String content){
        while (true){
            System.out.print(content);
                String idCard = sc.nextLine();
            if (isLong(idCard) && idCard.length() >= 9 && uniqueIDCard(idCard)) return idCard;
            System.out.println("ID card-entering error! Please, enter again!");
        } 
    }
    private static boolean isEmail(String email){
        if (email == null) return false;
        if (email.equals("[,?/\\ {}[]*&^%$#!`~\"\'+-+]+")) return false;
        if (!email.contains("@") || email.endsWith("@") || email.contains("@.")) return false;
        return true; 
    }
    public static String inputEmail(String content){
        while (true){
            System.out.print(content);
                String email = sc.nextLine();
            if (isEmail(email)) return email;
            System.out.println("Email-entering error! Please, enter again!");
        }
    }
    public static String inputPhoneNum(String content){
        while (true){
            System.out.print(content);
                String phoneNum = sc.nextLine();
            if (isLong(phoneNum) && phoneNum.length() > 9 && phoneNum.length() < 16) return phoneNum;
            System.out.println("Phone Number-entering error! Please, enter again!");
        }
    }
    public static String inputPassword(String content){
        while (true){
            System.out.print(content);
                String password = sc.nextLine();
            if (isLong(password) && password.length() == 8) return password;
            System.out.println("Password-entering error! Please, enter again!");
        }
    }
    public static int inputDrawing(Card card){
        while (true){
            System.out.print("Enter cash amount: ");
                String cash = sc.nextLine();
            if (isLong(cash)){
                int cash_Int = Integer.parseInt(cash);
                if (cash_Int <= card.getLimitPerTime() && cash_Int >= 100000)
                    return Integer.parseInt(cash);
            }
            System.out.printf("Entering error! Limit per time: 100000 <= x <= %d, try again!\n", card.getLimitPerTime());
        }
    }
    public static int inputTransfering(Card card){
        while (true){
            System.out.print("Enter cash amount: ");
                String cash = sc.nextLine();
            if (isLong(cash)){
                int cash_Int = Integer.parseInt(cash);
                if (cash_Int <= card.getTransactionLimit() && cash_Int > 100000)
                    return Integer.parseInt(cash);
            }
            System.out.printf("Entering error! Limit per time: 100000 <= x <= %d, try again!\n", card.getLimitPerTime());
        }
    }
}
