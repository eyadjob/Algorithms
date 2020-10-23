package oldstudy.treesbook;

import java.util.Arrays;

public class HelloWorld {


    public static void main(String[] args) {
        String input1= "cat";
        String input2 = "act";
        System.out.println(isAnagram(input1, input2));
    }

    public static boolean isAnagram(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
            return Arrays.equals(c2,c1);
    }
}
