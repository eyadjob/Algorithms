package AmazonQuestions;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedList {


    public static List<Integer> mergeList(int[] a, int[] b) {

        List<Integer> re = new ArrayList<>();

        int si = 0;
        if (a.length > b.length) {
            si = a.length;
        } else {
            si = b.length;
        }


        int k = 0;
        for (int i = 0; i < si; i++) {

            if (i < a.length ) {
                if (k < b.length ) {
                    if (a[i] < b[k] ) {
                        if (re.size()!= 0 && i > 0 && a[i] == re.get(re.size() - 1)) {
                            continue;
                        } else {
                        re.add(a[i]);}
                    } else {
                        if ( re.size()!=0) {
                            if (b[k] != re.get(re.size() - 1)) {
                                re.add(b[k]);
                                k++;
                                i--;
                            }
                        } else {
                            re.add(b[k]);
                            k++;
                            i--;}
                    }
                }

            } else {
                if (k < b.length) {
                    if (k > 0 && b[k] == re.get(re.size() - 1)) {
                        continue;
                    } else {
                        re.add(b[k]);
                        k++;
                        i--;}
                }

            }
        }

        for (int x =k; x < b.length;x++) {
            if (k > 0 && b[x] == re.get(re.size() - 1)) {
               continue;
            }
            re.add(b[x]);
        }


        return re;

    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6, 9, 12};
        System.out.println(mergeList(a, b).toString());

        int[] a2 = {3, 3, 4};
        int[] b2 = {4};
        System.out.println(mergeList(a2, b2).toString());

        int[] a3 = {7, 8, 9};
        int[] b3 = {1, 8, 20, 24};
        System.out.println(mergeList(a3, b3));

        int [] a4 = {1,2,2,3,3,4,5,6,7};
        int []b4 = {4,5,6,7,8,8,8};
        System.out.println(mergeList(a4,b4 ));


    }
}
