package paypay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciExample {

    public static void main(String[] args) {

        int n1 = 0, n2 = 1, n3, i, count = 10;
        System.out.print(n1 + " " + n2);//printing 0 and 1

        for (i = 2; i < count; ++i)//loop starts from 2 because 0 and 1 are already printed
        {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
        System.out.println(Arrays.toString(getFibonacciArray(50)));
    }

    public static long[] getFibonacciArray(int n) {

        List<Long> re = new ArrayList<>();
        long n1 = 0, n2 = 1, n3;
        for (int i = 0; i < n; i++) {
            n3 = n1 + n2;
            re.add(n3);
            n1 = n2;
            n2 = n3;
        }

        return re.stream().mapToLong(d -> d  ).toArray();
    }

}