package codility;

import java.util.Arrays;

public class PermMissingElement {

    public static void main(String[] args) {

        int[] A = {2, 3, 1, 5};
        System.out.println(solution(A));
        System.out.println(solution2(A));
    }
    private static int solution2(int[] A)  {
        double n =  A.length + 1;
        double totalSum = (double) ((n * (n + 1)) / 2);

        for (int i = 0; i < A.length; i++) {
            totalSum -= A[i];
        }

        return (int) (totalSum == 0 ? A.length + 1 : totalSum);
    }


    public static int solution(int[] A) {

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {

            if (Math.abs(A[i] - A[i + 1]) > 1) {
                return A[i] + 1;
            }
        }

        return -1;
    }

}


//    An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
//
//        Your goal is to find that missing element.
//
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A, returns the value of the missing element.
//
//        For example, given array A such that:
//
//        A[0] = 2
//        A[1] = 3
//        A[2] = 1
//        A[3] = 5
//        the function should return 4, as it is the missing element.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [0..100,000];
//        the elements of A are all distinct;
//        each element of array A is an integer within the range [1..(N + 1)].
//        Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.