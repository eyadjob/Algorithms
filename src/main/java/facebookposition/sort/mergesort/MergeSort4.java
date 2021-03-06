package facebookposition.sort.mergesort;

import java.util.Arrays;

public class MergeSort4 {


    public static void main(String[] args) {
        int[] arr = {134, 5, 11323, 64, 12, 35, 1991, 3, 16, 03};

        System.out.println(Arrays.toString(mergeSort_divide(arr, 0, arr.length - 1)));

    }

    public static int[] mergeSort_divide(int[] arr, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort_divide(arr, beg, mid);
            mergeSort_divide(arr, mid + 1, end);
            conquer(arr, beg, mid, end);

        }

        return arr;
    }

    public static int[] conquer(int[] arr, int beg, int mid, int end) {
        int ls = mid - beg + 1;
        int rs = end - mid;
        int[] leftArray = new int[ls];
        int[] rightArray = new int[rs];

        for (int i = 0; i < ls; i++) {
            leftArray[i] = arr[beg + i];
        }
        for (int i = 0; i < rs; i++) {
            rightArray[i] = arr[mid + 1 +i];
        }

        int i = 0, j = 0, k = beg;
        while (i < ls && j < rs) {
            if (leftArray[i] < rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < ls) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rs) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
        return arr;
    }
}
