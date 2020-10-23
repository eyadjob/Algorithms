package oldstudy.AmazonQuestions;

public class LandParameter {


    public static int findParameter(int[][] lands) {

        int p = 0;
        for (int i = 0; i < lands.length; i++) {
            for (int k = 0; k < lands[i].length; k++) {

                if (lands[i][k] == 1) {
                    p += 4;

                    if (i+1 != lands.length && lands[i + 1][k] == 1) {
                        p -= 1;

                    }

                    if (i-1 >=0 && lands[i - 1][k] == 1) {
                        p -= 1;
                    }

                    if (k+1 != lands[i].length && lands[i][k + 1] == 1) {
                        p -= 1;

                    }

                    if (k-1 >=0  && lands[i][k - 1] == 1) {
                        p -= 1;

                    }
                }
            }
        }
        return p;
    }

    public static void main(String[] args) {


        int[][] lands = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};

        System.out.println(findParameter(lands));

        int[][] lands2 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};

        System.out.println(findParameter(lands2));


        int[][] lands3 = {{0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

        System.out.println(findParameter(lands3));
    }
}
