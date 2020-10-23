package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxCounters {


    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int n = 5;

        System.out.println(solution(n, A));
    }


    public static int[] solution3(int N, int[] A) {
        int[] counters = new int[N];
        int idx = 0, max = 0, tmp = 0;
        for (int i : A) {
            if (i >= 1 && i <= N) {
                tmp = counters[i - 1];
                tmp++;
                max = max > tmp ? max : tmp;
                counters[i - 1] = tmp;
            } else if (i == (N + 1)) {
                if (N > 1) {
                    counters[0] = max;
                    counters[1] = max;
                    for (int x = 1; x < N; x += x) {
                        System.arraycopy(counters, 0, counters, x, ((N - x) < x) ? (N - x) : x);
                    }
                } else {
                    counters[0] = max;
                }
            }
        }
        return counters;

    }


    public static int[] solution2(int N, int[] A) {
        int[] re = new int[N];
        Arrays.fill(re, 0);
        int max = 0;
        for (int value : A) {
            if (value == N + 1) {
                Arrays.fill(re, max);
            } else {
                if (1 <= value && value <= N) {
                    int num = re[value - 1] + 1;
                    if (max < num) max = num;
                    re[value - 1] = num;
                }
            }
        }
        return re;
    }


    public static int[] solution(int N, int[] A) {

        int len = A.length;
        List<Integer> re = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            re.add(0);
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] == N + 1) {
                for (int x = 0; x < re.size(); ++x) {
                    re.set(x, max);
                }
            } else {
                if (1 <= A[i] && A[i] <= N) {
                    int num = re.get(A[i] - 1) + 1;
                    if (max < num) max = num;
                    re.set(A[i] - 1, num);
                }
            }
        }
        return re.stream().mapToInt(i -> i).toArray();
    }
}


//    You are given N counters, initially set to 0, and you have two possible operations on them:
//
//        increase(X) − counter X is increased by 1,
//        max counter − all counters are set to the maximum value of any counter.
//        A non-empty array A of M integers is given. This array represents consecutive operations:
//
//        if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
//        if A[K] = N + 1 then operation K is max counter.
//        For example, given integer N = 5 and array A such that:
//
//        A[0] = 3
//        A[1] = 4
//        A[2] = 4
//        A[3] = 6
//        A[4] = 1
//        A[5] = 4
//        A[6] = 4
//        the values of the counters after each consecutive operation will be:
//
//        (0, 0, 1, 0, 0)
//        (0, 0, 1, 1, 0)
//        (0, 0, 1, 2, 0)
//        (2, 2, 2, 2, 2)
//        (3, 2, 2, 2, 2)
//        (3, 2, 2, 3, 2)
//        (3, 2, 2, 4, 2)
//        The goal is to calculate the value of every counter after all operations.
//
//        Write a function:
//
//class Solution { public int[] solution(int N, int[] A); }
//
//that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
//
//        Result array should be returned as an array of integers.
//
//        For example, given:
//
//        A[0] = 3
//        A[1] = 4
//        A[2] = 4
//        A[3] = 6
//        A[4] = 1
//        A[5] = 4
//        A[6] = 4
//        the function should return [3, 2, 2, 4, 2], as explained above.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N and M are integers within the range [1..100,000];
//        each element of array A is an integer within the range [1..N + 1].
//        Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.