import java.util.Arrays;

public class MoveZeros {

    public static void move_zeros_to_left_in_array(int[] arr) {

        int oldValue = 0;
        int zeroIndex = 0;
        outloop:
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                recur(arr, i, zeroIndex, oldValue);
            }
        }
    }

    public static void recur(int[] arr, int in, int zeroIndex, int oldValue) {

        if (arr[zeroIndex] != 0) {
            oldValue = arr[zeroIndex];
            arr[zeroIndex] = 0;
            arr[in] = oldValue;
            zeroIndex++;

        } else {

            recur(arr, in, ++zeroIndex, oldValue);
        }

    }


    public static void main(String[] args) {
        int[] v = new int[]{1, 10, -1, 11, 5, 0, -7, 0, 25, -35};
        System.out.println("Original Array: " + Arrays.toString(v));
        move_zeros_to_left_in_array(v);
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + ", ");
        }

    }

}

