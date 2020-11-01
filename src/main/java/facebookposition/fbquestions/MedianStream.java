package facebookposition.fbquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianStream {

    public static void main(String[] args) {

        int[] arr = {5, 15, 1, 3};
        System.out.println(Arrays.toString(findMedian(arr)));

    }

    public static int[] findMedian(int[] arr) {
        List<Integer> re = new ArrayList<>();
        for ( int i =0 ; i < arr.length; i++) {
            if ( i == 0) re.add(arr[i]);
            int[] temp = new int[i+1];
            for ( int k =0; k <= i;k++) {
                temp[k] = arr[k];
            }
            Arrays.sort(temp);
            if ( temp.length%2 == 0 ) re.add((int) Math.ceil((temp[(temp.length/2)-1] + temp[(int)Math.floor(temp.length/2)]) / 2 ));
                else
                    re.add(temp[(int)Math.ceil(temp.length/2)]);


        }

    }

}
