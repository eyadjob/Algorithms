package stack.paypay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSmallestThNumber {


    public static int findSmallestNumberByOrder2(int[] a, int order) {
        Arrays.sort(a);
        return a[order-1];
    }

    public static int findSmallestNumberByOrder(int[] a, int order) {
        List<Integer> re = new ArrayList<>();
        if (order > a.length)
            return -1;
        for (int i = 0; i < a.length; i++) {
            if (re.size() == 0) {
                re.add(a[i]);
                continue;
            }
            for (int x = 0; x < re.size(); x++) {
                if (re.get(x) >= a[i]) {
                    re.add( x,a[i]);
                    break;
                }
                if (x == re.size() - 1) {
                    re.add(a[i]);
                    break;
                }

            }
        }
        return re.get(order-1);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 6, 3, 3, 8};
        System.out.println(findSmallestNumberByOrder(a, 1));;
        System.out.println(findSmallestNumberByOrder2(a, 1));;
    }
}
