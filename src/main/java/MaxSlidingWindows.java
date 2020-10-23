import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindows {

    public ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {

        ArrayDeque<Integer> result = new ArrayDeque<>(); // ArrayDeque for storing values

        if (arr.length > 0) {

            Deque<Integer> list = new LinkedList<Integer>(); // creating a linked list

            if (arr.length < windowSize) // Invalid State
                return result;

            int startingIndex = 0;

            for (int i = startingIndex; i < windowSize; ++i) {
                // Removing last smallest element index
                while (!list.isEmpty() && arr[i] >= arr[list.peekLast()])
                    list.removeLast();

                // Adding newly picked element index
                list.addLast(i);

                startingIndex = i + 1; // Next starting index
            }

            for (int i = startingIndex; i < arr.length; ++i) {
                result.add(arr[list.peek()]);

                // Removeing all the elements indexes which are not in the current window
                while ((!list.isEmpty()) && list.peek() <= i - windowSize)
                    list.removeFirst();

                // Removing the smaller elements indexes which are not required
                while ((!list.isEmpty()) && arr[i] >= arr[list.peekLast()])
                    list.removeLast();

                // Adding newly picked element index
                list.addLast(i);

            }

            // Adding the max number of the current window in the result
            result.add(arr[list.peek()]);

            return result; // returning result
        } else
            return result;
    }


    public static void main(String[] args) {

        int[] arr = new int[1000];
        for ( int i=0; i < 1000; i++) {
            arr[i]=i+1;
        }
        MaxSlidingWindows maxSlidingWindows = new MaxSlidingWindows();
        System.out.println(  maxSlidingWindows.findMaxSlidingWindow(arr, 3).toString());
//     System.out.println(  findMaxSlidingWindow(arr, 2).toString());
    }
}
