package oldstudy.coda;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solutaion2 {

    public static void main(String[] args) {

        Solutaion2 solutaion2 = new Solutaion2();


        long ct = 0;

        long nT = 0;
        int[] A = {1, 1, 3, 3, 3, 4, 5, 5, 5, 5};

        System.out.println(solutaion2.solution(A, 2));

        System.out.println(doIt(A, 2));

        int[] B = {1, 1, 3, 3, 5, 5, 5, 5, 5, 5};
        System.out.println(solutaion2.solution(B, 0));

        ct = System.currentTimeMillis();
        System.out.println("do it : " + doIt(B, 4));
        System.out.println("Time consumed for do it : " + (System.currentTimeMillis() - ct));

        ct = System.currentTimeMillis();
        System.out.println("new Solution : " + solutionWithNoTimeRestriction(B, 4));
        System.out.println("Time consumed for my new solution: " + (System.currentTimeMillis() - ct));

        int[] C = {2, 5, 5, 5, 5, 5};
        System.out.println(solutaion2.solution(B, 0));

        ct = System.currentTimeMillis();
        System.out.println("do it : " + doIt(C, 2));
        System.out.println("Time consumed for do it : " + (System.currentTimeMillis() - ct));

        ct = System.currentTimeMillis();
        System.out.println("new Solution : " + solutionWithNoTimeRestriction(C, 2));
        System.out.println("Time consumed for my new solution: " + (System.currentTimeMillis() - ct));

    }


    public static int solutionWithNoTimeRestriction(int[] ar, final int h) {
        TreeMap<Integer, Integer> fr = new TreeMap<>();
        for (int i = 0; i < ar.length; i++) {
            if (fr.get(ar[i]) != null) {
                fr.put(ar[i], fr.get(ar[i]) + 1);
            } else {
                fr.put(ar[i], 1);
            }
        }
        int best = 0;
        int rN = ar.length;
        for (Map.Entry<Integer, Integer> e : fr.entrySet()) {
            rN -= e.getValue();
            int currentBest = e.getValue() + Math.min(h, rN);
            if (currentBest > best) {
                best = currentBest;
            }
        }
        return best;
    }



















    public static int doIt2(int[] ar, final int h) {

        int best = 0;
        int start = 0;

        while (start < ar.length) {
            int end = start;
            while (end < ar.length && ar[end] == ar[start]) {
                end++;
            }
            best = Math.max(best, end - start + Math.min(h, ar.length - end));
            start = end;

        }

        assert best >= Math.min(h + 1, ar.length);
        return best;
    }


    public static int doIt(final int[] array, final int y) {
        int best = 0;
        int start = 0;
        while (start < array.length) {
            int end = start;
            while (end < array.length && array[end] == array[start]) {
                ++end;
            }

            // array[start .. (end-1)] is now the subarray consisting of a
            // single value repeated (end-start) times.
            best = Math.max(best, end - start + Math.min(y, array.length - end));

            start = end; // skip to the next distinct value
        }
        assert best >= Math.min(y + 1, array.length); // sanity-check
        return best;
    }


    public int solution(int[] A, int Y) {
        // write your code in Java

        Map<Integer, Integer> maxFre = new HashMap<>();
        maxFre.put(0, -1);
        int maxLen = 0;
        Map<Integer, Integer> fre = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (fre.get(A[i]) == null) {
                fre.put(A[i], 1);
            } else {
                fre.put(A[i], fre.get(A[i]) + 1);
            }

        }
        int i = 0;
        int nailLength = 0;
        int totalOfNailsPossibleToHammer = 0;
        for (Map.Entry<Integer, Integer> entry : fre.entrySet()) {

            if (i < fre.size() - 2) {
                if (maxFre.get(0) < entry.getValue()) {
                    maxFre.put(0, entry.getValue());
                    nailLength = entry.getKey();
                    ++i;
                }
            }
        }
        if (fre.size() == 1) {
            int value = 0;
            for (Map.Entry<Integer, Integer> entry : fre.entrySet()) {
                value = entry.getValue();
            }
            return value;
        } else {
            for (Map.Entry<Integer, Integer> entry : fre.entrySet()) {
                if (nailLength < entry.getKey()) {
                    totalOfNailsPossibleToHammer += entry.getValue();
                }
            }

            if (totalOfNailsPossibleToHammer >= Y) {
                return maxFre.get(0) + Y;
            } else {
                return maxFre.get(0) + totalOfNailsPossibleToHammer;
            }
        }

    }

}
