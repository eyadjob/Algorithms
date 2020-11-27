package facebookposition.fbquestions;

import java.util.*;

public class AboveAverageSubarrays {

    public static void main(String[] args) {
        int[] A = {3, 4, 2};
        System.out.println(aboveAverageSubarrays(A, 6));
        System.out.println(subarraySum(A, 6));
        System.out.println(aboveAverage(A));

        System.out.println();
        int[][] test = new int[][]{{1, 2}, {2, 2}};
    }


    public static List<Integer[]> aboveAverage(int[] A) {
        Map<Integer, Integer> preSum = new HashMap<>();
        int[] preSumA = new int[A.length];
        List<Integer[]> result2 = new ArrayList<>();
        int[][] result = new int[20][2];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            preSumA[i] = sum;
        }
        int i = 0;
        while (i < A.length) {
            if (A[i] / 2 > (preSumA[A.length - 1] - preSumA[i < A.length-1 ? i+1 : i]) / 2) {
                result[i][0] = i;
                result[i][1] = i + 1;
                result2.add(new Integer[]{i,i+1});
            }
            if (preSumA[i] / 2 > (preSumA[A.length - 1] - preSumA[i > 0 ? i-1 : i]) / 2) {
                result[i][0] = i;
                result[i][1] = i + 1;
                result2.add(new Integer[]{i,i+1});
            }
            i++;
        }
        return result2;

    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        int twice_count = 0;
        for (int i = 0; i < n; i++) {
            if (hm.get(k - nums[i]) != null)
                twice_count += hm.get(k - nums[i]);

            if (k - nums[i] == nums[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count / 2;
    }

    public static int aboveAverageSubarrays(int[] A, int k) {
        int n = A.length, counter = 0, sum_i = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum_i += A[i];
            int sum_j = sum_i - k;
            if (prefixSum.containsKey(sum_j)) {
                counter += prefixSum.get(sum_j);
            } else {
                prefixSum.put(sum_i, prefixSum.getOrDefault(sum_i, 0) + 1);

            }
        }
        return counter;
    }


}


//    You are given an array A containing N integers. Your task is to find all subarrays whose average sum is greater than the average sum of the remaining array elements. You must return the start and end index of each subarray in sorted order.
//        A subarray that starts at position L1 and ends at position R1 comes before a subarray that starts at L2 and ends at R2 if L1 < L2, or if L1 = L2 and R1 ≤ R2.
//        Note that we'll define the average sum of an empty array to be 0, and we'll define the indicies of the array (for the purpose of output) to be 1 through N. A subarray that contains a single element will have L1 = R1.
//        Signature
//        Subarray[] aboveAverageSubarrays(int[] A)
//        Input
//        1 ≤ N ≤ 2,000
//        1 ≤ A[i] ≤ 1,000,000
//        Output
//        A Subarray is an object with two integer fields, left and right, defining the range that a given subarray covers. Return a list of all above-average subarrays sorted as explained above.
//        Example 1
//        A = [3, 4, 2]
//        output = [[1, 2], [1, 3], [2, 2]]
//        The above-average subarrays are [3, 4], [3, 4, 2], and [4].