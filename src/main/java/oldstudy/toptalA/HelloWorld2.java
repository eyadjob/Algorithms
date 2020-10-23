package oldstudy.toptalA;

import java.util.Arrays;

public class HelloWorld2 {

    static int[] dom = {1, 5, 10, 25, 50, 100};

    public static int[] getChange(int am, double pr) {
        int re = (am * 100) - (int) (pr * 100);
        int[] res = new int[dom.length];

        for (int i = dom.length - 1; i >= 0; i--) {
            res[i] = re / dom[i];
            re = re % dom[i];
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arrtemp = getChange(5, 0.99);
        System.out.println(Arrays.toString(arrtemp));
    }


}
