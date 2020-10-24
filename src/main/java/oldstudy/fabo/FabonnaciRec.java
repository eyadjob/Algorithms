package oldstudy.fabo;

public class FabonnaciRec {


    static int bottomUpIterative(int nth) {
        int total =0;
        int n=0;
        int n1=0;
        int temp=0;
        for ( int i =1; i <= nth; i++) {
            
            if ( i ==0)
                continue;

            if (i==1)
                continue;

            n+=i-1;
            n+=i-2;
            temp =n;
            if ( i == nth) {
                total += i - 1;
                total += i - 2;
            }
        }

        return total;

    }

    static void topDownRecursion(int nt) {

    }

    static void topDownRecursionDP(int nt) {

    }


    public static void main(String[] args) {


        System.out.println(bottomUpIterative(10));





    }


}
