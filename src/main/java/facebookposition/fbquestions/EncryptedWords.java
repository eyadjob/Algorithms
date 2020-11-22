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
