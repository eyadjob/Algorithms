package oldstudy;

class DivideInteger {
    public static int integer_divide(int x, int y) {

        // We will return -1 if the
        // divisor is '0'.
        if (y == 0) {
            return -1;
        }

        if (x < y) {
            return 0;
        }
        else if (x == y) {
            return 1;
        }
        else if (y == 1) {
            return x;
        }

        int q = 1;
        int val = y;

        while (val < x) {
            val <<= 1;
            q <<= 1;

        }

        if (val > x) {
            val >>= 1;
            q >>= 1;

            return q + integer_divide(x - val, y);
        }

        return q;
    }
    public static void main(String[] args) {
        System.out.println( "5/11 " + String.valueOf(integer_divide(30,5) == 6) );
        System.out.println("54/2 " + String.valueOf(integer_divide(54,2) == 27) );
        System.out.println( "51/13 " + String.valueOf(integer_divide(51,13) == 3) );
        System.out.println( "51/0 " + String.valueOf(integer_divide(51,0) == -1) );
    }
}