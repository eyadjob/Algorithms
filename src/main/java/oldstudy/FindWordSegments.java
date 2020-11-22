package oldstudy;

import java.util.HashSet;
import java.util.Set;

public class FindWordSegments {


    private static boolean can_segment_string(String s, Set<String> dict, Set<String> founds) {

        for (int i = 1; i <= s.length(); i++) {
            String firstWord = s.substring(0, i);
            if (dict.contains(firstWord)) {
                String nextWord = s.substring(i);
                if (nextWord == null || nextWord.isEmpty() || dict.contains(nextWord)) {
                    return true;
                }

                if (!founds.contains(nextWord)) {
                    if (can_segment_string(nextWord, dict, founds)) {
                        return true;
                    }
                    founds.add(nextWord);
                }
            }
        }


        return false;

    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        String s = "applepie";

        dict.add("pie");
        dict.add("pear");
        dict.add("apple");


        Set<String> founds = new HashSet<>();
        System.out.println("Result = " + can_segment_string(s, dict, founds));


        s = "pineapplepenapple";
        Set<String> dict2 = new HashSet<String>();
        dict.add("apple");
        dict.add("pen");
        dict.add("applepen");
        dict.add("pine");

        dict.add("pineapple");
        Set<String> founds2 = new HashSet<>();
        System.out.println("Result = " + can_segment_string(s, dict2, founds2));

    }
}
