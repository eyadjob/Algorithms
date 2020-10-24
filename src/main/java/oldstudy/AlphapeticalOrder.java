package oldstudy;

public class AlphapeticalOrder {


    public static boolean checkAlphapeticalOrder(String[] text) {


        for (int i = 1; i < text.length; i++) {
            if (text[i-1].compareTo(text[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[] ar = {"ahmad", "eyad", "wow"};
        String[] be = {"eyad", "ahmad", "wow"};
        System.out.println(checkAlphapeticalOrder(ar));
        System.out.println(checkAlphapeticalOrder(be));
    }
}
