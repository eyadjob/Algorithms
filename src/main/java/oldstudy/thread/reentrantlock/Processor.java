package oldstudy.thread.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Processor extends Thread {


    static volatile int counter = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Processor po = new Processor();
        long currentTime = System.currentTimeMillis();
        po.start();

        System.out.println("counter value: " + counter + " ,time required: " + (System.currentTimeMillis() - currentTime));
        System.out.println("counter value: " + counter + " ,time required: " + (System.currentTimeMillis() - currentTime));


    }

    public void firstThread() throws InterruptedException {
        System.out.println("first oldstudy.thread start");
            Thread thread = increment();
            thread.start();

        System.out.println("first oldstudy.thread finished, count value: " + counter);

    }

    public void secondThread() throws InterruptedException {
        lock.lock();

        Thread thread = increment();
        thread.start();
        lock.unlock();


    }

    public void thirdThread() throws InterruptedException {
        lock.lock();
        Thread thread = increment();
        thread.start();
        lock.unlock();


    }

    public Thread increment() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                for (int i = 0; i < 100000; i++) {
                    counter++;
                }


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        });

        return thread;
    }


    public void start() {


        try {
            for (int i = 0; i < 3; i++) {
                firstThread();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
