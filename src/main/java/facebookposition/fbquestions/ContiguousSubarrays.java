package facebookposition.fbquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContiguousSubarrays {


    public static void main(String[] args) {
        //output = [1, 3, 1, 5, 1]
        int[] arr = {3, 4, 1, 6, 2};
        System.out.println(Arrays.toString(countSubarrays(arr)));

    }

    public static int[] countSubarrays(int[] arr) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(arr.length, 0));
        for (int i = 0; i < arr.length; i++) {
            for (int k = i; k < arr.length; k++) {
                if (arr[i] >= arr[k]) result.set(i, result.get(i) + 1);
                else break;
            }
            for (int r = i-1; r >= 0; r--) {
                if (arr[i] >= arr[r]) result.set(i, result.get(i) + 1);
                else break;
            }
        }
        return result.stream().mapToInt(d -> d).toArray();
    }
}
