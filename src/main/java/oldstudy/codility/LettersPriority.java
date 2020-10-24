package oldstudy.codility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LettersPriority {

    public static void main(String[] args) {

        String[] te = {"I>N", "A>I", "P>A", "S>P"};
        System.out.println(findWord(te));

        String[] te2 = {"P>E", "E>R", "R>U"};
        System.out.println(findWord(te2));
    }


    public static String findWord(String[] s) {

        List<Character> re = new ArrayList<>();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                re.add(s[i].charAt(0));
                re.add(s[i].charAt(2));
                continue;
            }
            int r = re.size();
            for (int x = 0; x < r; x++) {
                if (re.get(x) == s[i].charAt(2)) {
                    re.add(x, s[i].charAt(0));
                    break;
                } else {
                    if (re.get(x) == s[i].charAt(0)) {
                        re.add(x + 1, s[i].charAt(2));
                        break;
                    }
                }
            }
            if (r == re.size()) {
                re.add(s[i].charAt(0));
                re.add(s[i].charAt(2));
            }
        }

        return re.stream().map(String :: valueOf).collect(Collectors.joining());
    }

}
