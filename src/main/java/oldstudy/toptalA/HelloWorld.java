package oldstudy.toptalA;

import java.util.Arrays;

public class HelloWorld {

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

        System.out.println();
        String[] te =  {"I>N","A>I","P>A","S>P"};
        System.out.println(findWord(te) );

    }

    public static String findWord(String[] s) {
        StringBuilder sb = new StringBuilder();
        for ( int i =0 ; i < s.length; i++) {
            if (!sb.toString().contains(String.valueOf(s[i].charAt(0)))) {
                if (!sb.toString().contains(String.valueOf(s[i].charAt(2)))) {
                    sb.append(String.valueOf(s[i].charAt(0)));
                    sb.append(String.valueOf(s[i].charAt(2)));
                } else {
                    sb.insert(sb.indexOf(String.valueOf(s[i].charAt(2))),String.valueOf(s[i].charAt(0)));
                }
            } if (!sb.toString().contains(String.valueOf(s[i].charAt(2)))) {
                sb.insert(sb.indexOf(String.valueOf(s[i].charAt(0))),String.valueOf(s[i].charAt(2)));

            }
        }
        return sb.toString();
    }


    public static int[] getChange(double M, double P) {

        int[] reArr = {0, 0, 0, 0, 0, 0};

        double re = (M * 100) - P * 100;
        for (int i = dom.length - 1; i >= 0; i--) {
            reArr[i] = (int) (re / dom[i]);
            re = re % dom[i];
        }
        return reArr;
    }
}
