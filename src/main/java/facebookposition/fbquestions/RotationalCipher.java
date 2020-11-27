package facebookposition.fbquestions;

public class RotationalCipher {

    public static void main(String[] args) {
//      Cheud-726
        String s = "Zebra-493";
        System.out.println(rotationalCipher(s, 3));
        String input = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
//      output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
        int rotation = 39;
        System.out.println(rotationalCipher(input, rotation ));
    }

    public static String rotationalCipher(String input, int rotationFactor) {
        char[] inputChars = input.toCharArray();
        char c;
        int nRotation = rotationFactor;
        StringBuilder sb = new StringBuilder();
        for (char inputChar : inputChars) {
            c = inputChar;
            if (Character.isAlphabetic(inputChar)) {
                rotationFactor = rotationFactor % 26;
                c = (char) (inputChar + rotationFactor);
                if ((Character.isLowerCase(inputChar) && c > 'z') || (Character.isUpperCase(inputChar) && c > 'Z'))
                    c = (char) (inputChar - (26 - rotationFactor ));
            } else if (Character.isDigit(inputChar)) {
                c = String.valueOf((Integer.parseInt(String.valueOf(inputChar)) + nRotation) % 10).charAt(0);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}


//    Rotational Cipher
//    One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
//        For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
//        Given a string and a rotation factor, return an encrypted string.
//        Signature
//        string rotationalCipher(string input, int rotationFactor)
//        Input
//        1 <= |input| <= 1,000,000
//        0 <= rotationFactor <= 1,000,000
//        Output
//        Return the result of rotating input a number of times equal to rotationFactor.
//        Example 1
//        input = Zebra-493?
//        rotationFactor = 3
//        output = Cheud-726?
//        Example 2
//        input = abcdefghijklmNOPQRSTUVWXYZ0123456789
//        rotationFactor = 39
//        output = nopqrstuvwxyzABCDEFGHIJKLM9012345678