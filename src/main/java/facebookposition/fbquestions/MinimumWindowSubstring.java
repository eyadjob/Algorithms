package facebookposition.fbquestions;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {


        System.out.println((int)Double.parseDouble("12.0"));
//        String s = "ADOBECODEBANC", t = "ABC";
//        System.out.println(minWindow(s, t));
//
//        String s2 = "a", t2 = "a";
//        System.out.println(minWindow(s2, t2));
//
//        String s3 = "a", t3 = "aa";
//        System.out.println(minWindow(s3, t3));
//
//        String s4 ="a", t4 ="b";
//        System.out.println(minWindow(s4, t4));

          String s5 ="ab", t5 ="b";
          System.out.println(minWindow(s5, t5));
    }

    public static String minWindow(String s, String t) {
        if ( s.length() < t.length() || (s.length() ==1 && t.length() == 1 && !s.equals(t) )) return "";
        int leftIndex = 0, rightIndex = s.length(), minLeft = 0, minRight = s.length(), findingCount = 0;
        outerloop:
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k < t.length(); k++) {
                if (s.charAt(i) == t.charAt(k)) {
                    findingCount++;
                    if (findingCount == 1) {
                        leftIndex = i;
                        continue outerloop;
                    }
                    if (findingCount == t.length()) {
                        rightIndex = i;
                        if (minRight - minLeft > rightIndex - leftIndex) {
                            findingCount = 0;
                            minLeft = leftIndex;
                            minRight =rightIndex+1;
                            leftIndex = 0;
                        }
                    }
                }
            }
        }
        return s.substring(minLeft, minRight);
}


    public static String minWindow2(String S, String T) {
        if (S.length() == 0 || T.length() == 0 || S.length() < T.length()) return "";
        int left = T.length(), start = -1, end = S.length();
        Deque<Integer> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!map.containsKey(c))
                continue;
            int n = map.get(c);
            map.put(c, n - 1);
            queue.add(i);
            if (n > 0) left--;
            char head = S.charAt(queue.peek());
            while (map.get(head) < 0) {
                queue.poll();
                map.put(head, map.get(head) + 1);
                head = S.charAt(queue.peek());
            }
            if (left == 0) {
                int new_length = queue.peekLast() - queue.peek() + 1;
                if (new_length < end - start) {
                    start = queue.peek();
                    end = queue.peekLast() + 1;
                }
            }
        }
        if (left == 0) return S.substring(start, end);
        else return "";
    }
}


//   Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
//
//   Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
//Example 1:
//
//        Input: s = "ADOBECODEBANC", t = "ABC"
//        Output: "BANC"
//        Example 2:
//
//        Input: s = "a", t = "a"
//        Output: "a"
//
//
//        Constraints:
//
//        1 <= s.length, t.length <= 105
//        s and t consist of English letters.
//
//
//        Follow up: Could you find an algorithm that runs in O(n) time?