package oldstudy.codesignal;

public class SumTwoDigits {

    public static void main(String[] args) {
        System.out.println(addTwoDigits(29));
    }

    public static int addTwoDigits(int n) {
        return Integer.parseInt(String.valueOf(String.valueOf(n).charAt(0))) + Integer.parseInt(String.valueOf((String.valueOf(n).charAt(1))));

    }

}
