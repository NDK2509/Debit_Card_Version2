package ATM_Machine.MyThread;

import ATM_Machine.src.*;

public class ThreadDisplay extends Thread{
    @Override
    public void run(){
        while (true) Display.main();
    }
}