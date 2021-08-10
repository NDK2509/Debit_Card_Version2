package ATM_Machine.MyThread;

import User_Management.src.*;

public class ThreadDisplayAdmin extends Thread{
    @Override 
    public void run(){
        DisplayAdmin.main();
    }
}