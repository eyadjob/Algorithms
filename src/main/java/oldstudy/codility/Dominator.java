package oldstudy.codility;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

    public static void main(String[] args) {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int n = A.length;
        Map<Integer, Integer> re = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (re.get(A[i]) == null) re.put(A[i], 1);
            else re.put(A[i], re.get(A[i]) + 1);
            if (re.get(A[i]) > n / 2) return i;
        }
        return -1;
    }

}
