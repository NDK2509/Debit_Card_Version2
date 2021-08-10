package ATM_Machine.MyThread;

import Data.Data.*;

public class ThreadGetData extends Thread{
    @Override
    public void run(){
        while (true){
            GetData.main();
            //System.out.println(updatedData.values());
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}