package oldstudy.thread;

public class ThreadInnerImplement {
    public static  int count=0;

    public static   synchronized int  increaseCount() {
        ++count;
        return count;
    }

    public static  void main(String[] args) throws InterruptedException {



        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increaseCount();
                }

            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                    for (int i = 0; i < 10000; i++) {
                        increaseCount();
                    }

                }
            });

        thread.start();

        thread2.start();
thread.join();
thread.join();
        System.out.println("counter value is " + increaseCount());
    }

}

