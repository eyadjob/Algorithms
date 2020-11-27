package facebookposition.fbquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContiguousSubarrays {


    public static void main(String[] args) {
        //output = [1, 3, 1, 5, 1]
        int[] arr = {3, 4, 1, 6, 2};
        System.out.println(Arrays.toString(countSubarrays(arr)));

    }

    public static int[] countSubarrays(int[] arr) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(arr.length, 0));
        for (int i = 0; i < arr.length; i++) {
            for (int k = i; k < arr.length; k++) {
                if (arr[i] >= arr[k]) result.set(i, result.get(i) + 1);
                else break;
            }
            for (int r = i-1; r >= 0; r--) {
                if (arr[i] >= arr[r]) result.set(i, result.get(i) + 1);
                else break;
            }
        }
        return result.stream().mapToInt(d -> d).toArray();
    }
}

//HEAPS
//    Contiguous Subarrays
//    You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfills the following conditions:
//        The value at index i must be the maximum element in the contiguous subarrays, and
//        These contiguous subarrays must either start from or end on index i.
//        Signature
//        int[] countSubarrays(int[] arr)
//        Input
//        Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
//        Size N is between 1 and 1,000,000
//        Output
//        An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
//        Example:
//        arr = [3, 4, 1, 6, 2]
//        output = [1, 3, 1, 5, 1]
//        Explanation:
//        For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
//        For index 1 - [4], [3, 4], [4, 1]
//        For index 2 - [1]
//        For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
//        For index 4 - [2]
//        So, the answer for the above input is [1, 3, 1, 5, 1]