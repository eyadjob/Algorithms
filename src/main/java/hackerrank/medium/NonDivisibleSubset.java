//package hackerrank.medium;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class NonDivisibleSubset {
//
//
//    static int nonDivisibleSubset(int k, int[] S) {
//
//
//        List<List<Integer>> res = new ArrayList<>();
//        for ( int i =0; i < S.length; i++) {
//            for (int j = 0; j < S.length; j++) {
//                if ( (S[i] + S[j]) % k == 0) {
//                    boolean flag = false;
//                    currenLoop:
//                    for (int x = 0; x < res.size(); x++) {
//                        for (int z = 0; z < res.get(x).size(); z++) {
//                            if (S[i] != res.get(x).get(z)) {
//                                continue;
//                            } else {
//                                flag = true;
//                                break currenLoop;
//                            }
//                        }
//                    }
//                    if (!flag) {
//                        List<Integer> list = new ArrayList<>();
//                        res.add(list);
//
//                    }
//
//                }
//
//            }
//        }
//
//        for ( int i =0; i < res.size();)
//
//    }
//
//
//
//    public static void main(String[] args) {
//int[] S = { 1,7,2,4};
//
//
//        int re = nonDivisibleSubset(3, S);
//        System.out.println(re);
//    }
//}
