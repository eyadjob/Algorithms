package facebookposition.sort.quicksort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int i;
        int[] arr = {90, 23, 101, 45, 65, 23, 67, 89, 34, 23};
        System.out.println(Arrays.toString(quickSortDivide(arr, 0, arr.length - 1)));

    }

    public static int conquer(int[] arr, int beg, int end) {
        int left, right, temp, loc, flag;
        loc = left = beg;
        right = end;
        flag = 0;

        while (flag != 1) {
            while ((arr[loc] <= arr[right]) && (loc != right))
                right--;

            if (loc == right) {
                flag = 1;
            } else if (arr[loc] > arr[right]) {
                temp = arr[loc];
                arr[loc] = arr[right];
                arr[right] = temp;
                loc = right;
            }
            if (flag != 1) {
                while (arr[loc] >= arr[left] && loc != left) 
                    left++;

                if (loc == left) {
                    flag = 1;
                } else if (arr[loc] < arr[left]) {
                    temp = arr[loc];
                    arr[loc] = arr[left];
                    arr[left] = temp;

                }
            }
        }
        return loc;
    }

    public static int[] quickSortDivide(int[] arr, int beg, int end) {
        int loc;
        if (beg < end) {
            loc = conquer(arr, beg, end);
            quickSortDivide(arr, beg, loc - 1);
            quickSortDivide(arr, loc + 1, end);
        }
        return arr;
    }
}
