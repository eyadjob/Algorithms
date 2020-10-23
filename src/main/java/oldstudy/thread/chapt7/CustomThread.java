package oldstudy.thread.chapt7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomThread extends Thread {

    private boolean shouldExit = false;

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                if(shouldExit){
                    break;
                }
                System.out.println("Thread is runnning!");
                Thread.sleep(200);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(CustomThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
