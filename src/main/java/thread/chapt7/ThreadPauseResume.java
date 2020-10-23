package thread.chapt7;

public class ThreadPauseResume {

    public static void main(String[] args) throws InterruptedException {
        CustomThread customThread = new CustomThread();
        customThread.start();

        int maxSleep = 3000;
        int slept = 0;
        
        while(slept < maxSleep){
            Thread.sleep(300);
            slept+=300;
            if(!customThread.isAlive()){
                System.out.println("Thread was completed within 3 seconds");
                System.exit(0);
            }
        }
        
        if(customThread.isAlive()){
            customThread.setShouldExit(true);
            System.out.println("Thread was stopped");
            customThread.join();
        }
        
        System.exit(0);
    }
}
