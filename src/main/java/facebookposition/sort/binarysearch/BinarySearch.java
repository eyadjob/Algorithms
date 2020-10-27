package facebookposition.sort.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {4, 99, 222, 550, 2245, 5555, 9232};
        System.out.println(binarySearch_rec(a, 0, a.length - 1, 9232));
        System.out.println(binarySearch_normal(a, 222));
    }

    public static int binarySearch_normal(int[] arr, int find) {

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == find) {
                return mid + 1;
            } else {
                if (arr[mid] < find) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    public static int binarySearch_rec(int[] arr, int beg, int end, int find) {

        int mid;
        if (end >= beg) {
            mid = (beg + end) / 2;
            if (arr[mid] == find) {
                return mid + 1;
            } else {
                if (arr[mid] < find) {
                    return binarySearch_rec(arr, mid + 1, end, find);
                } else {
                    if (arr[mid] > find) {
                        return binarySearch_rec(arr, beg, mid - 1, find);
                    }
                }
            }
        }
        return -1;
    }
}
