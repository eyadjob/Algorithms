package toptal;

import java.util.ArrayList;
import java.util.List;

public class SolutionCircle {

    int cc = 0;
    public static void main(String[] args) {
        String s = "ABDCA";
        int[] x = {2,-1,-4,-3,3};
        int[] y = {2,-2,4,1,-3};
        System.out.println(new SolutionCircle().solution(s,x,y));

        String s2 = "ABB";
        int[] x2 = {1,-2,-2};
        int[] y2 = {1,-2,-2};
        System.out.println(new SolutionCircle().solution(s2,x2,y2));

        String s3 = "CCD";
        int[] x3 = {1,-1,2};
        int[] y3 = {1,-1,-2};
        System.out.println(new SolutionCircle().solution(s3,x3,y3));

    }

    public int solution(String s, int[] x, int[] y) {
        int pc = 0;
        List<Character> cl = new ArrayList<>();
        List<Integer> pointValues = new ArrayList<>();
        int rv =0;
        char rvc='*';

        for (int i = 0; i < s.length(); i++) {
            if (!cl.contains(s.charAt(i))) {
                cl.add(s.charAt(i));
                pointValues.add(Math.max(Math.abs(x[i]), Math.abs(y[i])));
            } else {
                rv= Math.max(Math.abs(x[i]), Math.abs(y[i]));
                rvc = s.charAt(i);
                break;
            }
        }

        for(int i =0; i< pointValues.size(); i++) {
           if ( pointValues.get(i) < rv ) {
               pc++;
           } else {
               if(  pointValues.get(i) == rv &&  rvc != s.charAt(i)) {
                   pc++;
               }
           }
        }
        return pc;
    }


}
