//import java.util.ArrayList;
//import java.util.List;
//
//public class AllSumCombinations {
//
//    String text = "{\"query\": \"{ otherUser(id: \\\"e8fcc17c-6230-4a24-b873-478e0573b2c8\\\") { ... on PublicUser { statistics { workoutCount workoutDurationSum workoutDistanceSum }}}}\"}"
//    private static void print_all_sum(int n) {
//
//        int counter = 0;
//        for (int i = 1; i <Math.ceil( n/2.0); i++) {
//            System.out.print(i + "," + (n - i));
//            System.out.println();
//        }
////        rec(n, 1,0);
//        int loop = 0;
//        int outer = 1;
//        int base = 1;
////        int k = 1;
//        List<String> duplicateRemover = new ArrayList<>();
//
//      outloop:  while (loop <= n) {
//
//          if ( outer != n) {
//            for (int k = 0; k < n - outer; k++) {
//                    String  toPrint = base + ",";
//                System.out.print(toPrint);
////                duplicateRemover.add(toPrint);
//                ++loop;
//
//                    if (n - (loop +outer) == 0) {
//                        if ( outer != 0) {
//                        System.out.print(outer);}
//                        outer++;
//                        loop = 0;
//                        System.out.println("");
//                        continue outloop;
//
//                    }
//                }
//
//            }else { return;}
//            System.out.println();
//        }
//    }
//
//    public static void rec(int n, int k, int j) {
//
//        int counter = 0;
//        for (int i = 0; i < n - j; i++) {
//            counter = 0;
//            while (counter < n) {
//
//                if (j != n) {
//
//                    System.out.print(k + ",");
//                    counter++;
//                } else {
//                    return;
//                }
//
//            }
//            System.out.print(j);
//            System.out.println();
//            j++;
//
//        }
//        System.out.println();
//        rec(n, ++k, ++j);
//    }
//
//
//    public static void main(String[] args) {
//        int n = 100;
//        print_all_sum(n);
//    }
//
//
//}
