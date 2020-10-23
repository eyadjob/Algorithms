package oldstudy;

public class ReverseArray {




    public int[] reverseArray(int[] array) {

        int index = array.length;
        for (int i = 0; i < index / 2; i++) {
            int temp = array[i];
            array[i] = array[(index - 1) - i];
            array[(index - 1) - i] = temp;
        }

        return array;
    }
    public static void main(String[] args) {


        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("The original array");
        for (int i =0; i < array.length; i++) {
            System.out.print(array[i] +" ");
        }

        ReverseArray reverseArray = new ReverseArray();
        int[] result = reverseArray.reverseArray(array);

        System.out.println("\nThe array after reversing");
        for (int i =0; i < array.length; i++) {
            System.out.print(array[i] +" ");
        }


    }


}

