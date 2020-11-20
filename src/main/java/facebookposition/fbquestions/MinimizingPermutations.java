package facebookposition.fbquestions;

import java.util.Arrays;

public class MinimizingPermutations {



    public static void main(String[] args) {

        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        System.out.println(output_1);

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        System.out.println(output_2);


    }

    static int minOperations(int[] arr) {
        counter=0;
        minOperationsRe(arr, 0, arr.length - 1);
        return counter;
    }

    static int counter=0;
    public static int minOperationsRe(int[] arr, int l, int r) {

        if (l == r) {
//            System.out.println(Arrays.toString(arr));
            return 1;
        } else
            for (int i = l; i <= r; i++) {
                if (arr[i] < arr[l] && i > l) {
                    swap(arr, l, i);
                    counter++;
                }
                if (i > l )
                    minOperationsRe(arr, l + 1, r);
                if (arr[i] < arr[l] && i > l) {
                    swap(arr, l, i);
                    counter++;
                }
//                    System.out.println(Arrays.toString(arr));

            }
        System.out.println(Arrays.toString(arr));
        return counter;
    }

    public static int[] swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

}
