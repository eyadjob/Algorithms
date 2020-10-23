package oldstudy;

public class BinarySearch {

    public int binarySearch(int[] array, int numToFind) {
        int counter = 0;
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            ++counter;
            int mid = 0;
            mid = ((high + low) / 2);
            if (array[mid] == numToFind) {
                System.out.println(counter);
                System.out.println(array[mid]);
                return mid;
            } else {
                if (array[mid] < numToFind) {
                    low = mid + 1;

                } else { high = mid -1; }
            }

        }
        System.out.println(counter);
        return -1;

    }


    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        binarySearch.binarySearch(array, 18);
    }
}
