package facebookposition.fbquestions;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates2(nums));;
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;
    }

    public static int removeDuplicates2(int[] num) {
        int i = num.length > 0 ? 1 : 0;
        for ( int n : num) {
            if (n > num[i-1]) {
                num[i++] = n;
            }
        }
        return i;
    }
}



