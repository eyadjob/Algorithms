package hackerrank.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ClimbingLadder {

    public static int[] climbingLeaderboard(List<Integer> sc , List<Integer> al) {

        int[] alicesocre = new int[al.size()];
        List<Integer> al2 = Arrays.stream(alicesocre).boxed().collect(Collectors.toList());



        Collections.sort(sc);


        for ( int k =0; k < al.size(); k++) {
            int rank=1;
            int prev = -1;
           innerLoop:  for (int i = sc.size()-1; i >= 0; i--) {
                if ( prev != sc.get(i)) {
                    if (al.get(k) < sc.get(i)) {
                        rank++;
                    } else {
                        alicesocre[k] = rank;
                        break innerLoop;
                    }
                }
                    alicesocre[k] =rank;
                        prev = sc.get(i);
            }
        }

        return alicesocre;
    }

    public static void main(String[] args) {

        List<Integer> scores = new ArrayList<>();
        scores.add(100);
        scores.add(90);
        scores.add(90);
        scores.add(80);
        scores.add(75);
        scores.add(60);



        List<Integer> alice  = new ArrayList<>();
        alice.add(50);
        alice.add(65);
        alice.add(77);
        alice.add(90);
        alice.add(102);


        int[] result = climbingLeaderboard(scores, alice);
        System.out.println(Arrays.toString(result));

    }
}
