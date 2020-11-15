package facebookposition.fbquestions;

public class ValidPalindromeTwo {

    public static void main(String[] args) {

        String f = "ebcbbececabbacecbbcbe";
        System.out.println(validPalindrome(f));


        String y = "yd";
        System.out.println(validPalindrome(y));
        String e = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(e));


        String d = "deeee";
        System.out.println(validPalindrome(d));


        String c = "cbbcc";
        System.out.println(validPalindrome(c));

        String b = "anca";
        System.out.println(validPalindrome(b));


        String a = "aba";
        System.out.println(validPalindrome(a));


    }

    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i++ < j--) {
            if (chars[i] != chars[j]) return checkPalindromeRecursive(chars, i, j+1) || checkPalindromeRecursive( chars, i-1, j);

        }
        return true;
    }

    public static boolean checkPalindromeRecursive(char[] ca, int i, int j) {
        while (i++ < j--) {
            if (ca[i] != ca[j]) return false;
        }
        return true;
    }
}

//    Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
//
//        Example 1:
//        Input: "aba"
//        Output: True
//        Example 2:
//        Input: "abca"
//        Output: True
//        Explanation: You could delete the character 'c'.
//        Note:
//        The string will only contain lowercase characters a-z. The maximum length of the string is 50000.