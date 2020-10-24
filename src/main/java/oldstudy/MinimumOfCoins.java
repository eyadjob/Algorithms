package oldstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumOfCoins {


    public static List<Integer> getListOfCoins(int sum, List<Integer> coinsList) {

        Collections.sort(coinsList);

        List<Integer> coins = new ArrayList<>();
        int remaining = sum;
       Outer: for (int k = coinsList.size() - 1; k > 0; k--) {
            if (coinsList.get(k) <= sum)
                remaining = remaining % coinsList.get(k);
            if (remaining == 0) {
                for (int i = 0; i < sum / coinsList.get(k); i++) {
                    coins.add(coinsList.get(k));
                    break Outer;
                }
            } else if (remaining > 0) {
                for (int i = 0; i < sum / coinsList.get(k); i++) {
                    coins.add(coinsList.get(k));
                }
            }
        }
return coins;
    }

    public static void main(String[] args) {

        List<Integer> coid = new ArrayList<>();
        coid.add(1);
        coid.add(3);
        coid.add(5);
     List<Integer>  result =  getListOfCoins(11,coid);
        System.out.println(result.toString());

    }
}