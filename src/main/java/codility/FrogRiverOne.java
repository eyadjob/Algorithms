package codility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogRiverOne {


    public static void main(String[] args) {
//        int[] A = {1, 3, 1, 2, 3, 5, 4};
//        System.out.println(solution(5,A));


        int[] A2 = {1, 3, 1, 1, 2, 3, 5, 4, 4, 5};
        System.out.println(solution(5, A2));
        System.out.println(solution2(5, A2));

        System.out.println();
        int[] A3 = {10};
        System.out.println(solution(1, A3));
        System.out.println(solution2(1, A3));

    }

    public static int solution(int X, int[] A) {
        Map<Integer, Integer> te = new HashMap<>();
        for (int i = 1; i <= X; i++) {
            te.put(i, 1);
        }
        int n = A.length;
        int ci = -1;
        for (int i = 0; i < n; i++) {

            if (te.get(A[i]) != null) te.put(A[i], te.get(A[i]) - 1);

            if (A[i] == X) {
                boolean f = true;
                for (Map.Entry<Integer, Integer> v : te.entrySet()) {
                    if (v.getValue() > 0) {
                        f = false;
                    }
                }
                if (f) return i;

            }
        }
        return -1;
    }

    public static int solution2(int X, int[] A) {
        Set<Integer> cls = new HashSet();
        Set<Integer> requiredLeaves = new HashSet();

        for (int i = 1; i <= X; i++) {
            requiredLeaves.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            cls.add(A[i]);
            //keep adding to current leaves set until it's at least the same size as required leaves set
            if (cls.size() < requiredLeaves.size()) continue;

            if (cls.containsAll(requiredLeaves)) {
                return i;
            }
        }
        return -1;
    }
}


//    A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.
//
//        You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.
//
//        The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.
//
//        For example, you are given integer X = 5 and array A such that:
//
//        A[0] = 1
//        A[1] = 3
//        A[2] = 1
//        A[3] = 4
//        A[4] = 2
//        A[5] = 3
//        A[6] = 5
//        A[7] = 4
//        In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
//
//        Write a function:
//
//class Solution { public int solution(int X, int[] A); }
//
//that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.
//
//        If the frog is never able to jump to the other side of the river, the function should return −1.
//
//        For example, given X = 5 and array A such that:
//
//        A[0] = 1
//        A[1] = 3
//        A[2] = 1
//        A[3] = 4
//        A[4] = 2
//        A[5] = 3
//        A[6] = 5
//        A[7] = 4
//        the function should return 6, as explained above.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N and X are integers within the range [1..100,000];
//        each element of array A is an integer within the range [1..X].
//        Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.