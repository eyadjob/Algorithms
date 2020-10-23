package codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StringsConstruction {

    public static void main(String[] args) {
//        String a = "abc";
//        String b = "abccba";
//        System.out.println(stringsConstruction(a, b));
//        System.out.println(stringsConstruction2(a, b));

                String a = "hnccv";
                String b = "hncvohcjhdfnhonxddcocjncchnvohchnjohcvnhjdhihsn";
        System.out.println(stringsConstruction(a, b));
        System.out.println(stringsConstruction2(a, b));

    }

    public static int stringsConstruction(String a, String b) {
        int x = a.length();
        long counter = Integer.MAX_VALUE;
        for (int i = 0; i < x; i++) {
            final  int  ii =i;
            counter = Math.min(counter, b.chars().filter(ch -> ch == a.charAt(ii)).count());
        }
        if ( a.length() > b.length()) return 0;
        return (int) counter;
    }

    public static int stringsConstruction2(String a, String b) {
        char[] s1 = a.replaceAll("/s","").toCharArray();
        Arrays.sort(s1);
        String base = new String(s1);
        int counter = 0;
        StringBuilder temp = new StringBuilder();
        for (int i =0; i < b.length(); i++) {
            temp.append(b.charAt(i));
            char[] tc = temp.toString().toCharArray();
            Arrays.sort(tc);
            String toCompare = new String(tc);

            if ( toCompare.contains(base) ) {
                counter++;
                temp = new StringBuilder();
            }
        }
  return counter;
    }



}


