package toptal3;

public class RightShift {

    public static void main(String args[]) {


        for (int i = 0; i < 10; i++) {
            for (int x = 0; x < 10; x++) {


                System.out.println(i + " " + x + " " + ((i + x) >> 1));
                System.out.println();


            }
        }
    }

}