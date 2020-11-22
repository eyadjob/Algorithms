package facebookposition.fbquestions;

import java.util.*;

public class ContinuousLengthArithmeticProg {

    public static void main(String[] args) {
        int[] A = {4, 8, 13};
        int[] B = {0, 9, 12};

//        ANSWER = [0,4,8,12] , 4

        System.out.println(Arrays.toString(findMaximumAP(A, B)));

    }


    public static int[] findMaximumAP(int[] ar1, int[] ar2) {

        Map<Integer, List<Integer>> result = new HashMap<>();
        int n = ar1.length, n2 = ar2.length;


        for (int i = 0; i < n; i++) {
            int diff = ar1[i] - (i == 0 ? 0 : ar1[i - 1]);
            if (result.get(diff) == null) {
                List<Integer> index = new ArrayList<>();
                index.add(1);
                index.add(i);
                result.put(diff, index);
            } else {
                result.get(diff).set(0, result.get(diff).get(0) + 1);
                result.get(diff).add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n2; k++) {
                if (ar1[i] > ar2[k]) {
                    int diff = ar1[i] - ar2[k];
                    if (result.get(diff) == null) {
                        List<Integer> index = new ArrayList<>();
                        index.add(1);
                        index.add(k);
                        index.add(i);
                        result.put(diff, index);
                    } else {
                        result.get(diff).set(0, result.get(diff).get(0) + 1);
                        result.get(diff).add(k);
                        result.get(diff).add(i);
                    }
                } else {
                    int diff = ar2[k] - ar1[i];
                    if (result.get(diff) == null) {
                        List<Integer> index = new ArrayList<>();
                        index.add(1);
                        index.add(i);
                        index.add(k);
                        result.put(diff, index);
                    } else {
                        result.get(diff).set(0, result.get(diff).get(0) + 1);
                        result.get(diff).add(i);
                        result.get(diff).add(k);
                    }

                }
            }
        }
        return new int[1];
    }

}

