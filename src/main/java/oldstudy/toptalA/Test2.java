package oldstudy.toptalA;

import java.util.*;

public class Test2 {

    public static void main(String[] args) {

        String[] te =  {"I>N","A>I","P>A","S>P"};
        System.out.println(new Test2().findWord(te) );
    }


    public  String findWord(String[] s)
    {

        StringBuilder sb  = new StringBuilder();
        Map<String,Double> reMap = new HashMap<>();


        for ( int i=0;  i < s.length; i++) {
            if (reMap.get(String.valueOf(s[i].charAt(0))) == null ) {
                reMap.put(String.valueOf(s[i].charAt(0)),(double)i+1);

            } else {
                reMap.put(String.valueOf(s[i].charAt(0)),reMap.get(String.valueOf(s[i].charAt(0))) + i  );

            }


            if (reMap.get(String.valueOf(s[i].charAt(2))) == null ) {

                reMap.put(String.valueOf(s[i].charAt(2)),(double) Math.negateExact(i+1) );
            } else {

                reMap.put(String.valueOf(s[i].charAt(2)),(double) reMap.get(String.valueOf(s[i].charAt(2))) - i );
            }

        }

        ValueComparator bvc = new ValueComparator(reMap);
        TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);

        System.out.println("unsorted map: " + reMap);
        sorted_map.putAll(reMap);
        System.out.println("results: " + sorted_map);


        for ( Map.Entry<String,Double> v : sorted_map.entrySet()) {
            sb.append(v.getKey());
        }
        return sb.toString();
    }


    class ValueComparator implements Comparator<String> {
        Map<String, Double> base;

        public ValueComparator(Map<String, Double> base) {
            this.base = base;
        }


        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}

