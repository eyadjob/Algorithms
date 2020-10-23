package AmazonQuestions;

import java.util.Scanner;

public class Solution2 {

    public static int minimumConcat(String initial, String goal) {

        int sc = 0;
        boolean f = false;
        outer:
        for (int k = 0; k < goal.length(); ) {

            inner:
            for (int i = 0; i < initial.length(); i++) {
                if (i == initial.length()  && f) {
                    sc++;
                    i=0;
                    continue outer;
                } else if (initial.charAt(i) == goal.charAt(k)) {
                    f = true;
                    k++;
                } else if (i == initial.length() - 1 && !f) {
                    return -1;
                } else if (i== goal.length() - 1 && f) {
                    return sc;
                } else if (f) {
                    sc++;
                    f=false;
                }

            }


        }
      if ( f ) sc++;
        return sc;
    }


    public static void main(String[] args) {

        System.out.println(minimumConcat("abc", "acdbc"));

    }

}



