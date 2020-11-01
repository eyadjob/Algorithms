package facebookposition;

public class interSectionOfTwoArrays {

    public static void main(String[] args) {

        int[] a = {17};
        int[] b = { 15, 17, 19, 21, 25, 27,21};
        System.out.println(getDifference(a, b));


    }

    public static int getDifference(int[] a, int[] b) {
        int ic = 0, ai = 0, bi = 0;
        for (int i = 0; i < Math.max(a.length, b.length); i++) {
            if (ai > a.length - 1 || bi > b.length - 1) return ic;
            if (a[ai] < b[bi]) {
                ai++;
            } else if (a[ai] > b[bi]) {
                bi++;
            } else {
                ic++;
                ai++;
                bi++;
            }
        }
        return ic;
    }
}
