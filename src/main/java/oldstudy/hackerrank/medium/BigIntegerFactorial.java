package oldstudy.hackerrank.medium;

import java.math.BigInteger;

public class BigIntegerFactorial {


    public static void main(String[] args) {

        int n = 10;
        BigInteger re = new BigInteger("1");

        for(int i =0;  i < n; i++) {
            String s = String.valueOf(n-i);
            BigInteger te = new BigInteger(s);
          re =  re.multiply(te);
        }
        System.out.println(re);
    }


}
