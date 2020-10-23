package codility;

import java.util.Arrays;

public class MinAvgTwoSlice {

    public static void main(String[] args) {
        int[] A = {3, 2, 2, 5, 1, 5, 8};
        System.out.println(solution(A));

        int[] A2 = {5, 6, 3, 4, 9};
        System.out.println(solution(A2));
        System.out.println(solution2(A2));
    }

    public static int solution2(int[] A) {
        int startIndex = 0;

        if (A.length < 2) {
            return -1;
        }

        double minSliceSize = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            double sliceSize = (A[i] + A[i + 1]) / 2.0;
            if (sliceSize < minSliceSize) {
                minSliceSize = sliceSize;
                startIndex = i;
            }
            if (i + 2 < A.length) {
                sliceSize = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (sliceSize < minSliceSize) {
                    minSliceSize = sliceSize;
                    startIndex = i;
                }
            }
        }
        return startIndex;
    }


    public static int solution(int[] A) {
        double min = Double.MAX_VALUE;
        int n = A.length, po = 0, le =0,temMax=0;
        int arrMax = Arrays.stream(A).reduce(0, Integer :: sum);
        for (int i = 0; i < n; i++) {
            if (i != 0) le += A[i - 1];
            temMax = arrMax - le;
            for (int j = n - 1; j > i; j--) {
                double re = ((double) temMax / (j - (i - 1)));
                if (min > re) {
                    min = re;
                    po = i;
                }
                temMax -= A[j];
            }
        }
        return po;
    }

}


//    A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
//
//        For example, array A such that:
//
//        A[0] = 4
//        A[1] = 2
//        A[2] = 2
//        A[3] = 5
//        A[4] = 1
//        A[
//        5] = 5
//        A[6] = 8
//        contains the following example slices:
//
//        slice (1, 2), whose average is (2 + 2) / 2 = 2;
//        slice (3, 4), whose average is (5 + 1) / 2 = 3;
//        slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
//        The goal is to find the starting position of a slice whose average is minimal.
//
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
//
//        For example, given array A such that:
//
//        A[0] = 4
//        A[1] = 2
//        A[2] = 2
//        A[3] = 5
//        A[4] = 1
//        A[5] = 5
//        A[6] = 8
//        the function should return 1, as explained above.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [2..100,000];
//        each element of array A is an integer within the range [−10,000..10,000].
//        Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.