package oldstudy.thread;

public class Executor2 {

    public static void main(String[] args) {
       Thread thread = new Thread(new ThreadImpelement());



        Thread thread2 = new Thread(new ThreadImpelement());
        thread.start();
        thread2.start();



    }


}
