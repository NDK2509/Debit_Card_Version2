package ATM_Machine.src;

import ATM_Machine.MyThread.*;

public class Main {
    public static void main(String[] args){
         
        Thread display = new ThreadDisplay();
        Thread getData = new ThreadGetData();
        Thread reload = new ThreadLoad();
            display.start();
            getData.start();
            reload.start();       
    }
}
