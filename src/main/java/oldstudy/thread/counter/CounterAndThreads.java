package oldstudy.thread.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterAndThreads extends Thread{

    public int counter =0;
    public static int staticCounter =0;
    public  AtomicInteger atomicInteger = new AtomicInteger(0);
    public static  AtomicInteger staticAtomicInteger = new AtomicInteger(0);
    public ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

   public CounterAndThreads() {
        this.integerThreadLocal.set(1);
    }

    @Override
    public void run() {

        for ( int i =0;  i < 100000; i++) {
            counter++;

            if ( integerThreadLocal.get()  == null ) {
                integerThreadLocal.set(1);
            }
            atomicInteger.getAndIncrement();

            integerThreadLocal.set(integerThreadLocal.get() + 1);
            staticCounter++;
            staticAtomicInteger.getAndIncrement();

        }

    }


    public static void main(String[] args) throws InterruptedException {

        CounterAndThreads counterAndThreads = new CounterAndThreads();
        counterAndThreads.start();;

        CounterAndThreads counterAndThreads2 = new CounterAndThreads();
        counterAndThreads2.start();

        counterAndThreads.join();
        counterAndThreads2.join();
        System.out.println("First object counter : "  + counterAndThreads.counter);

        System.out.println("Second object counter : "  + counterAndThreads2.counter);
        System.out.println("Atomic integer first object counter : "  + counterAndThreads.atomicInteger.get());
        System.out.println("Atomic integer first object counter : "  + counterAndThreads.atomicInteger.get());
        System.out.println("Atomic integer second object counter : "  + counterAndThreads2.atomicInteger.get());

        System.out.println("Static Atomic integer second object counter : "  + CounterAndThreads.staticAtomicInteger.get());


        System.out.println("Thread local integer first  object counter : "  + counterAndThreads.integerThreadLocal.get());
        System.out.println("Thread local integer second object counter : "  + counterAndThreads2.integerThreadLocal.get());

        System.out.println("static integer first  object counter : "  + CounterAndThreads.staticCounter);


    }
}
