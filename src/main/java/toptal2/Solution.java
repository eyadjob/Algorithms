package toptal2;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
//        int[] A = {1, 3, 6, 4, 1, 2};
        int[] A = {1, 2, 3};
        Solution solution = new Solution();

        System.out.println(solution.solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int temp = 1;
        int max = 0;
        boolean f = false;
//        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {

                if (temp != A[i]) {
                    if ( i+1 < A.length) {
                        if (temp < A[i + 1]) {
                            f = true;
                            break;
                        } else {
                            continue;
                        }
                    } else {
                        f = true;
                        break;
                    }
                } else {
                    i=0;
                    temp++;
                }
        }

        if (f ==true) {
            return temp;
        } else {
            return temp+1;
        }

    }


}
