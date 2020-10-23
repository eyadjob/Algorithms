package oldstudy.AmazonQuestions;

public class FindElementsInRotatedSortedArray {


    public static int findMinimum(int[] arr) {


        return 0;

    }



    public static int counter=0;

    public static int findMI(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while(start < end) {

            System.out.println("start " + start);
            System.out.println("end " + end);
            counter++;
            if (array[start] < array[end]) {
                return array[start];
            }

            int mid = (start + end)/2;
            if (array[mid] >= array[start]) {
                start = mid+1;
            } else {
                end = mid;
            }


        }
        return array[start];
    }


    public static int findMax(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while(start < end) {

            counter++;
            if (array[start] < array[end]) {
                return array[start];
            }

            int mid = (start + end)/2;
            if (array[mid] >= array[start]) {
                start = mid+1;
            } else {
                end = mid;
            }


        }
        return array[start-1];
    }

    public static void main(String[] args) {
//        Find min element in rotated, sorted array
//
//        Find the minimum element in a rotated, sorted array.
//
//         Example: 4,5,6,7,8,2,3 Answer: 2

        int[] arr = {4,5,6,7,8,9,0,2,3};

        System.out.println("find min " + findMI(arr));
        System.out.println(counter);

        System.out.println("max is " + findMax(arr));



    }

}
