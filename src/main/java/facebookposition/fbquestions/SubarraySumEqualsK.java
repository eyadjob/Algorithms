package facebookposition.fbquestions;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {


    public static void main(String[] args) {

        int[] nums4 = {1,2,3,4,2,6,7,1,5,0};
        int k3 = 6;
//        Output: 2
        System.out.println(subarraySum3(nums4,k3));

        int[] nums = {1,1,1};
        int k = 2;
//        Output: 2;
        System.out.println(subarraySum3(nums,k));

        int[] nums2 = {1,2,3};
        int k2 = 3;
//        Output: 2
        System.out.println(subarraySum(nums2,k2));



    }

    public static int subarraySum3(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0, count = 0;
        for(int n : nums){
            sum += n;
            if(sum == k)
                count++;
            count += prefixSum.getOrDefault(sum-k, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
            // Edge cases
            if(nums.length == 0)    return 0;

            // Sliding window -- No, contains negative number
            // hashmap + preSum
        /*
            1. Hashmap<sum[0,i - 1], frequency>
            2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
                   k           sum      hashmap-key     -->  hashmap-key  =  sum - k
            3. now, we have k and sum.
                  As long as we can find a sum[0, i - 1], we then get a valid subarray
                 which is as long as we have the hashmap-key,  we then get a valid subarray
            4. Why don't map.put(sum[0, i - 1], 1) every time ?
                  if all numbers are positive, this is fine
                  if there exists negative number, there could be preSum frequency > 1
        */
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int result = 0;
            map.put(0, 1);
            for(int cur : nums) {
                sum += cur;
                if(map.containsKey(sum - k))  // there exist a key, that [hashmap-key  =  sum - k]
                    result += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return result;
        }

    public static int subarraySum(int[] num, int k) {
        Map<Integer,Integer> initialSum = new HashMap<>();

        for (int i =0; i < num.length;i++) {
            initialSum.put(i,initialSum.getOrDefault(i,num[i]) + (i == 0 ? 0 : initialSum.get(i-1)));

        }
        for ( int i =0; i < num.length;i--);
        System.out.println("test");

        return 1;
    }
}
