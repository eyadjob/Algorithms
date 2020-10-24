package oldstudy.study;

import java.util.concurrent.atomic.AtomicInteger;

public class PassingArguments {


    private int y =10;
    private Integer x = 10;
    AtomicInteger xx = new AtomicInteger(10);



    public void add(int y, int x, AtomicInteger xx) {
        ++x;
        ++y;
        xx.getAndIncrement();
    }
    public static void main(String[] args) {

        PassingArguments pas = new PassingArguments();

        pas.add (pas.y,pas.x,pas.xx);
        System.out.println(pas.x);
        System.out.println(pas.y);
        System.out.println(pas.xx);
    }


}
