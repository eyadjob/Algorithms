package oldstudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class pythagoreanTriplet{
   public  static List<int[]> find_pythagorean_triplets(int[] arr) {
        //TODO: Write - Your - Code
        List<int[]> triplets = new ArrayList<int[]>();
       Map<Integer, int[]> tripletsMap = new HashMap<>();
        Map<Integer,Integer> qube = new HashMap<>();


        for ( int i =0; i < arr.length; i++) {
            qube.put(arr[i] * arr[i] , i);
        }

       for ( int i =0; i < arr.length; i++) {
           for ( int k =0; k < arr.length; k++) {
             Integer res =   qube.get( (arr[i] * arr[i]) + (arr[k] * arr[k]) );
               if ( res != null ) {
                   tripletsMap.put(res,new int[]{arr[i],arr[k],arr[res]} );

               }
           }
       }

       triplets = tripletsMap.entrySet().stream().map(d -> d.getValue()).collect(Collectors.toList());
        return triplets;
    }

    public static void main(String[] argv) {
        int[] arr = {3, 4, 5, 6, 8, 10, 9, 12, 15, 18, 19};


        List<int[]> t1 = find_pythagorean_triplets(arr);

        System.out.println("*****");
        for (int[] a : t1) {
            for (int x : a) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }


}