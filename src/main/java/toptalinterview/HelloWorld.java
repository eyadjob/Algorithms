package toptalinterview;

public class HelloWorld {


    public static void main(String[] args) {

        System.out.println(numberOfCarryOperations(65, 55)); // 2
        System.out.println(numberOfCarryOperations(123, 456)); // 0
        System.out.println(numberOfCarryOperations(555, 555));// 3
        System.out.println(numberOfCarryOperations(900, 11)); // 0
        System.out.println(numberOfCarryOperations(145, 55)); // 2
        System.out.println(numberOfCarryOperations(0, 0)); // 0
        System.out.println(numberOfCarryOperations(1, 99999)); // 5
        System.out.println(numberOfCarryOperations(999045, 1055)); // 5
        System.out.println(numberOfCarryOperations(101, 809)); // 1
        System.out.println(numberOfCarryOperations(189, 209)); // 1

    }

    public static int numberOfCarryOperations(int d1, int d2) {

        String s1 = String.valueOf(d1);
        String s2 = String.valueOf(d2);
        int count = 0;
        int temp = 0;
        int i = 0;
        int f = 0;

        if (s1.length() > s2.length()) {
            i = s1.length();
            f = 1;
        } else {
            i = s2.length();
            f = 2;
        }

        for (int x = 0; x < i; x++) {

            if (Integer.parseInt(String.valueOf(s1.charAt(x))) + Integer.parseInt(String.valueOf(s2.charAt(x))) + temp > 10) {
                count++;
                temp = 1;
            } else {
                temp = 0;
                continue;

            }
        }

        return count;
    }
}
