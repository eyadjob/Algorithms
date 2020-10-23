import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HousesAlogrithms {


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days)

    {   List<Integer>  stateslist = new ArrayList<>();

        for ( int j =0; j < days; j++) {
            stateslist.clear();
            for(int i=0;i<states.length ;i++){
                int before;
                int after;
                before = i-1 < 0 ? 0:states[i-1];
                after= i+1 >= states.length ? 0:states[i+1];

                int x = (before ^ after) == 1?1:0;
                stateslist.add(x);

            }
            for (int k = 0;k<states.length;k++){
                states[k] =stateslist.get(k);
            }
        }

        return stateslist;

        // METHOD SIGNATURE ENDS
    }

    public static void main(String[] args) {
        System.out.println(cellCompete(new int []{1,0,0,0,0,1,0,0},1));
    }
}
