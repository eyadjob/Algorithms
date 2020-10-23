package codility;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import com.sun.management.OperatingSystemMXBean;

public class Triangle {


//    public static void printUsage() {
//        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
//        for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
//            method.setAccessible(true);
//            if (method.getName().startsWith("get")
//                    && Modifier.isPublic(method.getModifiers())) {
//                Object value;
//                try {
//                    value = method.invoke(operatingSystemMXBean);
//                } catch (Exception e) {
//                    value = e;
//                } // try
//                System.out.println(method.getName() + " = " + value);
//            } // if
//        } // for
//    }

    public static void main(String[] args) {

        OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();


        int[] A = {10, 2, 5, 1, 8, 20};
        System.out.println(solution(A));

        int[] A2 = {10, 50, 5, 1};
        System.out.println(solution(A2));


        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);
// What % CPU load this current JVM is taking, from 0.0-1.0


        while(true) {
            System.out.println(osBean.getCpuLoad());;
            System.out.println(osBean.getFreeMemorySize());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int solution(int[] A) {
        int n = A.length;
        if (n < 3) return 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int x = j + 1; x < n; x++) {
                    if (A[i] + A[j] > A[x] && A[j] + A[x] > A[i] && A[i] + A[x] > A[j]) return 1;
                }
            }
        }
        return 0;
    }
}


//
//    An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
//
//        A[P] + A[Q] > A[R],
//        A[Q] + A[R] > A[P],
//        A[R] + A[P] > A[Q].
//        For example, consider array A such that:
//
//        A[0] = 10    A[1] = 2    A[2] = 5
//        A[3] = 1     A[4] = 8    A[5] = 20
//        Triplet (0, 2, 4) is triangular.
//
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
//
//        For example, given array A such that:
//
//        A[0] = 10    A[1] = 2    A[2] = 5
//        A[3] = 1     A[4] = 8    A[5] = 20
//        the function should return 1, as explained above. Given array A such that:
//
//        A[0] = 10    A[1] = 50    A[2] = 5
//        A[3] = 1
//        the function should return 0.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [0..100,000];
//        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
//        Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.