package oldstudy.datastructure;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayListEyad<E> {

    public static void main(String[] args) {
        ArrayListEyad<Integer> test = new ArrayListEyad<>(Integer.class,10);

        test.add(1);
        test.add(2);

        for ( int i=0; i < test.size();i++) {
            System.out.println(test.get(i));
        }
    }
    private E[] arr ;
    int size=0;

    public int size() {
        return arr.length;
    }



    public  ArrayListEyad(Class<E> c, int s) {
        // Use Array native method to create array
        // of a type only known at run time
        @SuppressWarnings("unchecked")
        final E[] a = (E[]) Array.newInstance(c, s);
       this.arr = a;
        System.out.println(arr.length);
    }



    public Object get(int index) {

        if (index <= arr.length) {
            return arr[index];
        } else {
             throw  new IllegalArgumentException("index out of boundary");
        }
    }

    public void add(E  el) {

        if ( size < arr.length  ) {
            arr [size++] = el;
        } else {
             Object[] temp = new Object[arr.length+10];
            temp  = Arrays.copyOf(arr,arr.length-1);

            arr = (E[]) temp;
        }
    }

}
