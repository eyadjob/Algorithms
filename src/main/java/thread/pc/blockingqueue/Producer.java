package thread.pc.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Producer implements Runnable {

    public static BlockingQueue<Integer> qu = new LinkedBlockingDeque<>(10);

    public Producer() {

        qu.add(1);
        System.out.println("in constructor after adding value to qu: " + qu.peek());
    }


    @Override
    public void run() {

        produce();
    }

    public void produce() {

        while (true) {

            System.out.println("producing value " + 1);
            try {
                qu.put(qu.peek() + 1);
                notify();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
