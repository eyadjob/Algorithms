package facebookposition.fbquestions;

import java.util.*;

public class MaxContinuousLengthArithmeticProg {

    static int max2 = 0;
    static int max = 0;

    public static void main(String[] args) {

        int[] B = {20, 1, 16, 3, 10, 5, 8};
        System.out.println(longestArithSeqLength4(B));
        System.out.println(longestArithSeqLength2(B));

        int[] A = {3, 6, 9, 12};
        System.out.println(longestArithSeqLength4(A));
        System.out.println(longestArithSeqLength2(A));

        int[] C = {9,4,7,2,10};
        System.out.println(longestArithSeqLength4(C));
        System.out.println(longestArithSeqLength2(C));


    }

    public static int longestArithSeqLength4(int[] A) {
        max2=0;
        List<Map<Integer, Integer>> result = new ArrayList<>();
        for (int index = 0; index < A.length; index++) {
            result.add(getMapWithDiffFrequencyValue(A, index, result));
        }
        return max2;
    }

    public static Map<Integer, Integer> getMapWithDiffFrequencyValue(int[] A, int index, List<Map<Integer, Integer>> result) {
        Map<Integer, Integer> currentMap = new HashMap<>();
        for (int i = 0; i < index; i++) {
            Map<Integer, Integer> previousMap = result.get(i);
            int diff = A[index] - A[i];
            int value = previousMap.getOrDefault(diff,1);
            currentMap.put(diff, value+1);
            max2 = Math.max(max2, value+1);
        }
        return currentMap;
    }

    public static int longestArithSeqLength2(int[] A) {
        final List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int index = 0; index < A.length; index++) {
            list.add(getMapForCurrentNumber(A, index, list));
        }
        return max;
    }

    private static Map<Integer, Integer> getMapForCurrentNumber(int[] nums, int index, List<Map<Integer, Integer>> list) {
        final Map<Integer, Integer> currentIndexMap = new HashMap<>();
        for (int i = 0; i < index; i++) {
            Map<Integer, Integer> previousNumberMap = list.get(i);
            int diff = nums[index] - nums[i];
            int value = previousNumberMap.getOrDefault(diff, 1);
            currentIndexMap.put(diff, value + 1);
            max = Math.max(max, value + 1);
        }
        return currentIndexMap;
    }

    public static int longestArithSeqLength3(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][1501];
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                dp[i][diff + 1000] = dp[j][diff + 1000] == 0 ? 2 : dp[j][diff + 1000] + 1;
                max = Math.max(max, dp[i][diff + 1000]);
            }
        }
        return max;
    }


    public static int longestArithSeqLength(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][1001];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], 1);
        int ans = 2;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int d = A[i] - A[j];

                dp[i][d + 500] = dp[j][d + 500] + 1;
                ans = Math.max(dp[i][d + 500], ans);
            }
        }
        return ans;
    }
}
