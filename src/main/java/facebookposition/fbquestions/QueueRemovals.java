package facebookposition.fbquestions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueRemovals {

    public static void main(String[] args) {

        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        int[] expected_1 = {5, 6, 4, 1, 2};
        System.out.println(Arrays.toString(findPositions2(arr_1, x_1)));
        System.out.println(Arrays.toString(expected_1));

        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};

        int[] expected_2 = {2, 5, 10, 13};
        int[] output_2 = findPositions2(arr_2, x_2);
        System.out.println(Arrays.toString(findPositions2(arr_2, x_2)));
        System.out.println(Arrays.toString(expected_2));



    }

    public static int[] findPositions2(int[] arr, int x) {
        List<Integer[]> arrList = new ArrayList<>();
        int[] result = new int[x];
        for (int i = 0; i < arr.length; i++) {
            arrList.add(i, new Integer[]{arr[i], i});
        }
        for (int k = 0; k < x; k++) {
            int[][] max = new int[1][2];
            for (int i = 0; i < Math.min(x, arrList.size()); i++) {
                if (max[0][0] < arrList.get(i)[0]) {
                    max[0][0] = arrList.get(i)[0];
                    max[0][1] = i;
                }
            }
            result[k] = arrList.get(max[0][1])[1] + 1;
           arrList = removeElementAndDecrement2(arrList, max[0][1], x);
        }
        return result;
    }

    public static List<Integer[]> removeElementAndDecrement2(List<Integer[]> arrList, int p, int rc) {
        arrList.remove(p);
        for (int i = 0; i < Math.min(rc-1,arrList.size()); i++) {
             arrList.get(i)[0] = Math.max(arrList.get(i)[0] - 1, 0);
        }
        return rotateArray2(arrList, rc);
    }

    public static List<Integer[]> rotateArray2(List<Integer[]> arrList, int rc) {
        List<Integer[]> sList = new ArrayList<>(arrList.subList(0, Math.min(rc-1,arrList.size())));
        arrList.removeAll(sList);
        arrList.addAll(sList);
        return arrList;
    }

}
