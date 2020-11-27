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

//    Balanced Split
//    Given an array of integers (which may include repeated integers), determine if there's a way to split the array into two subsequences A and B such that the sum of the integers in both arrays is the same, and all of the integers in A are strictly smaller than all of the integers in B.
//        Note: Strictly smaller denotes that every integer in A must be less than, and not equal to, every integer in B.
//        Signature
//        bool balancedSplitExists(int[] arr)
//        Input
//        All integers in array are in the range [0, 1,000,000,000].
//        Output
//        Return true if such a split is possible, and false otherwise.
//        Example 1
//        arr = [1, 5, 7, 1]
//        output = true
//        We can split the array into A = [1, 1, 5] and B = [7].
//        Example 2
//        arr = [12, 7, 6, 7, 6]
//        output = false
//        We can't split the array into A = [6, 6, 7] and B = [7, 12] since this doesn't satisfy the requirement that all integers in A are smaller than all integers in B.
