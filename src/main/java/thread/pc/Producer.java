package thread.pc;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Producer extends Thread {

    static  Queue<Integer> sqs = new LinkedList<>();

    public Producer() {

        sqs.add(1);
    }


    @Override
    public void run() {


        produce();


    }

    public void produce() {

        while (true) {
            synchronized (Producer.sqs) {
//                if (sqs.size() > 10) {

//
//                    try {
//                        System.out.println("queue size limit is reached, sqs size: " + sqs.size());
//                        wait();
//                        System.out.println("Producer got the lock again");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                if (Producer.sqs.size() > 10) {

                    try {
                        System.out.println("producer will wait, sqs size is : " + sqs.size());
                        wait();
                        System.out.println("producer notified to continue");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                    int v = (int) (Math.random() * 100);
                    System.out.println("producing value: " + v + "  - time:" + new Date());
                Producer.sqs.add(v);

                }

            }
    }
}
