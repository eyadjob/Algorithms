package thread.threaddumb;

public class FirstExample {

    public static void main(String[] args) {
        System.out.println("Hello world ");

        sleep();
        System.out.println("finished");
    }


    public static void sleep(){

        try {
            Thread.sleep(1050000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
