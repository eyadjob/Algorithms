package thread.chapt6;

import thread.chapt5.CalculatorRunnable;

public class ThreadStatus {

    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread();
        CalculatorRunnable runnable = new CalculatorRunnable(30000000000L);

        Thread thread = new Thread(runnable);
        thread.setName("High Priority");
        thread.start();

        long startTime = System.currentTimeMillis();
        thread.join(1000);
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Joing completed within: " + timeTaken + " for thread: " + Thread.currentThread().getName());

        System.exit(0);
    }
}
