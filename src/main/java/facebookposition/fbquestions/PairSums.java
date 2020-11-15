package facebookposition.fbquestions;

import java.util.HashMap;
import java.util.Map;

public class PairSums {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 3, 3};
        int k = 6;
        System.out.println(numberOfWays(arr, k));
        System.out.println(numberOfWays2(arr, k));
    }


    public static int numberOfWays2(int[] arr, int sum) {

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
            if (hm.get(sum - arr[i]) != null)
                twice_count += hm.get(sum - arr[i]);

            // if (arr[i], arr[i]) pair satisfies the condition,
            // then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i])
            // pair is not considered
            if (sum - arr[i] == arr[i])
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
