package oldstudy.amjad;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

        static Set<String> stringSet = new HashSet<>();
        static int  count =0;
        StringBuilder stringStack = new StringBuilder();
    public static void main(String[] args){
     String x= "ABCDEFGHIJKL";// BAC , BCA ,CBA , BCA  ,
        permute(x.toCharArray() ,0);
        System.out.println(count );

    }

    public static void permute(char[] s ,int i ) {
        if(i >= s.length) {
            count++;
            stringSet.add(new String(s));
            return;
        }

        for (int j = i; j < s.length ; j++) {
            swap(s  , i,j );
            permute(s, i+1);
            swap(s  , i,j);

        }

    }

    static void swap(char[] c , int i ,int j ) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

}
