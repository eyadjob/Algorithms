package facebookposition.fbquestions;

import java.util.*;

public class MaxContinuousLengthArithmeticProg {

    public static void main(String[] args) {

        int[] B = {20,1,15,3,10,5,8};
        System.out.println(longestArithSeqLength(B));
        System.out.println(longestArithSeqLength2(B));

       int[] A = {3,6,9,12};
        System.out.println(longestArithSeqLength(A));
        System.out.println(longestArithSeqLength2(A));

    }

    static int max = 0;
    public static int longestArithSeqLength2(int[] A) {
        final List<Map<Integer, Integer>> list = new ArrayList<>();
        for(int i=0; i<A.length; i++){
            list.add(getMapForCurrentNumber(A, i, list));
        }

        return max;
    }

     private static Map<Integer, Integer> getMapForCurrentNumber(int[]nums, int index, List<Map<Integer, Integer>> list){
        final Map<Integer, Integer> currentIndexMap = new HashMap<>();
        for(int i=0; i<index; i++){
            Map<Integer, Integer> previousNumberMap = list.get(i);
            int diff = nums[index] - nums[i];
            int value = previousNumberMap.getOrDefault(diff, 1);
            currentIndexMap.put(diff, value+1);
            max = Math.max(max, value+1);
        }
        return currentIndexMap;
    }

    public static int longestArithSeqLength3(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][1501];
        int max = 0;
        for(int i=0; i<len; i++){
            for(int j=0; j<i; j++){
                int diff = A[i]-A[j];
                dp[i][diff+1000] = dp[j][diff+1000] == 0 ? 2 : dp[j][diff+1000]+1;
                max = Math.max(max, dp[i][diff+1000]);
            }
        }
        return max;
    }



    public static int longestArithSeqLength(int[] A) {
        int n=A.length;
        int dp[][]=new int[n][1001];

        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],1);
        int ans=2;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                int d=A[i]-A[j];

                dp[i][d+500]=dp[j][d+500]+1;
                ans=Math.max(dp[i][d+500],ans);
            }
        }
        return ans;
    }
}
