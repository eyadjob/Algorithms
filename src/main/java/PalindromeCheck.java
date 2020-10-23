public class PalindromeCheck {


    public static boolean checkPalindrome(String text) {

        int index = text.length();

        for (int i = 0; i < index; i++) {
            if (text.charAt(i) != text.charAt(index - 1 - i)) {
                return Boolean.FALSE;
            }

        }
        return Boolean.TRUE;
    }
    public static void main(String[] args) {


        String palind = "never odd or even";
        String not = "test;lkjdasf";

        System.out.println(checkPalindrome(palind));
        System.out.println(checkPalindrome(not));

    }
}
