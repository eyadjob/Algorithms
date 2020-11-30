package facebookposition.fortifying;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersSolution {

    public static void main(String[] args) {




        String s = "abcdabcde";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
        System.out.println(lengthOfLongestSubstring3(s));
        System.out.println(lengthOfDistinctSubString4(s));

        String s4 = "aab";
        System.out.println(lengthOfLongestSubstring(s4));
        System.out.println(lengthOfLongestSubstring2(s4));

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring2(s2));

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3));
        System.out.println(lengthOfLongestSubstring2(s3));

    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        char[] input = s.toCharArray();
        int maxCount = 0, tempCount=0;
        for (int i = 0; i < input.length; i++) {
            if (count.get(input[i]) != null) {
                i = count.get(input[i]);
                count = new HashMap<>();
                tempCount =0;
            }
            else {
                count.put(input[i], i);
                tempCount++;
                if ( maxCount < tempCount) maxCount = tempCount;
            }
        }
        return maxCount;
    }

    public static  int lengthOfLongestSubstring3(String s) {
        if(s==null||s.equals("")){
            return 0;
        }
        char[] arr = s.toCharArray();
        int[] map = new int[128];
        for(int i = 0; i < 128; i++){
            map[i] = -1;
        }
        int i = 0, last = -1, max = 0;
        while(i<arr.length){
            last = Math.max(last, map[arr[i]]);
            max = Math.max(max, i-last);
                map[arr[i]] = i;
            i++;
        }
        return max;
    }


    public static int lengthOfDistinctSubString4(String s) {
        int[] arr = new int[128];
        Arrays.fill(arr,-1);
        int last=-1, max =0 , i=0;
        while (i < s.length() ) {
            last = Math.max(last, arr[s.charAt(i)]);
            max = Math.max(max, i -last);
            arr[s.charAt(i)] = i;
            i++;
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int[] indecies = new int[128];
        int max = 0, lastInx = 0, n = s.length();
        for(int i=0; i<n; i++) {
            lastInx = Math.max(lastInx, indecies[s.charAt(i)]);
            max = Math.max(max, i - lastInx + 1);
            indecies[s.charAt(i)] = i+1;
        }
        return max;
    }

}


//Example 1:
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//        Example 4:
//
//        Input: s = ""
//        Output: 0