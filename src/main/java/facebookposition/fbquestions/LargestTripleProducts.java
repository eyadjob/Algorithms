package facebookposition.fbquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestTripleProducts {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(findMaxProduct(arr)));
        int[] arr2 = {2, 1, 2, 1, 2};
        System.out.println(Arrays.toString(findMaxProduct(arr2)));
        int[] arr3 = {2, 4, 7, 1, 5, 3};
        System.out.println(Arrays.toString(findMaxProduct(arr3)));
    }

    public static int[] findMaxProduct(int[] arr) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(arr.length, 0));
        for (int i = arr.length - 1; i >= 2; i--) {
           int[] largestThree =  getLargestThree(arr,0,i);
            result.set(i, largestThree[0] * largestThree[1] * largestThree[2]);
        }
        result.set(0, -1);
        result.set(1, -1);
        return result.stream().mapToInt(d -> d).toArray();
    }

    public static int[] getLargestThree(int[] arr, int s, int e) {
        int[] re = new int[e-s+1];
        while ( s <= e) {
            re[s] = arr[s];
            s++;
        }
        Arrays.sort(re);
        return new int[]{re[re.length-1],re[re.length-2],re[re.length-3]};
    }
}
