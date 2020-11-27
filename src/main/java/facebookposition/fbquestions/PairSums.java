package facebookposition.fbquestions;

import java.util.HashMap;
import java.util.Map;

public class PairSums {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 7;

        System.out.println(numberOfWays(arr, k));
        System.out.println(numberOfWays2(arr, k));

        int[] arr2 = {1, 5, 3, 3, 3};
        int k2 = 6;
        System.out.println(numberOfWays(arr2, k2));
        System.out.println(numberOfWays2(arr2, k2));


    }


    public static int numberOfWays2(int[] arr, int target) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        // Store counts of all elements in map hm
        for (int i = 0; i < n; i++) {
            // initializing value to 0, if key not found
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < n; i++) {
            if (hm.get(target - arr[i]) != null)
                twice_count += hm.get(target - arr[i]);

            // if (arr[i], arr[i]) pair satisfies the condition,
            // then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i])
            // pair is not considered
            if (target - arr[i] == arr[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count / 2;
    }

    public static int numberOfWays(int[] arr, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0, count = 0;
        for (int n : arr) {
            sum += n;
            if (sum == k)
                count++;
            count += prefixSum.getOrDefault(sum - k, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return count;

    }
}




//    Pair Sums
//    Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
//        If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered different if one pair includes at least one array index which the other doesn't, even if they include the same values.
//        Signature
//        int numberOfWays(int[] arr, int k)
//        Input
//        n is in the range [1, 100,000].
//        Each value arr[i] is in the range [1, 1,000,000,000].
//        k is in the range [1, 1,000,000,000].
//        Output
//        Return the number of different pairs of elements which sum to k.
//        Example 1
//        n = 5
//        k = 6
//        arr = [1, 2, 3, 4, 3]
//        output = 2
//        The valid pairs are 2+4 and 3+3.
//        Example 2
//        n = 5
//        k = 6
//        arr = [1, 5, 3, 3, 3]
//        output = 4
//        There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements, and 4th and 5th elements).