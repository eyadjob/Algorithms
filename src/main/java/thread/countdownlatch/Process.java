package thread.countdownlatch;

import thread.Executor;
import thread.pc.Producer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Process implements  Runnable {

    CountDownLatch downLatch = new CountDownLatch(3);

   int id = 0;

   public Process(CountDownLatch countDownLatch) {

       downLatch = countDownLatch;
   }

    public Process(int id) {
        id = id;
    }

    @Override
    public void run() {

        System.out.println("staring process with id: "+ downLatch.getCount());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finished process  with id: "+ downLatch.getCount());

        downLatch.countDown();
    }


    public static void main(String[] args) {
        CountDownLatch downLatch = new CountDownLatch(2);
        System.out.println("Starting ...");


        ExecutorService service = Executors.newFixedThreadPool(10);

        for ( int i=0; i < 10; i++) {
            service.submit(new Process(downLatch));

        }

        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks were submitted ");
    }
}
