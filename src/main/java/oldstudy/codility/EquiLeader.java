//package oldstudy.codility;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class EquiLeader {
//
//    public static void main(String[] args) {
//        int[] A = {4, 3, 4, 4, 4,2};
//        System.out.println(solution(A));
//    }
//
//    public static int solution(int[] A) {
//        int n = A.length;
//        Map<Integer,Integer> re = new HashMap<>();
//        for ( int i =0; i < n; i++) {
//            new Values(i,)
//            re.putIfAbsent(A[i], new Values());
//            re.put(A[i],re.get(A[i]+1));
//
//        }
//
//    }
//
//    public static class Values {
//        int  counter =0;
//        List<Integer> li = new ArrayList<>();
//
//        public Values(int counter, List<Integer> li) {
//            this.counter = counter;
//            this.li = li;
//        }
//    }
//    }
//
//
//}
//
//
////    A non-empty array A consisting of N integers is given.
////
////        The leader of this array is the value that occurs in more than half of the elements of A.
////
////        An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
////
////        For example, given array A such that:
////
////        A[0] = 4
////        A[1] = 3
////        A[2] = 4
////        A[3] = 4
////        A[4] = 4
////        A[5] = 2
////        we can find two equi leaders:
////
////        0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
////        2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
////        The goal is to count the number of equi leaders.
////
////        Write a function:
////
////class Solution { public int solution(int[] A); }
////
////that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
////
////        For example, given:
////
////        A[0] = 4
////        A[1] = 3
////        A[2] = 4
////        A[3] = 4
////        A[4] = 4
////        A[5] = 2
////        the function should return 2, as explained above.
////
////        Write an efficient algorithm for the following assumptions:
////
////        N is an integer within the range [1..100,000];
////        each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
////        Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.