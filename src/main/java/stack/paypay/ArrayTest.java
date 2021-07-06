package stack.paypay;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

    public static void main(String[] args) {
        int[] array = new int[2];
        List<Integer> arrList = new ArrayList<>(2);

        array[0] = 1;
        array[1] = 2;
        array[3] = 3;

        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);

        arrList.forEach(d -> System.out.print(d + ", "));


    }

}
