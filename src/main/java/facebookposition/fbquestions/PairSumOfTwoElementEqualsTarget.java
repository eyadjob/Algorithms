package facebookposition.fbquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairSumOfTwoElementEqualsTarget {


    public static void main(String[] args) {
        int[] nums = {2,7,2,7};
        int target = 9;
//        Output: [0,1]
//        Output: Because nums[0] + nums[1] == 9, we return [0, 1].
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }


    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}


//    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        You can return the answer in any order.
//
//
//
//        Example 1:
//
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//        Example 2:
//
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]
//        Example 3:
//
//        Input: nums = [3,3], target = 6
//        Output: [0,1]
//
//
//        Constraints:
//
//        2 <= nums.length <= 103
//        -109 <= nums[i] <= 109
//        -109 <= target <= 109
//        Only one valid answer exists.
//        Accepted