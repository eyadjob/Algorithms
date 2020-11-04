package facebookposition.fbquestions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingTriangles {

    public static void main(String[] args) {

        ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        int expected_1 = 3;
        System.out.println(countDistinctTriangles(arr_1));

        ArrayList<Sides> arr_2 = new ArrayList<>();
        arr_2.add(new Sides(3, 4, 5));
        arr_2.add(new Sides(8, 8, 9));
        arr_2.add(new Sides(7, 7, 7));
        int expected_2 = 3;
        System.out.println(countDistinctTriangles(arr_2));

        ArrayList<Sides> arr_3 = new ArrayList<>();
        arr_3.add(new Sides(8, 4, 6));
        arr_3.add(new Sides(100, 101, 102));
        arr_3.add(new Sides(84, 93, 173));
        int expected_3 = 3;
        System.out.println(countDistinctTriangles(arr_3));

        ArrayList<Sides> arr_4 = new ArrayList<>();
        arr_4.add(new Sides(2, 2, 3));
        arr_4.add(new Sides(3, 2, 2));
        arr_4.add(new Sides(2, 5, 6));
        int expected_4 = 2;
        System.out.println(countDistinctTriangles(arr_4));

        ArrayList<Sides> arr_5 = new ArrayList<>();
        arr_5.add(new Sides(5, 8, 9));
        arr_5.add(new Sides(5, 9, 8));
        arr_5.add(new Sides(9, 5, 8));
        arr_5.add(new Sides(9, 8, 5));
        arr_5.add(new Sides(8, 9, 5));
        arr_5.add(new Sides(8, 5, 9));
        int expected_5 = 1;
        System.out.println(countDistinctTriangles(arr_5));
        int[][][] test = {{{6}, {1, 2, 3}}, {{6}, {1, 2, 3}}};


    }


    public static int countDistinctTriangles(ArrayList<Sides> arr) {
        Map<Integer, List<List<Integer>>> triangles = new HashMap<>();
        for (Sides e : arr) {
            int sidesSum = e.a + e.b + e.c;
            if (triangles.get(sidesSum) == null) {
                List<Integer> sides = new ArrayList<>() {{add(e.a);add(e.b);add(e.c);}};
                List<List<Integer>> similarTriangles = new ArrayList<>();
                similarTriangles.add(sides);
                triangles.put(sidesSum, similarTriangles);
            } else {
                boolean addFlag = false;
                for (List<Integer> lv : triangles.get(sidesSum)) {
                       if (!lv.contains(e.a) && !lv.contains(e.b) && !lv.contains(e.c)) {
                           addFlag = true;
                           break;
                       }
                    }
                if (addFlag) {
                    List<Integer> diffSumTria = new ArrayList<>() {{add(e.a);add(e.b);add(e.c);}};
                    triangles.get(sidesSum).add(diffSumTria);
                }
            }
        }
        return triangles.values().stream().mapToInt(List::size).sum();
    }


    public static class Sides {
        int a;
        int b;
        int c;

        public Sides(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }


    }


}
