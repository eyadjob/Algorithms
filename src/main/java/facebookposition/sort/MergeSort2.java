package facebookposition.sort;

import java.util.Arrays;

public class MergeSort2 {

    public static void main(String[] args) {
        int[] arr = {53,2,67,3,11,73,12};
        System.out.println(Arrays.toString(divide(arr,0,arr.length-1)));
    }

    public static int[] divide(int[] arr, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            divide(arr, beg, mid);
            divide(arr, mid + 1, end);
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
            rightArray[i] = arr[mid + 1 + i];
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
