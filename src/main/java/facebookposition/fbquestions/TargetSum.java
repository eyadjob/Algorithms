package facebookposition.fbquestions;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
//            int[] A = {1, 1, 1, 1, 1};
//        System.out.println(findTargetSumWays2(A, 3));

        int[] B = {1, 2, 3, 4, 5};
        System.out.println(findTargetSumWays2(B, 5));
    }


    public static int findTargetSumWays2(int[] nums, int s) {
        Map<Integer, Integer> dp = new HashMap();
        dp.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> dp2 = new HashMap();
            for (int tempSum : dp.keySet()) {
                int key1 = tempSum + num;
                dp2.put(key1, dp2.getOrDefault(key1, 0) + dp.get(tempSum));
                int key2 = tempSum - num;
                dp2.put(key2, dp2.getOrDefault(key2, 0) + dp.get(tempSum));
            }
            dp = dp2;
        }
        return dp.getOrDefault(s, 0);
    }
    public static  int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }
}

//
//    You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
//
//        Find out how many ways to assign symbols to make sum of integers equal to target S.
//
//        Example 1:
//
//        Input: nums is [1, 1, 1, 1, 1], S is 3.
//        Output: 5
//        Explanation:
//
//        -1+1+1+1+1 = 3
//        +1-1+1+1+1 = 3
//        +1+1-1+1+1 = 3
//        +1+1+1-1+1 = 3
//        +1+1+1+1-1 = 3
//
//        There are 5 ways to assign symbols to make the sum of nums be target 3.