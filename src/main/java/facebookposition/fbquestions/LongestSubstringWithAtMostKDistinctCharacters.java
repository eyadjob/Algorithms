package facebookposition.fbquestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {

        String s = "eceba";
        int k = 2;
//        Output: 3;
        System.out.println(lengthOfLongestSubstringKDistinct(s,2));

        String s2 = "aa";
        int k2 = 1;
//        Output: 3;
        System.out.println(lengthOfLongestSubstringKDistinct(s2,k2));

    }


    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
            Map<Character, Integer> map = new HashMap<>();
            int left = 0;
            int best = 0;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                while (map.size() > k) {
                    char leftChar = s.charAt(left);
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar) - 1);
                        if (map.get(leftChar) == 0) {
                            map.remove(leftChar);
                        }
                    }
                    left++;
                }
                best = Math.max(best, i - left + 1);
            }
            return best;
        }
}
