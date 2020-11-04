package facebookposition.fbquestions;

import java.util.Arrays;

public class SeatingArrangements {

    public static void main(String[] args) {
        int[] arr_1 = {5, 10, 6, 8};
        int expected_1 = 4;
        System.out.println(minOverallAwkwardness(arr_1));

        int[] arr_2 = {1, 2, 5, 3, 7};
        int expected_2 = 4;
        System.out.println(minOverallAwkwardness(arr_2));
    }


    public static int minOverallAwkwardness(int[] arr) {
        Arrays.sort(arr);
        int te = arr[0];
        int i = arr.length % 2 == 0 ? (arr.length / 2) - 1 : (arr.length / 2);
        arr[0] = arr[i];
        arr[i] =te;
        return arr[arr.length-1] - arr[0];
    }
}
