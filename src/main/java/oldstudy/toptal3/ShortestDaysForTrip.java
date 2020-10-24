package oldstudy.toptal3;

import java.util.HashSet;
import java.util.Set;

public class ShortestDaysForTrip {


    public static void main(String[] args) {

        int[] A = {2, 1, 1, 3, 2, 1, 1, 3};

        int[] A2 = {7, 5, 2, 7, 2, 7, 4, 7};

        int[] A3 = {7, 3, 7, 3, 1, 3, 4, 1};

        System.out.println("int[] A = {2,1,1,3,2,1,1,3};");
        System.out.println(solution(A));
        System.out.println(solution2(A));

//        System.out.println("int[] A2 = {7,5,2,7,2,7,4,7};");
//        System.out.println(solution(A2));
//        System.out.println(solution2(A2));
//
//        System.out.println("int[] A3 = {7,3,7,3,1,3,4,1};");
//        System.out.println(solution(A3));
//        System.out.println(solution2(A3));

    }

    public static boolean check(int start, int end, int size, int[] A) {

        Set<Integer> set = new HashSet<Integer>();
        for (int i = start; i <= end; i++)
            set.add(A[i]);
        return set.size() == size;
    }

    public static int solution2(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            set.add(A[i]);
        }
        int setSize = set.size();
        int answer = n;
        for (int i = 0; i < n; i++) {
            int start = i, end = n - 1, best = -1, mid;
            while (start <= end) {
                mid = (start + end) / 2;
                if (check(i, mid, setSize, A)) {
                    best = mid - i ;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (best == -1)
                break;
            answer = Math.min(answer, best - i + 1);
        }
        return answer;
    }



    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            set.add(A[i]);
        }
        int setSize = set.size();
        int answer = n;
        for (int i = 0; i < n; i++) {
            int start = i, end = n - 1, best = -1, mid;
            while (start <= end) {
                mid = start + end >> 1;
                if (check(i, mid, setSize, A)) {
                    best = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (best == -1)
                break;
            answer = Math.min(answer, best - i + 1);
        }
        return answer;
    }

}


