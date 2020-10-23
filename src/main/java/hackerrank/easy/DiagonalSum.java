package hackerrank.easy;

import java.io.IOException;

public class DiagonalSum {

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {

        int leftS = 0;
        int rightS = 0;

        for (int i = 0; i < arr.length; i++) {

            leftS += arr[i][i];
            rightS += arr[i][(arr.length - i) - 1];
        }

        return Math.abs(leftS - rightS);
    }


    public static void main(String[] args) throws IOException {


        int[][] arr = {{11, 2, 4}, {4, 5, 6}, {10, 8, -12}};
        int result = diagonalDifference(arr);

        System.out.println(result);


    }


}
