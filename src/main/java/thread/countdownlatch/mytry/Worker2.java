package thread.countdownlatch.mytry;

import thread.multiplelocks.Processor;

import java.util.concurrent.CountDownLatch;

public class Worker2 extends Thread {

    CountDownLatch countDownLatch;

    public Worker2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;   }

    @Override
    public void run() {




        for(int i =0; i < 10000000; i++) {
            ProcessorThreadLocal.cdlCounter++;


        }
        countDownLatch.countDown();


        System.out.println("count down latch value : "  + countDownLatch.getCount() + " , the thread name is : " + Thread.currentThread().getName());


    }
}
