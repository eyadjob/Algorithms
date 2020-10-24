package oldstudy;

import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MaxSlidingWindow {

    public static List<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {

        // ArrayDeque for storing max values
        List<Integer> listMax = new ArrayList<>(); // Linkedlist for storing indexes
        List<Integer> wind = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            wind.add(arr[i]);
            int max =0;
            if ( wind.size() >= windowSize) {

                List<Integer>  temp =  new ArrayList<>(wind.subList(i-(windowSize-1), i+1));
                int tempmax =   temp.get(0);
                for ( int k =0; k < temp.size(); k++) {
                 if ( tempmax < temp.get(k)) {
                     tempmax = temp.get(k);
                 }
                }
                listMax.add(tempmax);
            }

        }
        //Write your code

        return listMax; // returning result
    }

    public static void main(String[] args) {

        long start2 = System.currentTimeMillis();

        int arr[]  = new int [100000];
        for(int i = 0;i<100000;i++){
            arr[i] =i;
        }

        for ( int i =0; i < 1000; i++) {

           findMaxSlidingWindow(arr, 100);
        }

        float timeConsumed = ((System.currentTimeMillis() - start2));
        System.out.println("time consumed in milli seconds :" +timeConsumed);

    }
}