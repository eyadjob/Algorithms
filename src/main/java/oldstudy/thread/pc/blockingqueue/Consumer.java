package oldstudy.thread.pc.blockingqueue;

public class Consumer implements Runnable {

    @Override
    public void run() {
        consume();
    }

    public void consume() {

        while (true) {
            try {

                if (Producer.qu.peek() == null) {
                    wait();
                } else {
                    System.out.println("consuming value: " + Producer.qu.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



