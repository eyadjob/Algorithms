package facebookposition.fbquestions;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
//        Output: [24,12,8,6]
        System.out.println(Arrays.toString(productExceptSelf(a)));
        System.out.println(Arrays.toString(productExceptSelf2(a)));

    }


    public static int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];

        for ( int i =0,temp =1; i < nums.length;i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        for ( int i =nums.length-1, temp = 1; i >=0;i--) {
            result[i] *= temp;
            temp  *= nums[i];
        }
        return result;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;

    }
}
