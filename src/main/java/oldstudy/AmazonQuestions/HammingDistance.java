package oldstudy.AmazonQuestions;

public class HammingDistance {


    public  static int hammingDistance(int x, int y ) {
        int counter =0;


        int re = x ^ y;

        while (  re != 0 ) {

            if ( (re & 1) == 1  ) {
                counter++;
            }
            re = re >> 1  ;
        }

        return counter;
    }

    public static void main(String[] args) {

        System.out.println(hammingDistance(12, 2));


    }
}
