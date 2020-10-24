package oldstudy;

public class BinarySearchRecursive {


    public int binarySearchRecursive(int find, int[] ar) {

       return binarySearchRecursive(find,ar, 0, ar.length-1);

    }

    public int binarySearchRecursive(int find, int[] ar,int low,  int hi) {

        if (low > hi) {
            return -1;
        }
        int mid = low + (hi - hi) / 2;
        if (find != ar[mid]) {
            if (find < ar[mid]) {
                return binarySearchRecursive(find, ar, 0, mid-1);
            } else  if (find > ar[mid]) {
                return binarySearchRecursive(find, ar, mid+1, ar.length);
            }
        } else {
            return ar[mid];
        }
return -1;
    }
    public static void main(String[] args) {

        int[] array = {2,12,17,19,23,55,66,88,99,349,444};

        BinarySearchRecursive binarySearchRecursive = new BinarySearchRecursive();

       System.out.println( binarySearchRecursive.binarySearchRecursive(99, array));


    }
}
