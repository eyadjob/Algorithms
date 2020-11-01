package facebookposition;

public class SpiralTwoDimensionalArray {

    {

    }

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(spiral(2)));
//        System.out.println(Arrays.toString(spiral(3)));
//        printArray(spiral(4));
        System.out.println();
        printArray(genSpiral(4));

    }

    public static int[][] spiral(int in) {
        if (in == 0) return new int[0][0];
        int[][] spiral = new int[in][in];
        int c = 1, bot = in - 1, ls = in - 1;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < in; k++) {
                if (i == 0)
                    spiral[k][0] = c++;
                if (i == 1)
                    spiral[in - 1][k] = c++;
                if (i == 2)
                    spiral[bot - k][in - 1] = c++;
                if (i == 3)
                    spiral[ls+1%in][ls - k] = c++;
            }
        }
        return spiral;
    }

    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a[i].length; k++) {
                System.out.print(a[k][i] + ", ");
            }
            System.out.println();
        }

    }

    public static int[][] genSpiral(int n) {
        if (n<=0) {
            throw new IllegalArgumentException("N must be >0");
        }
        int[] dc = new int[]{1,0,-1,0};
        int[] dr = new int[]{0,1,0,-1};
        int dir = 0, val=0, r=0, c=0,limit=n*n;
        int[][] matrix = new int[n][n];
        while (val++ < limit) {
            matrix[r][c] = val;
            r += dr[dir];
            c += dc[dir];
            if (isInvalid(matrix,r, c)) {
                r-= dr[dir];
                c-=dc[dir];
                dir = (dir+1)%4;
                r+= dr[dir];
                c+= dc[dir];
            }
        }
        return matrix;
    }
    private static boolean isInvalid(int[][] m, int r, int c) {
        return r<0||c<0||r>=m.length||c>= m.length||m[r][c] != 0;
    }
}


