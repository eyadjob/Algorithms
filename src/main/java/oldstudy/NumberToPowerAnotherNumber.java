package oldstudy;

import java.math.BigDecimal;


public class NumberToPowerAnotherNumber {


    public static  double power(double x, int y) {
        double value =0.0;
       int counter =y;
       value = power(x, y, counter);
        return value;

    }

  public static double  power(double x, int y, int counter) {

      if ( y /2 !=  1 && y /2 !=  -1 ) {
          int os1 =(int) Math.ceil( y / 2);
          int os2 =  y - os1;

            x=  power(x ,os1,counter);
          x =  power(x, os2, counter);


      }
      return x * x;

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
    }


}
