package facebookposition.fbquestions;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    public static void main(String[] args) {
        String s = "abcdefg";
        List<String> re = permuteString(s, 0, s.length()-1);

        System.out.println(re.toString());
        System.out.println(re.size());

    }
    static List<String> re = new ArrayList<>();
    public static List<String> permuteString(String str, int l, int r) {
        if (l == r) {
            re.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permuteString(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
        return re;
    }

    public static String swap(String s, int i, int j) {
        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}
