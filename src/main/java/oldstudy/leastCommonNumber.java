package oldstudy;

import org.apache.commons.math3.util.Precision;

import java.util.*;
import java.util.stream.Collectors;

class leastCommonNumber {
    static Integer find_least_common_number_eyad(int[] arr1,
                                            int[] arr2,
                                            int[] arr3) {
     List<Integer> shortest = new ArrayList<>();
     int[] shorted =null;
      if ( arr1.length < arr2.length) {
          if ( arr1.length < arr3.length) {
               shortest = Arrays.stream(arr1).boxed().collect(Collectors.toList());
               shorted = arr1;

          } else if ( arr3.length < arr2.length) {
              shortest = Arrays.stream(arr3).boxed().collect(Collectors.toList());
              shorted = arr3;
          }
      } else if ( arr2.length < arr3.length) {
          shortest = Arrays.stream(arr2).boxed().collect(Collectors.toList());
          shorted = arr2;
      }


      Map<Integer,String> map1 = new HashMap<>();
        for ( int i =0; i < arr1.length; i++) {
            map1.put(arr1[i],"");
        }

        Map<Integer,String> map2 = new HashMap<>();
        for ( int i =0; i < arr2.length; i++) {
            map2.put(arr2[i],"");
        }
        Map<Integer,String> map3 = new HashMap<>();
        for ( int i =0; i < arr3.length; i++) {
            map3.put(arr3[i],"");
        }


      for ( int i =0; i < shorted.length; i++) {
       if ( map1.get(shorted[i]) != null && map2.get(shorted[i]) != null ) {
           return shortest.get(i);
       }
      }

        return null;
    }

    public static void main(String[] args) {

        long start2 = System.currentTimeMillis();
        for ( int i =0; i < 1000; i++) {
            int[] v1 = new int[]{1, 6, 10, 14, 50};
            int[] v2 = new int[]{-1, 6, 7, 8, 50};
            int[] v3 = new int[]{0, 3, 6, 7, 10, 25, 30, 40};
            Integer result = find_least_common_number_eyad(v1, v2, v3);
            System.out.println("Least Common Number: " + result);
        }

        float timeConsumed = Precision.round((System.currentTimeMillis() - start2) , 4);
        System.out.println("time consumed in milli seconds :" +timeConsumed);
    }
}