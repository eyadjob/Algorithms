package facebookposition.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MergeSort {
    static AtomicInteger counter= new AtomicInteger(0);
    public static void main(String[] args) {

        int[] a = {10, 5, 2, 23, 45, 21, 7, 3, 1, 4, 8, 6};
        System.out.println(Arrays.toString(divide(a, 0, a.length - 1)));
        System.out.println(counter);
    }


    public static int[] divide(int[] arr, int beg, int end) {
        if (beg < end) {
            counter.getAndIncrement();
            System.out.println();
            int mid = (beg + end) / 2;
            divide(arr, beg, mid);
            System.out.println();
            divide(arr, mid + 1, end);
            mergeSort(arr, beg, mid, end);

        }

        return arr;
    }

    public static int[] mergeSort(int[] arr, int beg, int mid, int end) {
        int ls = mid - beg + 1;
        int rs = end - mid;
        int[] leftArray = new int[ls];
        int[] rightArray = new int[rs];

        for (int i = 0; i < ls; i++) {
            System.out.println();
            leftArray[i] = arr[beg + i];
            System.out.println();

        }
        for (int i = 0; i < rs; i++) {
            System.out.println();
            rightArray[i] = arr[mid + 1 + i];
            System.out.println();

        }

        int i = 0, j = 0;
        int k = beg;
        while (i < ls && j < rs) {
            counter.getAndIncrement();
            if (leftArray[i] <= rightArray[j]) {
                System.out.println();
                arr[k] = leftArray[i];
                i++;
                System.out.println();
            } else {
                System.out.println();
                arr[k] = rightArray[j];
                j++;
                System.out.println();
            }
            k++;
        }
        while (i < ls) {
            counter.getAndIncrement();
            System.out.println();
            arr[k] = leftArray[i];
            i++;
            k++;
            System.out.println();
        }

        while (j < rs) {
            counter.getAndIncrement();
            System.out.println();
            arr[k] = rightArray[j];
            j++;
            k++;
            System.out.println();
        }
        return arr;
    }
}
