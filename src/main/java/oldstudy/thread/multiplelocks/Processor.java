package oldstudy.thread.multiplelocks;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Processor {


    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    BankAccount bankAccount1 = new BankAccount();
    BankAccount bankAccount2 = new BankAccount();

    public static void main(String[] args) throws InterruptedException {
        Processor process = new Processor();

       Thread thread1 =  process.firstThread();
        Thread thread2 = process.secondThread();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Account 1 balance: " +process.bankAccount1.getAmount());
        System.out.println("Account 2 balance: " + process.bankAccount1.getAmount());
        System.out.println("two accounts total: " + process.bankAccount1.getAmount() + process.bankAccount2.getAmount());

    }

    public void showTotal() {

    }

    public void threadSychronizer(Lock firstLock, Lock secondLock)  {

        while (true) {
            // Acquire locks
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;
            try {

                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            } finally {
                if (gotFirstLock && gotSecondLock) return;
                else if (gotFirstLock) firstLock.unlock();
                else if (gotSecondLock) secondLock.unlock();
            }
            // Locks not acquired
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public Thread firstThread() {

        Random random = new Random();
        Thread thread = new Thread(() -> {

            for (int i = 0; i < 100; i++) {

                threadSychronizer(lock1,lock2);
                try {
                    BankAccount.transferAmount(bankAccount1, bankAccount2, random.nextInt(100));
                } finally {
                    System.out.println("first oldstudy.thread , final");
                    lock1.unlock();
                    lock2.unlock();
                }
            }
        });

        return thread;

    }

    public Thread secondThread() {

        Random random = new Random();

        Thread thread = new Thread(() -> {

            for (int i = 0; i < 100; i++) {

                threadSychronizer(lock1,lock2);
                try {
                    BankAccount.transferAmount(bankAccount2,bankAccount1 , random.nextInt(100));
                } finally {

                    lock1.unlock();
                    lock2.unlock();
                }
            }
        });
        return thread;
    }


}


