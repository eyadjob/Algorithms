import org.apache.commons.math3.util.Precision;

import java.util.List;

public class Knapsack {
    static  int   counter =0;

    public static void main(String[] args) {

        int[] testa = new int[1000];

        for ( int i=0; i< 1000; i++) {
            testa[i] = i;
        }



        long start2 = System.currentTimeMillis();
        System.out.println(maximizeValue(220, testa,testa));


        System.out.println("counter is : " + counter);
        float timeConsumed = Precision.round((System.currentTimeMillis() - start2) , 4);
        System.out.println("time consumed in milli seconds :" +timeConsumed);
    }

    static public List maximizeValue(int max, int[] weight, int[] value) {
        long[][] memoTable = new long[weight.length + 1][max + 1];

        for (int i = 0; i <= weight.length; i++) {
            for (int w = 0; w <= max; w++) {
                counter++;
                if (i == 0 || w == 0) {
                    memoTable[i][w] = 0;
                } else if (w >= weight[i - 1]) {
                    long maxWv  =1;// weight[i - 1];

                    memoTable[i][w] = Math.max(value[i - 1] * maxWv + memoTable[i - 1][(int) (w - weight[i - 1])], memoTable[i - 1][w]);
                } else {
                    memoTable[i][w] = memoTable[i - 1][w];
                }
            }
        }

        long knapsack = memoTable[weight.length][max];
        if (knapsack == 0) {
            return null;
        }
        return getSolutionsIndexes(memoTable, knapsack, weight, value, max);
    }


    static List getSolutionsIndexes(long[][] memoTable, long knapsack, int weight[], int value[], int max) {
        java.util.List<Integer> solutionIndexes = new java.util.ArrayList<>();

        long remainingWeight = max;
        for (int i = weight.length; i > 0; i--) {
            counter++;
            if (knapsack != memoTable[i - 1][(int) remainingWeight]) {
                solutionIndexes.add(i - 1);
                long maxWv = 1;//weight[i - 1];


                knapsack = knapsack - value[i - 1] * maxWv;
                remainingWeight = remainingWeight - weight[i - 1];
            }


        }

        return solutionIndexes;
    }

}