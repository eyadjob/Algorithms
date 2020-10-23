package oldstudy.AmazonQuestions;

import java.util.Stack;

public class Sol3 {

    public static int biggestTable(int[][] grid) {
        return biggestRectangular(grid.length, grid[0].length, grid);
    }

    static int history(int R, int C, int[] row) {
        Stack<Integer> re = new Stack<Integer>();
        int maxValue;
        int maxArea = 0;
        int area = 0;
        int i = 0;

        while (i < C) {
            if (re.empty() || row[re.peek()] <= row[i])
                re.push(i++);
            else {
                maxValue = row[re.peek()];
                re.pop();
                area = maxValue * i;

                if (!re.empty())
                    area = maxValue * (i - re.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }
        }

        while (!re.empty()) {
            maxValue = row[re.peek()];
            re.pop();
            area = maxValue * i;
            if (!re.empty())
                area = maxValue * (i - re.peek() - 1);

            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }


    static int biggestRectangular(int R, int C, int[][] A) {
        int result = history(R, C, A[0]);

        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++)
                if (A[i][j] == 1) A[i][j] += A[i - 1][j];
            result = Math.max(result, history(R, C, A[i]));
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] A = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0},
        };

        System.out.print("Area of maximum rectangle is " +
                biggestTable(A));
    }


}

