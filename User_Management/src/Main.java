package User_Management.src;

import ATM_Machine.MyThread.*;

public class Main {
    public static void main(String[] args) {
        Thread getData = new ThreadGetData();
        Thread displayAdmin = new ThreadDisplayAdmin();
            getData.start();
            displayAdmin.start();
    }
}
