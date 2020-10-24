package oldstudy;

public class SortingArrayNormal {




    public static int[] sortArray(int[] array) {


        for ( int k = 1; k < array.length; k++) {
            int cur = array[k];
            int j =k;
                while ( j > 0 &&    array[j-1]  > cur  ) {
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = cur;

        }
        for ( int i =0; i < array.length; i++) {
            System.out.print(array[i]+" ");

        }

        return array;
    }


    public static void main(String[] args) {
        int [] array = {5,4,2,1,2,5,8,3,2};
            SortingArrayNormal.sortArray(array);


    }

}
