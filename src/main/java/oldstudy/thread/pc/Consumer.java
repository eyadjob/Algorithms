package oldstudy.thread.pc;

import java.util.Date;

public class Consumer extends Thread {


    @Override
    public void run() {

        consume();

    }

    public synchronized void consume() {
        System.out.println(" we are going to consume, sqs size: " + Producer.sqs.size());

        while (true) {

            synchronized (Producer.sqs) {
                if (Producer.sqs.isEmpty()) {
                    System.out.println("waiting to consume");
                    notify();
                    System.out.println("after waiting to consume");

                } else
                    System.out.println("consuming value: " + Producer.sqs.poll() + "  - time:" + new Date());
                }
            }
        }

    }


