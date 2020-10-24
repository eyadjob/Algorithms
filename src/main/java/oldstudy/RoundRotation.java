package oldstudy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RoundRotation {



    public static boolean checkRoundRotation(String a, String b) {

        char[] aChar = a.toCharArray();
        char lastCar =aChar[aChar.length-1];

            int i =a.length()-1;
        while (i !=  0)  {
                aChar[i] = aChar[i-1];
                i--;

        }
        aChar[0] = lastCar;

        String string = new String(aChar);
        if (string.equals(b)) {
                return Boolean.TRUE;
            }
        return Boolean.FALSE;

    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "cab";

        int[] test = {1,2,3,4};


        List<Integer> test2 =   Arrays.stream(test).boxed().collect(Collectors.toList());
        List<Integer> test3 =  IntStream.of(test).boxed().collect(Collectors.toList());
       Integer[] test5 =  Arrays.stream(test).boxed().toArray(Integer[]::new);

        System.out.println(checkRoundRotation(a,b));

        System.out.println(checkRoundRotation("abc","cba"));

    }
}
