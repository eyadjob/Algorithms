package oldstudy.hackerrank.easy;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class TripletsCompare {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        int scorea = 0;
        int scoreb = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                ++scorea;
            }
            if (a.get(i) < b.get(i)) {
                ++scoreb;
            }

        }

        List<Integer> score = new ArrayList<>();
        score.add(scorea);
        score.add(scoreb);
        return score;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(17);
        a.add(28);
        a.add(30);
        b.add(99);
        b.add(16);
        b.add(8);

        List<Integer> result = compareTriplets(a, b);

        System.out.println(result.toString());

    }

}