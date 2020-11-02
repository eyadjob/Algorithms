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
