package facebookposition.fbquestions;

public class ChangeInForeignCurrency {
    public static void main(String[] args) {
        int[] denominations = {5, 10, 25, 100, 200};
        int targetMoney = 94;
//        output = false
        System.out.println(canGetExactChange(targetMoney, denominations));

        int[] denominations2 = {4, 17, 29};
        int targetMoney2 = 75;
//        output = false
        System.out.println(canGetExactChange(targetMoney2, denominations2));
    }

    public static boolean canGetExactChange(int targetMoney, int[] denominations) {
        return canGetExactChangeRec(targetMoney, denominations, denominations.length - 1);

    }

    public static boolean canGetExactChangeRec(int targetMoney, int[] denominations, int index) {
        if (targetMoney == 0) return true;
        if (index == -1) return false;
        return canGetExactChangeRec(targetMoney % denominations[index] , denominations, --index);
    }
}