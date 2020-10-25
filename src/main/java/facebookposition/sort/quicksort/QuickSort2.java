package facebookposition.sort.quicksort;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = {12321, 123, 551, 995, 3, 5123, 4, 32};

        System.out.println(Arrays.toString(quickSort_divide(arr, 0, arr.length - 1)));
    }

    public static int[] quickSort_divide(int[] arr, int beg, int end) {

        if (beg < end) {
            int loc = conquer(arr, beg, end);
            quickSort_divide(arr, beg, loc - 1);
            quickSort_divide(arr, loc + 1, end);

        }
        return arr;
    }

    public static int conquer(int[] arr, int beg, int end) {
        int left = beg, right = end, loc = beg, flag = 0, temp;

        while (flag != 1) {
            while (arr[loc] <= arr[right] && loc != right)
                right--;

            if (loc == right) {
                flag = 1;
            } else {
                if (arr[loc] > arr[right]) {
                    temp = arr[loc];
                    arr[loc] = arr[right];
                    arr[right] = temp;
                }

                if ( flag != 1 ) {
                    while(arr[loc] >= arr[left] && loc != left)
                        left++;

                    if ( loc == left) {
                        flag = 1;

                    } else {
                        if (arr[loc] < arr[left]) {
                            temp = arr[loc];
                            arr[loc] = arr[left];
                            arr[left] = temp;
                        }
                    }

                }


            }


        }
        return loc;
    }

}
