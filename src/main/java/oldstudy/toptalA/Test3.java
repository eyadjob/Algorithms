package oldstudy.toptalA;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {

        String[] te = {"I>N", "A>I", "P>A", "S>P"};
        System.out.println(new Test3().findWord(te));
        System.out.println(new Test3().findWord1(te, new ArrayList<Character>(),'/','/', 0));


        String[] te2 = {"P>E", "E>R", "R>U"};// PERU
        System.out.println(new Test3().findWord(te2));


    }

    public String findWord(String[] s) {

        List<Character> reAr = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (!reAr.contains(s[i].charAt(0))) {
                if (!reAr.contains(s[i].charAt(2))) {
                    reAr.add(s[i].charAt(0));
                    reAr.add(s[i].charAt(2));
                } else {
                    reAr.add(reAr.indexOf(s[i].charAt(2)), s[i].charAt(0));
                }
            } else {
                reAr.add(reAr.indexOf(s[i].charAt(0)) + 1, s[i].charAt(2));
            }
        }
        return reAr.toString();
    }


    public int findWord1(String[] oa, List<Character> ra, char c, char s, int i) {

        if (oa.length - 1 == i) {
            return -1;
        }
        char ft = oa[i].charAt(0), st = oa[i].charAt(2);

        if (ra.contains(s)) {
            return ra.indexOf(s);
        }

        ra.add(findWord1(oa, ra, ft, st, i) != -1 ? findWord1(oa, ra, ft, st, i) : 0, ft);
        ra.add(findWord1(oa, ra, st, ft, ++i) != -1 ? findWord1(oa, ra, st, ft, ++i) : 0, ft);
        System.out.println(ra);
        return ra.indexOf(s);
    }


}

