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



//    Counting Triangles
//    Given a list of N triangles with integer side lengths, determine how many different triangles there are. Two triangles are considered to be the same if they can both be placed on the plane such that their vertices occupy exactly the same three points.
//        Signature
//        int countDistinctTriangles(ArrayList<Sides> arr)
//        or
//        int countDistinctTrianges(int[][] arr)
//        Input
//        In some languages, arr is an Nx3 array where arr[i] is a length-3 array that contains the side lengths of the ith triangle. In other languages, arr is a list of structs/objects that each represent a single triangle with side lengths a, b, and c.
//        It's guaranteed that all triplets of side lengths represent real triangles.
//        All side lengths are in the range [1, 1,000,000,000]
//        1 <= N <= 1,000,000
//        Output
//        Return the number of distinct triangles in the list.
//        Example 1
//        arr = [[2, 2, 3], [3, 2, 2], [2, 5, 6]]
//        output = 2
//        The first two triangles are the same, so there are only 2 distinct triangles.
//        Example 2
//        arr = [[8, 4, 6], [100, 101, 102], [84, 93, 173]]
//        output = 3
//        All of these triangles are distinct.
//        Example 3
//        arr = [[5, 8, 9], [5, 9, 8], [9, 5, 8], [9, 8, 5], [8, 9, 5], [8, 5, 9]]
//        output = 1
//        All of these triangles are the same
