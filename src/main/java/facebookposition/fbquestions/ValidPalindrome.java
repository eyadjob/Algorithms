package facebookposition.fbquestions;

public class ValidPalindrome {

    public static void main(String[] args) {


        String s2 = "race a car";
        System.out.println(isPalindrome(s2));

        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int si = 0, ei = s.length() - 1;
        while (si < s.length() && si != ei) {

            if ((!Character.isAlphabetic(s.charAt(si)) && !Character.isDigit(s.charAt(si)) ) || Character.isWhitespace(s.charAt(si))) {
                si++;
                continue;
            }
            if ((!Character.isAlphabetic(s.charAt(ei)) && !Character.isDigit(s.charAt(ei)) ) || Character.isWhitespace(s.charAt(ei)) )  {
                ei--;
                continue;
            }
            if ( Character.toLowerCase(s.charAt(si)) != Character.toLowerCase(s.charAt(ei)))
                return false;
            si++;
            ei--;
        }
        return true;
    }
}
