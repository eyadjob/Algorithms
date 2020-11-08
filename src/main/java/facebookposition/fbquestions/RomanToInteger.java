package facebookposition.fbquestions;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {


        String s3 = "IX";
        System.out.println(romanToInt(s3));

        String s2 = "IV";
        System.out.println(romanToInt(s2));

        String s = "III";
        System.out.println(romanToInt(s));


        String s4 = "LVIII";
        System.out.println(romanToInt(s4));

        String s5 = "MCMXCIV";
        System.out.println(romanToInt(s5));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        int result = 0;
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1) {
               if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V' || s.charAt(i) == 'I' && s.charAt(i + 1) == 'X' ||  s.charAt(i) == 'X' && s.charAt(i + 1) == 'L' || s.charAt(i) == 'X' && s.charAt(i + 1) == 'C' || s.charAt(i) == 'C' && s.charAt(i + 1) == 'D' || s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                    result += values.get(s.charAt(i + 1)) - values.get(s.charAt(i));
                    i++;
                    continue;
                }
            }
            result += values.get(s.charAt(i));
        }
        return result;
    }
}
