package oldstudy;

public class IsNumberValid {


    public static boolean is_number_valid(String s) {

        int dotCounter = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {


            if (chars[i] == '.' && i == 0) {
                return false;
            }
            if (chars[i] == '.' && i != 0) {
                ++dotCounter;
                if (dotCounter > 1) {
                    return false;
                }
                if ( i+1 == chars.length ) {
                    return false;
                }


            }

            if (  !Character.isDigit(chars[i]) && i > 0 && chars[i] != '.') {
                return false;

            }

            if ( !Character.isDigit(chars[i]) && i ==0) {
                if ( (chars[i] != '-') &&  (chars[i] != '+')) {
                    return false;
                }
                if ( (chars[i] == '-' || chars[i] =='+' )&& chars.length ==1  ) {
                    return false;
                }
            }



        }
        return true;
    }

    public static void main(String[] args) {
        test("4.325", true);
        test("4.325a", false);
        test("x4.325", false);
        test("4.32.5", false);
        test("4325", true);
        test("1.", false);
        test("1.1.", false);
        test("1.1.1", false);
        test("1.1.1.", false);
        test("+1.1.", false);
        test("+1.1", true);
        test("-1.1.", false);
        test("-1.1", true);
        test("", false);
        test("+", false);
        test("-", false);
        test(".", false);
        test("1", true);
    }

    static void test(String s, boolean expected) {
        boolean is_valid = is_number_valid(s);
        if (is_valid) {
            System.out.println(s + " is valid.");
        } else {
            System.out.println(s + " is not valid.");
        }
        System.out.println((is_valid == expected) ? " correct" : " wrong");
        System.out.println("___");
    }
}
