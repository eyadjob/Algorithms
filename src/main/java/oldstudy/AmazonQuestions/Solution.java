package oldstudy.AmazonQuestions;

import java.util.*;
import java.lang.*;

class Solution
{
    public static int numOffices(String[][] grid) {

        String[][] co = new String[100][100];
        return checkCurrentOfficeRec(grid, co,0,0);

    }

    public static int checkCurrentOfficeRec(String[][] grid,  String[][] co, int c, int r ) {

        String[][] counted = new String[100][100];
        int counter =0;

        if (counted[c][r] == "1" ) {
            return 0;
        }

        if (c + 1 == grid.length ) {
            return 0;
        }

        if (r + 1 == grid.length ) {
            return 0;
        }
        if (c - 1 == 0 ) {
            return 0;
        }

        if (r - 1 == 0 ) {
            return 0;
        }

        if ( grid[c][r] == "0" )
            return 0;

        if ( grid[c][r] == "1") {
            co[c][r]  ="1";
            counted[c][r]="1";

            checkCurrentOfficeRec(grid,co, c++, r );
            checkCurrentOfficeRec(grid,co, c--,r );
            checkCurrentOfficeRec(grid,co, c,r++ );
            checkCurrentOfficeRec(grid,co, c,r-- );
        }

        return counter++;
    }

}

class Rextester
{
    public static String[][] getMatrix() {
        Scanner sc = new Scanner(System.in);
        int rowsLen = sc.nextInt();
        int colsLen = sc.nextInt();
        String matrix[][] = new String[rowsLen][colsLen];
        int i;
        for(i=0;i<rowsLen;i++){
            String line = sc.next();
            for(int j=0;j<line.length();j++) {
                matrix[i][j] = String.valueOf(line.charAt(j));
            }
        }
        return matrix;
    }

    public static void main(String args[])
    {
        int result =  Solution.numOffices(getMatrix());
        System.out.println(result);
    }
}