package facebookposition.fbquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PassingYearBooks {

    public static void main(String[] args) {
        int[] ar1 = {2, 1};
        int[] ar2 = {1, 2};

        System.out.println(Arrays.toString(findSignatureCounts(ar1)));
        System.out.println(Arrays.toString(findSignatureCounts(ar2)));
    }

    public static int[] findSignatureCounts(int[] arr) {
        List<Integer> ns = new ArrayList<>(Collections.nCopies(arr.length, 0));
        int temp, diff = arr.length, i = 0;
        while (diff != 0 && i != arr.length - 1) {
            if (arr[i] != i + 1) {
                temp = arr[i];
                ns.set(temp - 1, ns.get(temp - 1) + 1);
                arr[i] = arr[temp - 1];
                ns.set(arr[i] - 1, ns.get(arr[i] - 1) + 1);
                arr[temp - 1] = temp;
                if (i != arr[i] - 1) diff++;
            }
            i++;
            diff--;
            if (diff != 0 && i == arr.length - 1) i = 0;
        }
        ns = ns.stream().map(d -> d += 1).collect(Collectors.toList());
        return ns.stream().mapToInt(d -> d).toArray();
    }


}
