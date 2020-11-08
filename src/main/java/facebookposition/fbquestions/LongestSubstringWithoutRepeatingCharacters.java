package facebookposition.fbquestions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        String s6 = "dvdf";
        System.out.println(lengthOfLongestSubstring(s6));

        String s8 = "abb";
        System.out.println(lengthOfLongestSubstring(s8));

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3));

        String s4 = "";
        System.out.println(lengthOfLongestSubstring(s4));

        String s5 = " ";
        System.out.println(lengthOfLongestSubstring(s5));

        String s7 = "bbtablud";
        System.out.println(lengthOfLongestSubstring(s7));

    }

    public static int lengthOfLongestSubstring2(String s) {
        int maxSub = 0, temMax = 0,indexCounter =0;
        Map<Character,Integer> indexOfDuplicates = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.toString().contains(String.valueOf(s.charAt(i)))) {
                indexOfDuplicates.put(s.charAt(i),i);
                if (maxSub <= temMax) {
                    maxSub = temMax;
                    i = Math.min(indexOfDuplicates.get(s.charAt(i))+1,s.length()-1);
                    temMax = 0;
                }
                sb = new StringBuilder();
            }
            temMax++;
            sb.append(s.charAt(i));
        }
        return Math.max(maxSub,temMax);
    }

    public static int lengthOfLongestSubstring(String s) {
            int max_len = 0;
            int start = 0;
            Map<Character, Integer> map = new HashMap<>();
            for(int i=0;i<s.length();i++){
                if(map.containsKey(s.charAt(i)) && start <= map.get(s.charAt(i))){
                    start = map.get(s.charAt(i)) + 1;
                } else{
                    max_len = Math.max(max_len, i-start+1);
                }
                map.put(s.charAt(i), i);
            }
            return max_len;
        }
}
