package facebookposition.fbquestions;

import java.util.Arrays;

public class ElementSwapping {

    public static void main(String[] args) {
        int n_1 = 3, k_1 = 2;
        int[] arr_1 = {5, 3, 1};
//        int[] expected_1 = {1, 5, 3};
        System.out.println(Arrays.toString(findMinArray(arr_1, k_1)));

        int n_2 = 5, k_2 = 3;
        int[] arr_2 = {8, 9, 11, 2, 1};
//        int[] expected_2 = {2, 8, 9, 11, 1};
        System.out.println(Arrays.toString(findMinArray(arr_2, k_2)));
    }

    public static int[] findMinArray(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n - 1 && k > 0; ++i) {
            int index = i;
            for (int j = i + 1; j < n; ++j) {
                if (j - i > k)
                    break;
                if (arr[j] < arr[index])
                    index = j;
            }
            int temp;
            for (int j = index; j > i; --j) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
            k -= index - i;
        }
        return arr;
    }

    public static void swap(int[] arr, int index, int times) {
        int temp = 0;
        for (int i = index; i < times; i++) {
            if (i - 1 < 0) break;
            temp = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = temp;
        }
    }
}


//    Element Swapping
//    Given a sequence of n integers arr, determine the lexicographically smallest sequence which may be obtained from it after performing at most k element swaps, each involving a pair of consecutive elements in the sequence.
//        Note: A list x is lexicographically smaller than a different equal-length list y if and only if, for the earliest index at which the two lists differ, x's element at that index is smaller than y's element at that index.
//        Signature
//        int[] findMinArray(int[] arr, int k)
//        Input
//        n is in the range [1, 1000].
//        Each element of arr is in the range [1, 1,000,000].
//        k is in the range [1, 1000].
//        Output
//        Return an array of n integers output, the lexicographically smallest sequence achievable after at most k swaps.
//        Example 1
//        n = 3
//        k = 2
//        arr = [5, 3, 1]
//        output = [1, 5, 3]
//        We can swap the 2nd and 3rd elements, followed by the 1st and 2nd elements, to end up with the sequence [1, 5, 3]. This is the lexicographically smallest sequence achievable after at most 2 swaps.
//        Example 2
//        n = 5
//        k = 3
//        arr = [8, 9, 11, 2, 1]
//        output = [2, 8, 9, 11, 1]
//        We can swap [11, 2], followed by [9, 2], then [8, 2].