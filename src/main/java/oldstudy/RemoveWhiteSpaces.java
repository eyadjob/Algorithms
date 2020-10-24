package oldstudy;

import java.util.Arrays;

public class RemoveWhiteSpaces {

    public static void remove_white_spaces(char[] arr) {

        int r = 0;
        int w = 0;
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + (c) < arr.length) {
                if (arr[i] == ' ' || arr[i] == '\t') {
                    c++;
                    r++;
                } else {
                    arr[w] = arr[r];
                    r++;
                    w++;
                }

            } else {
                arr[w] = arr[r];
                r++;
                w++;
                arr[i] = '\0';
            }

        }
    }

    public static void main(String[] args) {
        char[] s = helper.getArray("Hello World!");
        helper.print(s);
        remove_white_spaces(s);
        helper.print(s);

        char[] temp = helper.getArray("HelloWorld!");
        helper.print(temp);
        System.out.println(helper.are_equal(s, temp));


        s = helper.getArray("    Quick brown fox jumped   over lazy   dog           ");
        temp = helper.getArray("Quickbrownfoxjumpedoverlazydog");
        helper.print(s);
        remove_white_spaces(s);
        helper.print(s);
        System.out.println(helper.are_equal(s, temp));
    }

    static class helper {

        static char[] getArray(String t) {

            return t.toCharArray();
        }

        static void print(char[] s) {

            System.out.println(new String(s));
        }

        static boolean are_equal(char[] s, char[] x) {
            for ( int i =0; i < x.length-1; i++) {
               if (  x[i] == s[i] || s[i] == '\0'){
                   continue;
               } else { return false;}
            }
            return true;
        }

    }
}
