package oldstudy.hackerrank.medium;

public class QueenAttack {


    public static int queensAttack(int n, int k, int rq, int cq, int[][] ob) {

        int counter = 0;

        int[] cpi = {rq, cq};
        int[] rpi = {rq, cq};
        int[] cpd = {rq, cq};
        int[] rpd = {rq, cq};

        int[] ii = {rq, cq};
        int[] dd = {rq, cq};
        int[] id = {rq, cq};
        int[] di = {rq, cq};

        for (int i = 1; i < n; i++) {

            if (cpi[1] < n) {
                ++cpi[1];
                if (checkObstacle(k, ob, cpi, n, "i")) {
                    ++counter;
                }
            }

            if (cpd[1] > 1) {
                --cpd[1];
                if (checkObstacle(k, ob, cpd, n, "d")) {
                    ++counter;
                }
            }

            if (rpi[0] < n) {
                ++rpi[0];
                if (checkObstacle(k, ob, rpi, n, "i")) {
                    ++counter;
                }
            }

            if (rpd[0] > 0) {
                --rpd[0];
                if (checkObstacle(k, ob, rpd, n, "d")) {
                    ++counter;
                }
            }

            if (ii[0] < n && ii[1] < n) {
                ++ii[0];
                ++ii[1];
                if (checkObstacle(k, ob, ii, n, "i")) {
                    ++counter;
                }
            }

            if (id[0] < n && id[1] > 1) {
                ++id[0];
                --id[1];
                if (checkObstacle(k, ob, id, n, "i")) {
                    ++counter;
                }
            }

            if (dd[0] > 1 && dd[1] > 1) {
                --dd[0];
                --dd[1];
                if (checkObstacle(k, ob, dd, n, "d")) {
                    ++counter;
                }
            }

            if (di[0] > 1 && di[1] < n) {
                --di[0];
                ++di[1];
                if (checkObstacle(k, ob, di, n, "d")) {
                    ++counter;
                }
            }
        }

        return counter;
    }

    public static boolean checkObstacle(int k, int[][] ob, int[] po, int n, String re) {
        if (k > 0) {
            for (int i = 0; i < ob.length; i++) {

                if (ob[i][0] == po[0] && ob[i][1] == po[1]) {
                    if (re.equals("i")) {
                        po[0] = n;
                        po[1] = n;
                        return false;
                    } else {
                        po[0] = -1;
                        po[1] = -1;
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//
//        5 3
//        4 3
//        5 5
//        4 2
//        2 3
        int[][] obstacles = {{5, 5}, {4, 2}, {2, 3}};
        int result = queensAttack(8, 0, 5, 4, obstacles);
        System.out.println(result);

    }


}
