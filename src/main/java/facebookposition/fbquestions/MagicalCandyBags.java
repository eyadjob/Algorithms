package facebookposition.fbquestions;

public class MagicalCandyBags {

    public static void main(String[] args) {
        int[] arr = {2, 1, 7, 4, 2};
        System.out.println(maxCandies(arr, 3));

    }

    public static int maxCandies(int[] arr, int k) {
        int max, totalCandy = 0, maxIndex = 0;
        while (k > 0) {
            max= Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    maxIndex = i;
                }
            }
            arr[maxIndex] = (int) Math.floor(arr[maxIndex] / 2);
            totalCandy += max;
            k--;
        }
        return totalCandy;
    }
}
