package facebookposition.fbquestions;

import java.util.Arrays;

public class SlowSums {
    public static void main(String[] args) {

        int[] arr_1 = {4, 2, 1, 3};
        System.out.println(getTotalTime(arr_1));
        int[] arr_2 = {2, 3, 9, 8, 4};
        System.out.println(getTotalTime(arr_2));

    }

    public static int getTotalTime(int[] arr) {
        Arrays.sort(arr);
        for (int i =arr.length-1; i >=0; i--) {
            arr[i-1] = arr[i] + arr[i-1];
            if ( i == 1 ) break;
        }
        arr[arr.length-1] =0;
        return Arrays.stream(arr).sum();
    }

}
