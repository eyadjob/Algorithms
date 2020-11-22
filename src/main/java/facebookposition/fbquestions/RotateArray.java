package facebookposition.fbquestions;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
                int k = 3;
//        Output: [5,6,7,1,2,3,4]
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

//
//    Given an array, rotate the array to the right by k steps, where k is non-negative.
//
//        Follow up:
//
//        Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//        Could you do it in-place with O(1) extra space?
//
//
//        Example 1:
//
//        Input: nums = [1,2,3,4,5,6,7], k = 3
//        Output: [5,6,7,1,2,3,4]
//        Explanation:
//        rotate 1 steps to the right: [7,1,2,3,4,5,6]
//        rotate 2 steps to the right: [6,7,1,2,3,4,5]
//        rotate 3 steps to the right: [5,6,7,1,2,3,4]
//        Example 2:
//
//        Input: nums = [-1,-100,3,99], k = 2
//        Output: [3,99,-1,-100]
//        Explanation:
//        rotate 1 steps to the right: [99,-1,-100,3]
//        rotate 2 steps to the right: [3,99,-1,-100]
//
//
//        Constraints:
//
//        1 <= nums.length <= 2 * 104
//        -231 <= nums[i] <= 231 - 1
//        0 <= k <= 105
//        Accepted
//        598,697
//        Submissions
//        1,658,943
//        Seen this question in a real interview before?
//
//        Yes
//
//        No
//        0 ~ 6 months6 months ~ 1 year1 year ~ 2 years
//
//        Facebook
//        |
//        5
//
//        Microsoft
//        |
//        3
//
//        Apple
//        |
//        2
//        Rotate List
//        Medium
//        Reverse Words in a String II
//        Medium
//        The easiest solution would use additional memory and that is perfectly fine.
//        The actual trick comes when trying to solve this problem without using any additional memory. This means you need to use the original array somehow to move the elements around. Now, we can place each element in its original location and shift all the elements around it to adjust as that would be too costly and most likely will time out on larger input arrays.
//        One line of thought is based on reversing the array (or parts of it) to obtain the desired result. Think about how reversal might potentially help us out by using an example.
//        The other line of thought is a tad bit complicated but essentially it builds on the idea of placing each element in its original position while keeping track of the element originally in that position. Basically, at every step, we place an element in its rightful position and keep track of the element already there or the one being overwritten in an additional variable. We can't do this in one linear pass and the idea here is based on cyclic-dependencies between elements.