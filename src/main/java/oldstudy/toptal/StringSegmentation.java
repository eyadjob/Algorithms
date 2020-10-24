package oldstudy.toptal;

import java.util.HashSet;
import java.util.Set;


public class StringSegmentation {


    static Set<String> re = new HashSet<>();

    public static void main(String[] args) {

        String a = "babaa";
        String b = "ababa";
        String c = "bbbbb";

        System.out.println(solRec(a, new StringBuilder(), new StringBuilder(), new StringBuilder(), 1));
        re = new HashSet<>();
        System.out.println(solRec(b, new StringBuilder(), new StringBuilder(), new StringBuilder(), 1));
        re = new HashSet<>();
        System.out.println(solRec(c, new StringBuilder(), new StringBuilder(), new StringBuilder(), 1));



    }

    public static int solRec(String s, StringBuilder sb1, StringBuilder sb2, StringBuilder sb3, int p) {

        StringBuilder sbT1 = new StringBuilder(sb1);
        StringBuilder sbT2 = new StringBuilder(sb2);
        StringBuilder sbT3 = new StringBuilder(sb3);

        if (s.length() == 0) {
            return re.size();
        }

        if (!(sb1.length() >= s.length() - 2 || p != 1)) {

            sbT1.append(s, sb1.length(), sb1.length() + 1);
            solRec(s, sbT1, sbT2, sbT3, 1);
        }

        if (sbT2.length() + sbT1.length() >= s.length() - 1 || p == 3) {
            return re.size();
        } else {
            sbT2.append(s, sbT1.length() + sbT2.length(), sbT1.length() + sbT2.length() + 1);
            solRec(s, sbT1, sbT2, sbT3, 2);
        }

        if (sbT3.length() + sbT2.length() + sbT1.length() >= s.length()) {
            return re.size();
        } else {

            sbT3.append(s.substring(sbT2.length() + sbT1.length()));
            solRec(s, sbT1, sbT2, sbT3, 3);
        }

        long Aoc = sbT1.toString().chars().filter(ch -> ch == 'a').count();

        if (Aoc == sbT2.toString().chars().filter(ch -> ch == 'a').count() && Aoc == sbT3.toString().chars().filter(ch -> ch == 'a').count()) {

            re.add(sbT1.toString() + "|" + sbT2.toString() + "|" + sbT3.toString());

        }

        return re.size();

    }



}
