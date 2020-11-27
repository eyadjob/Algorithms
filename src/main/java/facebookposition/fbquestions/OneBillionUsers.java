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

//
//1 Billion Users
//        We have N different apps with different user growth rates. At a given time t, measured in days, the number of users using an app is g^t (for simplicity we'll allow fractional users), where g is the growth rate for that app. These apps will all be launched at the same time and no user ever uses more than one of the apps. We want to know how many total users there are when you add together the number of users from each app.
//        After how many full days will we have 1 billion total users across the N apps?
//        Signature
//        int getBillionUsersDay(float[] growthRates)
//        Input
//        1.0 < growthRate < 2.0 for all growth rates
//        1 <= N <= 1,000
//        Output
//        Return the number of full days it will take before we have a total of 1 billion users across all N apps.
//        Example 1
//        growthRates = [1.5]
//        output = 52
//        Example 2
//        growthRates = [1.1, 1.2, 1.3]
//        output = 79
//        Example 3
//        growthRates = [1.01, 1.02]
//        output = 1047