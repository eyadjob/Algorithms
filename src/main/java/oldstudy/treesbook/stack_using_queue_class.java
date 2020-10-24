package oldstudy.treesbook;

import java.util.ArrayDeque;
import java.util.Queue;

public class stack_using_queue_class {


    public static int size;
    public static Queue<Integer> q = new ArrayDeque<>();
    public static Queue<Integer> temp = new ArrayDeque<>();

    public static void push(int i) {

        if (!isEmpty())

            for (int e : q) {
                temp.add(e);

            }

        q.add(i);
        for (int e : temp) {
            q.add(e);
        }
        size++;

    }

    public static String pop() {
        if (!isEmpty()) {
            size--;
            return String.valueOf(q.poll());
        }
        return null;

    }


    public static boolean isEmpty() {
        if ( size == 0)
            return true;

        return false;


    }


    public static void main(String[] args) {
        try {
            stack_using_queue_class sq = new stack_using_queue_class();
//            stack_using_queue_class.stack_using_queue sq = sqc.new stack_using_queue();

            System.out.println("sq.push(1), sq.push(2)");
            push(1);
            push(2);

            System.out.println("sq.pop() = " + (pop()));

            System.out.println("sq.push(3)");

            push(3);
            System.out.println("sq.pop() = " + (pop()));

        } catch (Exception ex) {
        }
    }
}
