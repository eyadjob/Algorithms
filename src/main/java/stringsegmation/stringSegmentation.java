package stringsegmation;

import java.util.HashSet;
import java.util.Set;

public class stringSegmentation {

    static  long current =0;
    static long newCurrent =0;
    static int counter =0;
    static Set<String> list = Set.of("apple", "pear", "pier", "pie", "app", "lea");

    public static boolean can_segment_string(String s, Set<String> dict) {
       for ( int i =0; i < s.length(); i++) {
           counter++;
           String first = s.substring(0, i);
           if ( dict.contains(first)) {
               String second = s.substring(i);

               if (second.isEmpty() || dict.contains(second) || can_segment_string(second, dict)) {
                   return true;
               }

           }
       }

       return false;
    }

    public static void main(String[] args) {

        String s= "appleappleappleappleappleappleappleappleappleappleapple";

        current = System.currentTimeMillis();

        for ( int i=0; i < 1000000; i++) {
            System.out.println(can_segment_string(s, list));
            System.out.println(counter);
        }
        newCurrent= System.currentTimeMillis();
        System.out.println(newCurrent - current);
    }


}
