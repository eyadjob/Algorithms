package paypay;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {4, 99, 222, 550, 2245, 5555, 9232};
        System.out.println(binarySearch_rec(a, 0, a.length - 1, 9232));
        System.out.println(binarySearch_normal(a, 9232));
    }


    public static int binarySearch_rec(int[] a, int num, int n, int num2) {

        return 0;
    }

    public static int binarySearch_normal(int[] a, int num) {
        int mid = a.length / 2;
        int n = a.length-1;
        int i = -1;
        while (i < n) {
            i++;
            if (a[i] == num) return i;
            if (num > a[mid]) {
                i = mid;
                mid = n;
            } else if (num < a[mid])
                n = mid;
        }
        return -1;

    }

}
