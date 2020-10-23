package oldstudy.hackerrank.easy;

import java.io.IOException;

public class veryBigSum {


    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {

        long sum =0;

        for (int i=0; i < ar.length; i++) {
           sum += ar[i];
        }

        return sum;

    }

    public static void main(String[] args) throws IOException {


        long[] ar = {1000000001,1000000002 ,1000000003 ,1000000004 ,1000000005};
        long result = aVeryBigSum(ar);

    }
}


