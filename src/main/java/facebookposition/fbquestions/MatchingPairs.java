package facebookposition.fbquestions;

import java.util.HashMap;
import java.util.Map;

public class MatchingPairs {
    public static void main(String[] args) {

        String s = "abcd";
        String t = "adcb";
        System.out.println(matchingPairs(s, t));
        String s2 = "abcb";
        String t2 = "adcb";
        System.out.println(matchingPairs(s2, t2));
        String s3 = "mno";
        String t3 = "mno";
        System.out.println(matchingPairs(s3, t3));

    }

    public static int matchingPairs(String s, String t) {
        Map<Character, Integer> diff = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) diff.put(s.charAt(i), i);
        }
        int diffSize= diff.size();
        if (diff.size() == 0) {
            return s.length() - 2;
        } else {
            for (Map.Entry<Character, Integer> e : diff.entrySet()) {
                if (diff.get(t.charAt(e.getValue())) != null) {
                    if (diff.get(t.charAt(diff.get(t.charAt(e.getValue())))) != null) {
                        diffSize-=2;
                        break;
                    }
                }
            }
        }
        return s.length() - diffSize;
    }
}


//    Matching Pairs
//    Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after swapping exactly two characters within s.
//        A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth index of s, respectively. The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
//        Note: This means you must swap two characters at different indices.
//        Signature
//        int matchingPairs(String s, String t)
//        Input
//        s and t are strings of length N
//        N is between 2 and 1,000,000
//        Output
//        Return an integer denoting the maximum number of matching pairs
//        Example 1
//        s = "abcd"
//        t = "adcb"
//        output = 4
//        Explanation:
//        Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
//        Therefore, the number of matching pairs of s and t will be 4.
//        Example 2
//        s = "mno"
//        t = "mno"
//        output = 1
//        Explanation:
//        Two indices have to be swapped, regardless of which two it is, only one letter will remain the same. If i = 0 and j=1, s[0] and s[1] are swapped, making s = "nmo", which shares only "o" with t.