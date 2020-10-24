package oldstudy.toptalA;

import java.util.ArrayList;
import java.util.List;

public class Test4 {


    public static void main(String[] args) {

        String[] te = {"I>N", "A>I", "P>A", "S>P"};
        System.out.println(new Test4().findWord(te));


        String[] te2 = {"P>E", "E>R", "R>U"};// PERU
        System.out.println(new Test4().findWord(te2));


    }

    public String findWord(String[] s) {

        int n = s.length;
        List<String> re = new ArrayList<>();

        outloop:
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                re.add(String.valueOf(s[i].charAt(0)));
                re.add(String.valueOf(s[i].charAt(2)));
                continue;
            }
            for (int x = 0; x < re.size(); x++) {
                if (re.get(x).charAt(0) == s[i].charAt(2)) {
                    re.add(x, String.valueOf(s[i].charAt(0)));
                    continue outloop;
                } else {
                    if (re.get(x).charAt(0) == s[i].charAt(0)) {
                        re.add(x+1, String.valueOf(s[i].charAt(2)));
                        continue outloop;
                    } else {
                        if (x == re.size() - 1) {
                            re.add(String.valueOf(s[i].charAt(0)));
                            re.add(String.valueOf(s[i].charAt(2)));
                            continue outloop;
                        }
                    }
                }
            }

        }

        return String.join("", re);

    }
}
