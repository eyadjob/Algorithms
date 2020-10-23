import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SamllestSubString {



    public static String getSmallestSubstring(String main, String resubString) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean innerfalg = false;
        outer:
        while (i < main.length()) {


            String toTest = main.substring(i, resubString.length()+i);
            Map<Character, Integer> sub =    counter(toTest);
            Map<Character, Integer>  reqMap =  counter(resubString);

            boolean flag =true;
           inner: for ( Map.Entry<Character,Integer> e : sub.entrySet()) {
                if ( reqMap.get(e.getKey()) != null ) {
                    if ( reqMap.get(e.getKey()) == e.getValue() ) {
                        continue inner;
                    } else {flag = false; break inner;}
                } else {flag=false; break inner;}
            }
            if ( flag == true ) {
                return toTest;
            }
            i++;



        }
        return null;
    }

    public static    Map<Character, Integer> counter(String toTest) {

        Map<Character, Integer> count = new TreeMap<>();
        for (int k = 0; k < toTest.length(); k++) {
            if (count.get(toTest.charAt(k)) == null) {
                count.put(toTest.charAt(k), 1);
            } else {
                count.put(toTest.charAt(k), count.get(toTest.charAt(k)) +1);
            }

        }
        return count;
    }

    public static void main(String[] args) {


        String main = "eyadttiisr";
        String subString ="tisr";

        System.out.println(getSmallestSubstring(main, subString));
    }
}
