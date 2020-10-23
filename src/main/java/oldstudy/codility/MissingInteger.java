package oldstudy.codility;

import java.util.Arrays;

public class MissingInteger {

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(A));

        int[] A2 = {1,2,3};
        System.out.println(solution(A2));

        int[] A3 = {-1,-3};
        System.out.println(solution(A3));

        int[] A4 = {2};
        System.out.println(solution(A4));

    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        int n = A.length,c =0;
        for (int i = 0; i < n; i++) {
            if (A[i] <= 0) continue;
            if (A[i] - c  > 1) return c+1;
            c = A[i];
        }
        if (A[n-1]+1 > 0) return  A[n-1]+1;
        return 1;
    }
}


//       This is a demo task.
//
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//        Given A = [1, 2, 3], the function should return 4.
//
//        Given A = [−1, −3], the function should return 1.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..100,000];
//        each element of array A is an integer within the range [−1,000,000..1,000,000].
//        Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
