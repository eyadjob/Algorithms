package facebookposition.fbquestions;

public class ReverseToMakeEqual {



    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 3, 4, 2};
        System.out.println(reverse(a, b ));
    }


    boolean areTheyEqual(int[] array_a, int[] array_b) {
        if (array_a.length !=array_b.length) return false;
        if (!checkSumIsTheSame(array_a, array_b, 0, array_a.length-1)) return false;
        if (checkTheSame(array_a, array_b)) return true;
        for (int i = 0; i < array_a.length; i++) {
            for (int k = i; k < array_a.length; k++) {
                if (array_a[i] != array_b[i])
                    if (checkSumIsTheSame(array_a, array_b, i, k)) {
                        if (checkTheSame(array_a, reverseAndReturnCompleteArray(array_b, i, k))) return true;
                    }
            }
        }
        return false;

    }


    public static boolean reverse(int[] a, int[] b) {
        if (a.length != b.length) return false;
        if (!checkSumIsTheSame(a, b, 0, a.length-1)) return false;
        if (checkTheSame(a, b)) return true;
        for (int i = 0; i < a.length; i++) {
            for (int k = i; k < a.length; k++) {
                if (a[i] != b[i])
                    if (checkSumIsTheSame(a, b, i, k)) {
                        if (checkTheSame(a, reverseAndReturnCompleteArray(b, i, k))) return true;
                    }
            }
        }
        return false;
    }

    public static boolean checkTheSame(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static boolean checkSumIsTheSame(int[] a, int[] b, int s, int e) {
        int aSum = 0, bSum = 0;
        for (int i = s; i <= e; i++) {
            aSum += a[i];
            bSum += b[i];
        }
        return aSum == bSum;
    }

    public static int[] reverseAndReturnCompleteArray(int[] b, int i, int k) {
        while (i < k) {
            int temp = b[i];
            b[i] = b[k];
            b[k] = temp;
            i++;
        }
        return b;
    }

}


//    Reverse to Make Equal
//    Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
//        Signature
//        bool areTheyEqual(int[] arr_a, int[] arr_b)
//        Input
//        All integers in array are in the range [0, 1,000,000,000].
//        Output
//        Return true if B can be made equal to A, return false otherwise.
//        Example
//        A = [1, 2, 3, 4]
//        B = [1, 4, 3, 2]
//        output = true
//        After reversing the subarray of B from indices 1 to 3, array B will equal array A.