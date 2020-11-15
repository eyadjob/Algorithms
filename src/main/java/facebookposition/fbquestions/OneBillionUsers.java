package facebookposition.fbquestions;

import java.util.Arrays;

public class OneBillionUsers {

    public static void main(String[] args) {

        String s = "1,2,3,4,5,6";

        int[] res =Arrays.stream(s.split(",")).mapToInt(Integer :: parseInt).toArray();

        System.out.println(Arrays.toString(res));

        float[] test_1 = {1.5f};
//        int expected_1 = 52;
        System.out.println(getBillionUsersDay(test_1));

        float[] test_2 = {1.1f, 1.2f, 1.3f};
//        int expected_1 = 79;
        System.out.println(getBillionUsersDay(test_2));

        float[] test_3 = {1.01f, 1.02f};
//        int expected_2 = 1047;
        System.out.println(getBillionUsersDay(test_3));


    }

    public static int getBillionUsersDay(float[] growthRates) {
        double[] total= Arrays.stream(new double[growthRates.length]).map(d -> d = 1).toArray();
        int days=0;
        double totalGrowth=1;
        while( totalGrowth < 1000000000) {
            for (int i = 0; i < growthRates.length; i++) {
                total[i] *= growthRates[i];
            }
            totalGrowth = Arrays.stream(total).sum();
            days++;
        }
        return days;
    }
}
