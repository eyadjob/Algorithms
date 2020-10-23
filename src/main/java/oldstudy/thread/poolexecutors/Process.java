package oldstudy.thread.poolexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Process extends Thread {


    int id = 0;
    @Override
    public void run() {
        System.out.println("starting stage  : " + id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("stage  is completed with id : " + id);
    }



    public  Process(int id ) {
        this.id = id;


    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("starting ...");


        ExecutorService executorService = Executors.newFixedThreadPool(5);


        for(int i=0; i < 5; i++) {
            executorService.submit(new Process(i));
        }

        executorService.shutdown();
        System.out.println("All tasks were submitted ...");
        executorService.awaitTermination(1, TimeUnit.DAYS);


    }
}
