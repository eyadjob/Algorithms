
public class SquareRootAmjadSolution {
    private static final double EPSILON = 0.00001;

    private static double square_root_iterative(double x) {
        double low = 0;
        double high = 1 + (x / 2);
        while (low < high) {

            double mid = (low + high) / 2;
            double sqr = mid * mid;
            double diff = Math.abs(x - sqr);

            if (diff <= EPSILON) {
                return mid;
            }

            if (sqr < x) {
                low = mid;
            } else {
                high = mid;
            }
        }


        return -1;
    }


    private static void test(double x) {
        double res1 = square_root_iterative(x);
        double res2 = Math.sqrt(x);

        double diff = Math.abs(res1 - res2);
        System.out.println(diff <= EPSILON * 10);
    }
    public static void main(String[] args) {
        double count = 0;
        for (double i = 0.01; i < 10000; i += 0.01) {
            test(i);
            ++count;
        }

        System.out.println("Completed Count = " + count);
    }
}
