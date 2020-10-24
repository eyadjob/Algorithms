package oldstudy.thread.pc;

import lombok.SneakyThrows;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Executor {
    static Queue<Integer> sqs = new LinkedList<>();

    public AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Executor executor = new Executor();

            executor.process();



    }

    public void process() throws InterruptedException {

        Thread executor = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                produce();
                }
            }
        });

        Thread.sleep(500);

        Thread executor2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    consume();
                }
            }
        });


        executor.start();

        executor2.start();

    }

    public synchronized void produce() {


        while (sqs.size() == 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int v = (int) (Math.random() * 100);
        System.out.println("producing value: " + v + "  - time:" + new Date());
        sqs.add(v);
        notify();
        counter.getAndIncrement();
        System.out.println("producer add value and notified consumer sqs size is : " + sqs.size());
        System.out.println(counter.get());


    }

    public synchronized void consume() throws InterruptedException {
        notify();
        System.out.println(" we are going to consume, sqs size: " + sqs.size());


        while (sqs.isEmpty()) {
            System.out.println("waiting to consume");
            wait();
            System.out.println("after waiting to consume");

        }
        System.out.println("consuming value: " + sqs.poll() + " ,sqs size: " + sqs.size() + "  - time:" + new Date());
        System.out.println("consumer notified that it consumed value.");
        Thread.sleep(500);
    }


}

