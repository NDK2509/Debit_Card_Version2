package ATM_Machine.MyThread;

import ATM_Machine.src.*;

public class ThreadLoad extends Thread{
    @Override
    public void run(){
        while (true){
            Display.reload();
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}