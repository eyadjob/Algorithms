package facebookposition.fbquestions;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MinimumLengthSubstrings {


    public static void main(String[] args) {
        String s = "dcbefebcex";
        String t = "fd";
        System.out.println(minLengthSubstring2(s, t));
        String s2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t2 = "cbccfafebccdccebd";
        System.out.println(minLengthSubstring2(s2, t2));

        
    }

    public static int minLengthSubstring2(String s, String t) {
        char[] tChars = t.toCharArray();
        Map<Character, List<Integer>> sInHashMap = new LinkedHashMap<>();
        AtomicInteger i = new AtomicInteger(0);
        while ( i.get() < s.length()) {
            sInHashMap.put(s.charAt(i.get()), sInHashMap.get(s.charAt(i.get())) == null ? new ArrayList<Integer>(){{add(i.getAndIncrement());}} : sInHashMap.get(s.charAt(i.getAndIncrement())));
        }
        int max = 0;
        for (char tChar : tChars) {
            if (sInHashMap.get(tChar) == null || sInHashMap.get(tChar).size() == 0) return -1;
            if (max < sInHashMap.get(tChar).get(0)) {
                max = sInHashMap.get(tChar).get(0);
            }
            sInHashMap.get(tChar).remove(0);
        }
        return max + 1;
    }
}

//GREEDY ALGO
//    Minimum Length Substrings
//        You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring. Determine the minimum length of the substring of s such that string t is a substring of the selected substring.
//        Signature
//        int minLengthSubstring(String s, String t)
//        Input
//        s and t are non-empty strings that contain less than 1,000,000 characters each
//        Output
//        Return the minimum length of the substring of s. If it is not possible, return -1
//        Example
//        s = "dcbefebce"
//        t = "fd"'
//        output = 5
//        Explanation:
//        Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the minimum length required is 5.