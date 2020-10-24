package oldstudy.thread.countdownlatch.mytry;

public class Worker3 extends Thread {


    public int counter = 0;

    public synchronized void increment() {
        ProcessorThreadLocal.syncMethodCounter++;
    }


    @Override
    public void run() {

        synchronized (ProcessorThreadLocal.class) {
        for (int i = 0; i < 10000000; i++) {
//            increment();

                ProcessorThreadLocal.syncMethodCounter++;
            }
        }

    }
}
