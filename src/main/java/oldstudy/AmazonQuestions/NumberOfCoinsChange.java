package oldstudy.AmazonQuestions;

import java.util.Arrays;
import java.util.List;

public class NumberOfCoinsChange {


    public static int combinations(int n) {
        return combinationsAmazonMethod(n,100);
    }

    public static int combinationsAmazonMethod(int n,int m) {
        if(n < 0)
            return 0;

        if(n == 0)
            return 1;

        int combinations = 0;

        if(m == 100)
            combinations+= combinationsAmazonMethod(n-100,100);
        if(m >= 50)
            combinations+= combinationsAmazonMethod(n-50,50);
        if(m >= 25)
            combinations+= combinationsAmazonMethod(n-25,25);
        if(m >= 10)
            combinations+= combinationsAmazonMethod(n-10,10);
        if(m >= 5)
            combinations+= combinationsAmazonMethod(n-5,5);

        combinations+= combinationsAmazonMethod(n-1,1);

        return combinations;
    }


    public static List<Integer> coinsList = Arrays.asList(1, 5, 10, 25);
    static int poss =0;
    public static int changeCombination(int num) {


        for ( int i=coinsList.size()-1; i >= 0; i--) {
         int re =  num - coinsList.get(i);
            if ( re > 0  ) {
              poss +=  changeCombination(re);

            } else {
                if ( re < 0 ) {
                    continue;
                }
                return 1;
            }

        }

        return 0;

    }

//    public static int changeCombRec(int ch) {
//
//        changeCombination
//    }


    public static void main(String[] args) {

//        changeCombination(3);
//        System.out.println(poss);
//                System.out.println(changeCombination(3));
//        System.out.println(changeCombination(5));
        changeCombination(15);
        System.out.println(poss);
        System.out.println(combinations(15));
//        System.out.println(changeCombination(20));
//        System.out.println(changeCombination(31));

    }
}
