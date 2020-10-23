public class SquareMatrix {


    public double[][] squareMatrix(int[][] a, int[][] b) {
        int N = a.length;
        double[][] c = new double[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            { // Compute dot product of row i and column j.
                for (int k = 0; k < N; k++)
                    c[i][j] += a[i][k]*b[k][j];
            }


        return c;
    }


    public static void main(String[] args) {

       int[][] a = {{1,3,4},{1,2,3},{1,2,3}};
        int[][] b = {{1,3,4},{1,2,3},{1,2,3}};
        int[][][] c = {{{1,2}},{{1,2}}};

        System.out.println("The original array");
        for (int i =0; i < a.length; i++) {
            for ( int k =0; k < a[i].length; k++)
            System.out.print(a[i][k] +" ");
        }

        SquareMatrix squareMatrix = new SquareMatrix();
        double[][] result = squareMatrix.squareMatrix(a,b);

        System.out.println("\nThe array after square matrix");
        for (int i =0; i < result.length; i++) {
            for ( int k =0; k < result[i].length; k++)
                System.out.print(result[i][k] +" ");
        }

}
}


