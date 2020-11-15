package facebookposition.fbquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums17 = {-48,-46,-46,-46,-45,-45,-44,-42,-38,-36,-35,-34,-33,-32,-32,-32,-30,-29,-28,-28,-26,-25,-23,-19,-15,-13,-12,-10,-8,-7,-6,-4,-2,0,0,0,1,1,2,4,4,5,6,8,11,11,16,16,22,23,23,24,25,25,26,28,29,30,32,33,34,34,35,35,36,36,38,40,41,42,42,42,42,45,48,0,0,0,0,0,0,0};
        int[] nums27 = {-36,-27,-24,-14,-13,2,9};
        merge2(nums17, 75, nums27, 7);
        System.out.println(Arrays.toString(nums17));

        int[] nums16 = {-1,0,1,1,0,0,0,0,0};
        int[] nums26 = {-1,0,2,2,3};
        merge2(nums16, 4, nums26, 5);
        System.out.println(Arrays.toString(nums16));

        int[] nums15 = {0, 0, 3, 0, 0, 0, 0, 0, 0};
        int[] nums25 = {-1, 1, 1, 1, 2, 3};
        merge2(nums15, 3, nums25, 6);
        System.out.println(Arrays.toString(nums15));

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
//        Output: [1,2,2,3,5,6]
        merge2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums12 = {2, 0};
        int[] nums22 = {1};
        merge2(nums12, 1, nums22, 1);
        System.out.println(Arrays.toString(nums12));

        int[] nums13 = {4, 5, 6, 0, 0, 0};
        int[] nums23 = {1, 2, 3};
        merge2(nums13, 3, nums23, 3);
        System.out.println(Arrays.toString(nums13));


        int[] nums14 = {1, 2, 4, 5, 6, 0};
        int[] nums24 = {3};
        merge2(nums14, 5, nums24, 1);
        System.out.println(Arrays.toString(nums14));


    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0) return;
        int memoryIndex = 0, secIndex = 0;
        int[] memory = new int[m + n];
        Arrays.fill(memory, Integer.MAX_VALUE);
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != 0 && secIndex < nums2.length) {
                if (nums1[i] > nums2[secIndex]) {
//                    if ( nums1[i] > )
                    int temp = nums1[i];
                    nums1[i] = nums2[secIndex++];
                    memory[secIndex] = temp;
                    memoryIndex = secIndex;
                }
            } else {
                if (secIndex < nums2.length) {
                    if (nums2[secIndex] <= memory[memoryIndex]) {
                        nums1[i] = nums2[secIndex++];
                    } else {
                        nums1[i] = memory[memoryIndex++];
                    }
                } else nums1[i] = memory[++memoryIndex - m];
            }
        }
    }


    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0) return;
        int secIndex = 0;
        List<Integer> memory = new ArrayList<>(1);
        for (int i = 0; i < nums1.length; i++) {
            if (memory.size() != 0 && memory.get(0) == 23)
                System.out.println(memory.get(0) == 23);
            if (i < m && secIndex < nums2.length) {
                if (nums1[i] > nums2[secIndex] || (memory.size() > 0 && nums1[i] > memory.get(0)) ) {
                    if (memory.size() > 0 && nums2[secIndex] > memory.get(0)) {
                        int temp = nums1[i];
                        nums1[i] = memory.get(0);
                        memory.remove(0);
                        memory.add(temp);
                    } else {
                        int temp = nums1[i];
                        nums1[i] = nums2[secIndex++];
                        memory.add(temp);
                    }
                }
            } else {
                if (secIndex < nums2.length) {
                    if (memory.size() == 0 || nums2[secIndex] <= memory.get(0)) {
                        nums1[i] = nums2[secIndex++];
                    } else {
                        nums1[i] = memory.get(0);
                        memory.remove(0);
                    }
                } else {
                    int temp = nums1[i];
                    nums1[i] = memory.get(0);
                    memory.remove(0);
                    memory.add(temp);
                }
            }
        }
    }

}

