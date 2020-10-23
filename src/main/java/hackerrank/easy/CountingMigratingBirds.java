package hackerrank.easy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountingMigratingBirds {


    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        if (arr.size() == 0) {
            return 0;
        }

        Map<Integer, Integer> fre = new TreeMap<>();
        for (int i = 0; i < arr.size(); i++) {
            if (fre.get(arr.get(i)) != null) {
                fre.put(arr.get(i), fre.get(arr.get(i)) + 1);
            } else {
                fre.put(arr.get(i), 1);

            }
        }

        int temp = 0;
        int lastId = 0;
        for (Map.Entry<Integer, Integer> e : fre.entrySet()
        ) {
            int v = e.getValue();
            if (temp < v) {
                temp = v;
                lastId = e.getKey();
            } else {
                if (temp == v)
                    continue;
            }
        }

        return lastId;

    }

    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(4);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(4);


        int result = migratoryBirds(arr);

        System.out.println(result);
    }

}
