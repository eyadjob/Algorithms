package oldstudy.thread.countdownlatch.mytry;

import java.util.concurrent.CountDownLatch;
import java.util.function.Supplier;

public class Worker implements Runnable {

    static int counter = 0;
    public static  ThreadLocal<Integer> localCounter  =  ThreadLocal.withInitial(new Supplier<Integer>() {
        @Override
        public Integer get() { return 0; }
    });

    CountDownLatch countDownLatch;
    public Worker(CountDownLatch countDownLatch ) {

       this.countDownLatch  = countDownLatch;
    }
    @Override
    public void run() {

        for ( int i=0; i < 10000000; i++ ) {

//            ProcessorThreadLocal.values.add(i);
//            localCounter.set(localCounter.get()+1);
//            countDownLatch.countDown();
//            counter++;
            ProcessorThreadLocal.ai.getAndIncrement();

        }
//        System.out.println(localCounter.get());
//        System.out.println("counter value in the oldstudy.thread:"  + counter);
//        System.out.println("oldstudy.thread local value in the oldstudy.thread: " + localCounter.get());



    }
}
