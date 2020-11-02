package facebookposition.fbquestions;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MinimumLengthSubstrings {


    public static void main(String[] args) {
        String s = "dcbefebcex";
        String t = "fd";
        System.out.println(minLengthSubstring2(s, t));
        String s2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t2 = "cbccfafebccdccebdd";
        System.out.println(minLengthSubstring2(s2, t2));


    }

    public static int minLengthSubstring2(String s, String t) {
        char[] tChars = t.toCharArray();
        Map<Character, List<Integer>> sInHashMap = new LinkedHashMap<>();
        AtomicInteger i = new AtomicInteger(0);
        while ( i.get() < s.length()) {
            sInHashMap.put(s.charAt(i.get()), sInHashMap.get(s.charAt(i.get())) == null ? new ArrayList<>(){{add(i.getAndIncrement());}} : sInHashMap.get(s.charAt(i.getAndIncrement())));
        }
        int max = 0;
        for (int k =0; k < tChars.length; k++ )  {
            if (sInHashMap.get(tChars[k]) == null || sInHashMap.get(tChars[k]).size() == 0) return -1;
            if (max < sInHashMap.get(tChars[k]).get(0)) {
                max = sInHashMap.get(tChars[k]).get(0);
            }
            sInHashMap.get(tChars[k]).remove(0);
        }
        return max + 1;
    }




}
