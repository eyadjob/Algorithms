package oldstudy.AmazonQuestions;

import java.util.ArrayList;
import java.util.List;

public class WaterTankSize {


    public static int giveLargestSize(List<Integer> co) {

        int i = 0;
        int k = co.size() - 1;
        int s = 0;

        while (i != k) {

           int temp = Math.abs(i - k) *  (  co.get(k) < co.get(i) ? co.get(k) : co.get(i) ) ;

            if (s < temp) {
                s = temp;
            }

            if (co.get(i) < co.get(i + 1)) {
                i += 1;

                temp = Math.abs(i - k) *  (  co.get(k) < co.get(i) ? co.get(k) : co.get(i) ) ;

                if (s < temp) {
                    s = temp;
                }

            }

            if (co.get(k) < co.get(k - 1)) {
                k -= 1;

                temp = Math.abs(i - k) *  (  co.get(k) < co.get(i) ? co.get(k) : co.get(i) ) ;

                if (s < temp) {
                    s = temp;
                }
            }


        }

        return s;
    }


    public static void main(String[] args) {


        List<Integer> co = new ArrayList<>();

        co.add(1);
        co.add(5);
        co.add(4);
        co.add(3);

        System.out.println( giveLargestSize(co));


    }
}
