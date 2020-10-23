package codility;

import java.util.Arrays;

public class Anagram {

    static int[] dom = {1, 5, 10, 25, 50, 100};

    public static void main(String[] args) {
        int[] arrtemp = getChange(5, 0.99);
        int[] arrtemp2 = getChange(3.14, 1.99);// should return [0,1,1,0,0,1]
        int[] arrtemp3 = getChange(4, 3.14); // should return [1,0,1,1,1,0]
        int[] arrtemp4 = getChange(0.45, 0.34);// should return [1,0,1,0,0,0]
        System.out.print(Arrays.toString(arrtemp));
        System.out.println();
        System.out.print(Arrays.toString(arrtemp2));
        System.out.println();
        System.out.print(Arrays.toString(arrtemp3));
        System.out.println();
        System.out.print(Arrays.toString(arrtemp4));
    }

    public static int[] getChange(double m, double p) {
        int[] res = new int[6];
        int re = (int) (100 * m ) - (int) (100 * p );
        for ( int i = dom.length-1; i >=0; i--) {
            res[i] = (int) re / dom[i];
            re = re % dom[i];
        }
        return res;
    }



    public static boolean isAnagram(String input1, String input2) {

        char[] s1 = input1.replaceAll("/s","").toCharArray();
        char[] s2 = input2.replaceAll("/s","").toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1,s2);

    }
}

