package facebookposition.fbquestions;

public class prefixSumWithBruteForce {

    public static void main(String[] args) {

    }

   public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // initialize prefix sum
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];

        int ans = 0;
        // loop through all subarrays by brute force
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                // sum of nums[j..i-1]
                if (sum[i] - sum[j] == k)
                    ans++;

        return ans;
    }
}


//    Coming back to the original problem. If we want to find the number of subarrays which sums to k respectively, it's straightforward to implement using Prefix Sum technique:

