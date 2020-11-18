package facebookposition.fbquestions;

import java.util.Arrays;

public class ElementSwapping {

    public static void main(String[] args) {
        int n_1 = 3, k_1 = 2;
        int[] arr_1 = {5, 3, 1};
//        int[] expected_1 = {1, 5, 3};
        System.out.println(Arrays.toString(findMinArray(arr_1, k_1)));

        int n_2 = 5, k_2 = 3;
        int[] arr_2 = {8, 9, 11, 2, 1};
//        int[] expected_2 = {2, 8, 9, 11, 1};
        System.out.println(Arrays.toString(findMinArray(arr_2, k_2)));
    }

    public static int[] findMinArray(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n - 1 && k > 0; ++i) {
            int index = i;
            for (int j = i + 1; j < n; ++j) {
                if (j - i > k)
                    break;
                if (arr[j] < arr[index])
                    index = j;
            }
            int temp;
            for (int j = index; j > i; --j) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
            k -= index - i;
        }
        return arr;
    }

    public static void swap(int[] arr, int index, int times) {
        int temp = 0;
        for (int i = index; i < times; i++) {
            if (i - 1 < 0) break;
            temp = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = temp;
        }
    }
}
