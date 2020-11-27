package facebookposition.fbquestions;

public class EncryptedWords {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String S2 = "abcd";
//      Expected= "bacd";
        System.out.println(findEncryptedWord(S2));

        System.out.println();

        String S3 = "abcxcba";
//      Expected = "xbacbca";
        System.out.println(findEncryptedWord(S3));

        System.out.println();

        String S4 = "facebook";
//      Expected= "eafcobok" ;
        System.out.println(findEncryptedWord(S4));

        String s = "abc";
        System.out.println(findEncryptedWord(s));

    }

    public static String findEncryptedWord(String s) {
        sb = new StringBuilder();
        findEncryptedWordRec(s, 0, s.length());
        return sb.toString();
    }

    public static void findEncryptedWordRec(String s, int start, int end) {
        int charIndex = (end - start) % 2 == 1 ? (end + start) / 2 : ((end + start) / 2) - 1;
        if (end - start <= 0) {
            return;
        } else {
            sb.append(s.charAt(charIndex));
        }
        findEncryptedWordRec(s, start, charIndex);
        findEncryptedWordRec(s, charIndex + 1, end );
    }

}

//    Encrypted Words
//You've devised a simple encryption method for alphabetic strings that shuffles the characters in such a way that the resulting string is hard to quickly read, but is easy to convert back into the original string.
//        When you encrypt a string S, you start with an initially-empty resulting string R and append characters to it as follows:
//        Append the middle character of S (if S has even length, then we define the middle character as the left-most of the two central characters)
//        Append the encrypted version of the substring of S that's to the left of the middle character (if non-empty)
//        Append the encrypted version of the substring of S that's to the right of the middle character (if non-empty)
//        For example, to encrypt the string "abc", we first take "b", and then append the encrypted version of "a" (which is just "a") and the encrypted version of "c" (which is just "c") to get "bac".
//        If we encrypt "abcxcba" we'll get "xbacbca". That is, we take "x" and then append the encrypted version "abc" and then append the encrypted version of "cba".
//        Input
//        S contains only lower-case alphabetic characters
//        1 <= |S| <= 10,000
//        Output
//        Return string R, the encrypted version of S.
//        Example 1
//        S = "abc"
//        R = "bac"
//        Example 2
//        S = "abcd"
//        R = "bacd"
//        Example 3
//        S = "abcxcba"
//        R = "xbacbca"
//        Example 4
//        S = "facebook"
//        R = "eafcobok"
