import org.apache.commons.math3.util.Precision;

import java.util.*;
import java.util.stream.Collectors;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
public class
SongsDurationAmazon {


    public static void main(String[] args) {
        int[] testa = new int[1000];

        for ( int i=0; i< 1000; i++) {
            testa[i] = i+1;
        }

        List<Integer> test = new ArrayList<Integer>();
        test  = Arrays.stream(testa).boxed().collect(Collectors.toList());

        long start2 = System.currentTimeMillis();

        SongsDurationAmazon songsDurationAmazon = new SongsDurationAmazon();
            System.out.println(songsDurationAmazon.IDsOfSongs(100, test).toString());
            float timeConsumed = Precision.round((System.currentTimeMillis() - start2) , 4);
            System.out.println("time consumed in milli seconds :" +timeConsumed);

    }


    List<Integer> IDsOfSongs(int rideDuration,
                             List<Integer> songDurations) {

        Map<Integer, ArrayList<Integer>> result = new TreeMap<>();
        int counter = 0;
        for (int i = 0; i < songDurations.size(); i++) {
            for (int k = i; k < songDurations.size(); k++) {
                counter++;
                int duration = songDurations.get(i) + songDurations.get(k);
                int diff = (rideDuration - 30) - duration;
                if (diff >=0) {
                    ArrayList<Integer> id = new ArrayList<>();
                    id.add(k);
                    id.add(i);
            ArrayList<Integer> value = result.get(diff);
            if (value != null) {
                int firstId = value.get(0);
                int secondId = value.get(1);
                if ((songDurations.get(firstId) < songDurations.get(i) || songDurations.get(firstId) < songDurations.get(k)) && (songDurations.get(firstId) > songDurations.get(secondId))) {
                    result.put(diff, id);
                } else if ((songDurations.get(secondId) < songDurations.get(i) || songDurations.get(secondId) < songDurations.get(k)) && (songDurations.get(secondId) > songDurations.get(firstId))) {
                    result.put(diff, id);
                }

            } else {
                result.put(diff, id);
            }


                }
            }
        }

        return result.get(result.keySet().toArray()[0]);

    }
}