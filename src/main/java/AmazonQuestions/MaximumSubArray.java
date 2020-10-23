package AmazonQuestions;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubArray {



    public static int [] maxSubArray (int [] array) {
        int starting_index = 0;
        int length = 0;
        int sum = 0;

        int t_starting_index = 0;
        int t_length = 0;
        int t_sum = 0;

        for (int i = 0; i < array.length; i++) {
            if(t_sum + array[i] > 0) {
                t_sum += array[i];
                t_length++;

                if(t_sum > sum) {
                    sum = t_sum;
                    length = t_length;
                    starting_index = t_starting_index;
                }
            } else {
                t_sum = 0;
                t_length = 0;
                t_starting_index = i + 1;
            }
        }

        int [] sub = new int[length];

        System.arraycopy(array, starting_index, sub, 0, length);

        return sub;
    }


    public static int largestSum(int[] arr) {

        int sum = 0;
        int temp = 0;
        List<Integer> re = new ArrayList<>();
        List<Integer> tempArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            temp=arr[i];
            for (int k = i + 1; k < arr.length; k++) {

                temp +=  arr[k];

                if (sum < temp) {
                    re = tempArr;
                    sum =temp;
                }
            }
        }

        return sum;
    }


    public static void main(String[] args) {


        int[] arra = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(largestSum(arra));


    }
}
