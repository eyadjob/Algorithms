import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestSumToZero {


    public static Map<Integer, Integer[]> re = new HashMap<>();

    public static Map<Integer, Integer[]> getClosetSum(List<Integer> arr) {

        for ( int i =0; i < arr.size(); i++) {

            if ( arr.get(i) - arr.get((arr.size()-1)-i) == 0) {
                re.put(0,new Integer[]{arr.get(i),arr.get((arr.size()-1)-i) });
                break;
            }
        }

        return re;
    }

    public static void main(String[] args) {


        List<Integer> list  =new ArrayList<>();

        list.add(4);
        list.add(-100);
        list.add(1);
        list.add(-2);
        list.add(100);
        list.add(3);

        System.out.println( getClosetSum(list).toString());


    }


}
