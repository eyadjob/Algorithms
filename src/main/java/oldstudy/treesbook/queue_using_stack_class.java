package oldstudy.treesbook;

import java.util.Stack;

public class queue_using_stack_class {


    public static Stack<Integer> s = new Stack<>();
    public static Stack<Integer> temp = new Stack<>();

    public static void enqueue(int i) {

        s.push(i);


    }


    public static Integer dequeue() {
        if (!isEmpty()) {


            for (int e : s
            ) {
                temp.push(e);

            }
            int va = temp.pop();

            for (int e : temp ) {
                s.push(e);
            }
          return  va;

        }
           return null;

    }


    public static Boolean isEmpty() {
         if ( s.size() == 0 )
             return true;

     return false;
    }

    public static void main(String[] args) {
        try {
            queue_using_stack_class qsc = new queue_using_stack_class();
//            queue_using_stack_class.queue_using_stack qs = qsc.new queue_using_stack();

            System.out.println("qs.enqueue(1,2,4)");
            enqueue(1);
            enqueue(2);
            enqueue(4);

            System.out.println("qs.dequeue()" + "= " + dequeue());
            System.out.println("qs.enqueue(3)");
            enqueue(3);
            System.out.println("qs.dequeue()" + "= " + dequeue());
            System.out.println("qs.dequeue()" + "= " + dequeue());
            System.out.println("qs.dequeue()" + "= " + dequeue());
        } catch (Exception ex) {
            System.out.println("Exception");
        }
    }


}
