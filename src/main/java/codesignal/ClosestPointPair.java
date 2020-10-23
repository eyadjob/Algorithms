package codesignal;

public class ClosestPointPair {

    public static void main(String[] args) {
//       int[][] p = {{0, 11}, {-7, 1}, {-5, -3}};
//        System.out.println(closestPointPair(p));

        int[][] p2 = {{19, -15},
                {4, 9},
                {13, -7},
                {-3, -1},
                {-10, 30}};
        System.out.println(closestPointPair(p2));
//        System.out.println(closestPointPair3(p2));


    }

    public static double closestPointPair(int[][] p) {
        double dit = Double.MAX_VALUE, newValue;
        for (int i = 0; i < p.length-1; i++) {
             for (int j = i+1; j < p.length; j++) {
                newValue = Math.sqrt(Math.pow(p[i][0] - p[j ][0], 2) + Math.pow(p[i][1] - p[j ][1], 2));
                if (newValue < dit) dit = newValue;
            }
        }
        return dit;
    }

    public static double closestPointPair3(int[][] p) {

        double dit = Double.MAX_VALUE, newValue;
        for (int i = 0; i < p.length; i++) {

                if (i == p.length - 1) break;
                newValue = Math.sqrt(Math.pow(p[i][0] - p[i+ 1][0], 2) + Math.pow(p[i][1] - p[i + 1][1], 2));
                System.out.println(newValue );
                if (newValue < dit) dit = newValue;
            }

        return dit;
    }
}

