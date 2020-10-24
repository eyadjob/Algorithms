package oldstudy.codility;

public class FrogJmp {

    public static void main(String[] args) {

        System.out.println(solution(10,80,30));
    }

    public static int solution(int X, int Y, int D) {

        int dd = Y - X ;

        return (int) Math.ceil(   (double) dd / D  ) ;

    }


}
