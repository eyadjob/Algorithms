//import edu.princeton.cs.introcs.StdOut;
//
//import java.util.Arrays;
//
//public class TwoSumFast {
//
//    public static int count(int[] a) {  // Count pairs that sum to 0.
//        Arrays.sort(a);
//        int N = a.length;
//        int cnt = 0;
//        for (int i = 0; i < N; i++)
//            if (BinarySearch.rank(-a[i], a) > i)
//                cnt++;
//        return cnt;
//    }
//
//    public static void main(String[] args) {
//        int[] a = {2, 3, 4, 5, 3, 5, 6, 123, 5, 6, 73, 1, 3, 5, 6, 7, 4, 2, 22, 2, 33};
//        StdOut.println(count(a));
//    }
//}
