package paypay;

public class FourthElementSumEqualToNumber {


    public static void findFourElements(int[] a, int n, int x) {

        for (int i = 0; i < n - 3; i++) {
            for (int k = i + 1; k < n - 2; k++) {
                for (int j = k + 1; j < n - 1; j++) {
                    for (int w = j + 1; w < n; w++) {
                        if (a[i] + a[k] + a[j] + a[w] == x)
                            System.out.println(a[i] + " " + a[k] + " " + a[j] + " " + a[w]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {10, 20, 50, 10, 40, 1, 2};
        int n = A.length;
        int X = 91;
        FourthElementSumEqualToNumber.findFourElements(A, n, X);
    }
}
