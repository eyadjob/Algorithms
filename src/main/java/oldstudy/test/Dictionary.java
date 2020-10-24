package oldstudy.test;

import java.util.Set;

public class Dictionary {

    static  long current =0;
    static long newCurrent =0;

    static int counter =0;
    static Set<String> list = Set.of("apple", "pear", "pier", "pie", "app", "lea");


    public static void main(String[] args) {
        current = System.currentTimeMillis();

       for ( int i=0; i < 1000000; i++) {
           System.out.println(canBeSeg("appleappleappleappleappleappleappleappleappleappleapple", 0));
           System.out.println(counter);
       }

        newCurrent= System.currentTimeMillis();
        System.out.println(newCurrent - current);

    }


    static boolean canBeSeg(String s, int j) {
    if ( s.isEmpty() && !list.contains(""))
        return false;

        if (j >= s.length()) {
            return true;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = j; i < s.length(); i++) {
            counter++;
            sb.append(s.charAt(i));
            if (list.contains(sb.toString())) {
                if (canBeSeg(s, i + 1)) {
                    return true;
                }
            }

        }

        return false;
    }


}
