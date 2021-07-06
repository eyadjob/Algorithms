package stack.paypay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestElementRightToEachOne {


    public static int[] findRightGreatest(int[] a) {
        List<Integer> re = new ArrayList<>();
        int distance = 0; boolean greaterFound=false;
        for (int i = 0; i < a.length; i++) {
            for (int k = i + 1; k < a.length; k++) {
                distance++;
                if (a[k] > a[i]) {
                    greaterFound = true;
                    break;
                }
            }
            if (!greaterFound) distance = -1;
            re.add(distance);
            distance = 0; greaterFound =false;
        }
        return re.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] a = {73, 72, 89, 76, 71, 67, 62, 61, 82, 90, 12};
        System.out.println(Arrays.toString(findRightGreatest(a)));

    }


}
