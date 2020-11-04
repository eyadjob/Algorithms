package facebookposition.fbquestions;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BalancedSplit {

    public static void main(String[] args) {

        int arr_1[] = {2, 1, 2, 5};
        boolean expected_1 = true;
        boolean output_1 = balancedSplitExists(arr_1);
        System.out.println(balancedSplitExists(arr_1));

        int arr_2[] = {3, 6, 3, 4, 4};
        boolean expected_2 = false;
        boolean output_2 = balancedSplitExists(arr_2);
        System.out.println(balancedSplitExists(arr_2));

    }

    public static boolean balancedSplitExists2(int[] arr) {
        Arrays.sort(arr);
        AtomicInteger start = new AtomicInteger(0);
        AtomicInteger end = new AtomicInteger(arr.length-1);
        while ( start.get() < end.get()) {
          int leftSum = Arrays.stream(arr).filter(n -> n < start.get()).boxed().mapToInt(d -> d).sum();
          int rightSum = Arrays.stream(arr).filter(n -> n > start.get() && n < end.get() ).boxed().mapToInt(d -> d).sum();
          if ( leftSum == rightSum) return true;
          start.getAndIncrement();
        }
    return false;
    }


    public static boolean balancedSplitExists(int[] arr) {
        Arrays.sort(arr);
        int start=0, end = arr.length-1, leftSum =0, rightSum=0;
        while ( start < end) {
            leftSum+=arr[start];
            for (int i = start+1; i <= end; i++) rightSum+=arr[i];
            if ( leftSum == rightSum && arr[start] < arr[start+1] ) return true;
            start++;
            rightSum=0;
        }
        return false;
    }
}
