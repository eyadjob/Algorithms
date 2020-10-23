package oldstudy.thread.pc.blockingqueue;

public class Executor {

    public static void main(String[] args) throws InterruptedException {

        Thread  producer = new Thread(new Producer());
        producer.start();

        Thread consumer = new Thread(new Consumer());
        consumer.start();
        producer.join();
        consumer.join();


        System.out.println("this should never be displayed to user");
    }


}
