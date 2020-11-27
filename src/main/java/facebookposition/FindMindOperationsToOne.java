package facebookposition;

public class FindMindOperationsToOne {

    public static void main(String[] args) {
        System.out.println(findMinOperations(15));
        System.out.println(findMinOperations2(15));
    }

    public static int findMinOperations2(int n) {
        if (n == 0 || n == 1) return 0;
        int operationsCount = 0;
        if (n % 2 != 0) {
            n += 1;
            operationsCount++;
        }
        while (n != 1) {
            n /= 2;
            operationsCount++;
        }
        return operationsCount;
    }

    public static int findMinOperations(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;
        if (n % 2 == 0) return 1 + findMinOperations(n / 2);
        int first = 1 + findMinOperations(n - 1);
        int second = 1 + findMinOperations(n - 1);
        return Math.min(first, second);

    }
}

//    The question is to find the fewest number of operations needed to get to 1.
//        available opperations:
//        - add 1
//        - subtract 1
//        - divide by 2
//
//        input: 15
//        output: 5
//        because:
//        15->16->8->4->2->1
