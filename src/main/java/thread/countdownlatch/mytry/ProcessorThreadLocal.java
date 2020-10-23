package thread.countdownlatch.mytry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcessorThreadLocal {


    public static List<Integer> values = Collections.synchronizedList(new ArrayList<>());
    public static volatile int vv = 0;
    public static List<Integer> values2 = new ArrayList<>();
    public static AtomicInteger ai = new AtomicInteger(0);
    public  static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static int cdlCounter= 0;
public static int syncMethodCounter=0;
    public ProcessorThreadLocal() {

        System.out.println("inside the processor constructor");
    }

    public static void main(String[] args) {

        Worker worker = new Worker(countDownLatch);
        Thread thread = new Thread(worker);
        Thread thread1 = new Thread(worker);
        long ct = System.currentTimeMillis();
        thread.start();

        thread1.start();

        try {
            thread.join();
            thread1.join();
//            countDownLatch.await();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long nt = System.currentTimeMillis();
//        System.out.println("local thread one " + worker.localCounter.get());
        System.out.println("Atomic integer value is " + ai.get());
        System.out.println("time took for adding 2 million for Atomic integer is: " + (nt - ct));

        ct = System.currentTimeMillis();
        int counter = 0;
        for (int i = 0; i < 20000000; i++) {
                counter++;
        }
        nt = System.currentTimeMillis();
        System.out.println("normal integer value is " + counter);
        System.out.println("time took for adding 2 million for normal integer is: " + (nt - ct));

        ct = System.currentTimeMillis();

        Worker2 worker2 = new Worker2(countDownLatch);
        worker2.start();

        Worker2 worker3 = new Worker2(countDownLatch);
        worker3.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nt = System.currentTimeMillis();

        System.out.println("count down latch counter integer value is " + cdlCounter);
        System.out.println("time took for adding 2 million for count down latch counter integer is: " + (nt - ct));

        ct = System.currentTimeMillis();

        Worker3 worker5 = new Worker3();
        worker5.start();

        Worker3 worker6 = new Worker3();
        worker6.start();

        try {

        worker5.join();
        worker6.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nt = System.currentTimeMillis();



        System.out.println("syncMethodCounter integer value is " + syncMethodCounter );
        System.out.println("time took for adding 2 million for syncMethodCounterr integer is: " + (nt - ct));



    }
}
