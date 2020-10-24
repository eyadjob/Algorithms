package oldstudy.AmazonQuestions;



import java.util.ArrayList;
import java.util.List;

public class LongestUqinueSubString {


//    Longest Unique Substring
//
//    Given a string, find the length of the longest substring without repeating characters.
//
//    Examples:
//
//    Given "abcabcbb", the answer is "abc", which the length is 3.
//
//    Given "bbbbb", the answer is "b", with the length of 1.
//
//    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


    private static String findLongestSubString(String s) {

        StringBuilder sb = new StringBuilder();
        List<String> strings = new ArrayList<>();

        for ( int i=0; i < s.length(); i++) {

                if ( !sb.toString().contains(String.valueOf(s.charAt(i))) ) {
                    sb.append(s.charAt(i));

                } else {
                    strings.add(sb.toString());
                    sb = new StringBuilder();
                    sb.append(String.valueOf(s.charAt(i)));
                }


        }

        int size = 0;
        String temp = "";
        for (int i =0; i < strings.size(); i++) {

            if ( strings.get(i).length() > temp.length()) {
                temp = strings.get(i);
            }

        }
        return temp;

    }

    public static void main(String[] args) {

        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";



        System.out.println("Result = " + findLongestSubString(s1));
        System.out.println("Result = " + findLongestSubString(s2));
        System.out.println("Result = " + findLongestSubString(s3));


    }
}
