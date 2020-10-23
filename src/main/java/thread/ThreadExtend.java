package thread;

public class ThreadExtend extends Thread {

    @Override
    public void run() {
        for (int i=0; i < 10; i++) {
            System.out.println(Thread.currentThread().getId() + " i value : " + i);
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}
