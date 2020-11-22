package facebookposition.fbquestions;

import java.util.Arrays;

public class RevenueMilestones {

    public static void main(String[] args) {

        int[] revenues_1 = {100, 200, 300, 400, 500,500};
        int[] milestones_1 = {300, 800, 1000, 1400,100000};
        int[] expected_1 = {2, 4, 4, 5};
        int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
        System.out.println(Arrays.toString(output_1));



        int[] revenues_2 = {700, 800, 600, 400, 600, 700};
        int[] milestones_2 = {3100, 2200, 800, 2100, 1000};
        int[] expected_2 = {5, 4, 2, 3, 2};
        int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
        System.out.println(Arrays.toString(output_2));

    }


    public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        int[] re = new int[milestones.length];
        int[] sumOfRevenue = new int[revenues.length];
        int tempRevenue = 0;
        for (int i = 0; i < revenues.length; i++) {
            tempRevenue += revenues[i];
            sumOfRevenue[i] = tempRevenue;
        }
        int k = 0, i = 0;
        while (i < sumOfRevenue.length && k < milestones.length) {
            if (sumOfRevenue[i] < milestones[k]) {
                i++;
                continue;
            }
            re[k] = i + 1;
            k++;
            while (k < milestones.length && sumOfRevenue[i] > milestones[k] ) {
                i--;
            }
        }
        while (k < re.length) {
            re[k] = -1;
            k++;
        }
        return re;
    }
}

