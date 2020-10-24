package oldstudy;

import java.math.BigDecimal;

public class NumberToPowerAmajedSolution {
    static int counter =0;

    static double power(double x, int y) {
        ++counter;

        if (x == 0) {
            return 0;
        }
        if (y == 0) {
            return 1;
        }
        if (y == 1) {
            return x;
        }
        if (y == -1) {
            return (1 / x);
        }

          int p;
        if (y > 0) {
            p = (int) Math.ceil(y / 2.0);
        } else {
            p = (int) Math.floor(y / 2.0);
        }

        return power(x, y / 2) * power(x, p);


    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public static double round(double value) {
        return round(value, 6);
    }

    public static void main(String[] args) {
        int pass_count = 0, fail_count = 0;
        for (double n = -10.9876; n <= 5.987; n = round (n + 0.1)) {
            for (int k = -4; k <= 6; ++k) {
                double r1 = round(power(round(n), k));
                double r2 = round(Math.pow(round(n), k));
                double diff = r1 - r2;
                if (diff < 0) {
                    diff = diff * -1;
                }
                if (diff > 0.0000000001) {
                    String msg = String.format("r1 = %f, r2 = %f, difference = %f", r1, r2, diff);
                    System.out.println("Failed for (" + n + ", " + k + ") " + msg);
                    fail_count++;
                }   else {
                    pass_count++;
                }

                System.out.println(diff <= 0.0000000001);
            }
        }
        System.out.printf("Passed Count: %d, Fail Count: %d\n", pass_count, fail_count);
        System.out.println("counter " + counter);
    }



}
