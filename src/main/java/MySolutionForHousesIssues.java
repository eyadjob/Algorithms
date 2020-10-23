import java.util.ArrayList;
import java.util.List;

public class MySolutionForHousesIssues {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days) {


        List<Integer> statesList = new ArrayList<Integer>();
        for (int i = 0; i < days; i++) {
            statesList.clear();
            for (int k = 0; k < states.length; k++) {
                int before = 0;
                int after = 0;

                before = k - 1 < 0 ? 0 : states[k - 1];
                after = k + 1 == states.length ? 0 : states[k + 1];

                statesList.add((after ^ before) == 1 ? 1 : 0);


            }
            for (int j = 0; j < statesList.size(); j++) {
                states[j] = statesList.get(j);
            }

        }


        return statesList;
        // WRITE YOUR CODE HERE
    }
    // METHOD SIGNATURE ENDS
}




