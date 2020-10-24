package oldstudy.AmazonQuestions;

public class StarisSteps {

    public static int combinations(int stairs) {
        if(stairs == 0)
            return 0;

        int i = 0;
        int j = 1;

        for(int k = 0; k <= stairs; k++) {
            int temp = j;
            j+= i;
            i = temp;
        }
        return i;
    }


    public static void main(String[] args) {

        System.out.println(combinations(5));

    }
}
