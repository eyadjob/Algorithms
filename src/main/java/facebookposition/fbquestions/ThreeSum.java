package facebookposition.fbquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {

    public static void main(String[] args) {

        int[] nums4 =  {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(threeSum2(nums4).toString());
        System.out.println(threeSum(nums4).toString());

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum2(nums).toString());
        System.out.println(threeSum(nums).toString());

        int[] nums3 = {-2, 1, 0, 2, -1, -4};
        System.out.println(threeSum2(nums3).toString());
        System.out.println(threeSum(nums3).toString());



        int[] nums2 = {0};
        System.out.println(threeSum2(nums2));
    }

    public static List<List<Integer>> threeSum2(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num.length < 3) return res;
        for (int x = 0; x < num.length; x++) {
            for (int i = x + 1; i < num.length; i++) {
                for (int k = i + 1; k < num.length; k++) {
                    if (num[x] ==0 && num[i] == 0 && num[k] == 0) {
                        System.out.println();
                    }
                    if (num[x] + num[i] + num[k] == 0) {
                        if (res.isEmpty()) {
                            List<Integer> te = new ArrayList<>();
                            te.add(num[x]);
                            te.add(num[i]);
                            te.add(num[k]);
                            res.add(te);
                            continue;
                        }
                        boolean addOrNot = true;
                        for (List<Integer> v : res) {
                            if ( (v.get(0) ==  num[i] && v.get(1) ==num[x] && v.get(2) ==num[k]) ||
                                    (v.get(1) ==  num[i] && v.get(0) ==num[x] && v.get(2) ==num[k]) ||
                                    (v.get(2) ==  num[i] && v.get(0) ==num[x] && v.get(1) ==num[k]) ||
                                    (v.get(2) ==  num[i] && v.get(1) ==num[x] && v.get(0) == num[k]) ||
                                    (v.get(1) ==  num[i] && v.get(2) ==num[x] && v.get(0) ==num[k]) ||
                                    (v.get(0) ==  num[i] && v.get(2) ==num[x] && v.get(1) ==num[k]) ) {
                                addOrNot = false;
                                break;
                            }
                        }
                        if (addOrNot) {
                            List<Integer> te = new ArrayList<>();
                            te.add(num[x]);
                            te.add(num[i]);
                            te.add(num[k]);
                            res.add(te);
                        }
                    }
                }
            }
        }
        return res;
    }


    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;


    }
}

//Hi guys!
// Concise O(N^2) Java solution
//The idea is to sort an input array and then run through all indices of a possible first element of a triplet. For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.