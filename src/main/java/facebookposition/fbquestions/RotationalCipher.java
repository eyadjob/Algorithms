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