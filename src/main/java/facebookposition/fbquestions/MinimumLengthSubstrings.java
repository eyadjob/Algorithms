package facebookposition.fbquestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumLengthSubstrings {


    public static void main(String[] args) {
        String s = "dcbefebce";
        String t = "fde";
        System.out.println(minLengthSubstring(s,t));
        String s2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t2 = "cbccfafebccdccebdd";
        System.out.println(minLengthSubstring(s2,t2));

        String te = "={\"name\":\"External checklist\",\"id\":12,\"checkItems\":[{\"id\":8,\"name\":\"Wheel Cap\",\"passedChoices\":[5000],\"choices\":[{\"id\":5000,\"name\":\"Available\"},{\"id\":5001,\"name\":\"Not Available\"}],\"repairTasks\":[]},{\"id\":12,\"name\":\"Tool kit - Tools\",\"passedChoices\":[5000],\"choices\":[{\"id\":5000,\"name\":\"Available\"},{\"id\":5001,\"name\":\"Not Available\"}],\"repairTasks\":[]},{\"id\":13,\"name\":\"Spare tire \",\"passedChoices\":[5000],\"choices\":[{\"id\":5000,\"name\":\"Available\"},{\"id\":5001,\"name\":\"Not Available\"}],\"repairTasks\":[]},{\"id\":23,\"name\":\"Fire Extinguisher \",\"passedChoices\":[5000],\"choices\":[{\"id\":5000,\"name\":\"Available\"},{\"id\":5001,\"name\":\"Not Available\"}],\"repairTasks\":[]}]}\n" +
                "checklistDetails_2={\"name\":\"Internal checklist\",\"id\":16,\"checkItems\":[{\"id\":3,\"name\":\"Internal mirrors\",\"passedChoices\":[5000],\"choices\":[{\"id\":5000,\"name\":\"Available\"},{\"id\":5001,\"name\":\"Not Available\"}],\"repairTasks\":[]},{\"id\":5,\"name\":\"Cigarette Lighter\",\"passedChoices\":[5000],\"choices\":[{\"id\":5000,\"name\":\"Available\"},{\"id\":5001,\"name\":\"Not Available\"}],\"repairTasks\":[]},{\"id\":6,\"name\":\"Ash Tray\",\"passedChoices\":[5000],\"choices\":[{\"id\":5000,\"name\":\"Available\"},{\"id\":5001,\"name\":\"Not Available\"}],\"repairTasks\":[]},{\"id\":24,\"name\":\"Sun Visor \",\"passedChoices\":[5000],\"choices\":[{\"id\":5000,\"name\":\"Available\"},{\"id\":5001,\"name\":\"Not Available\"}],\"repairTasks\":[]}]}\n" +
                "checklistDetails_3={\"name\":\"List of seats\",\"id\":20,\"checkItems\":[{\"id\":34,\"name\":\"Front seats\",\"passedChoices\":[5200],\"choices\":[{\"id\":5200,\"name\":\"Ready\"},{\"id\":5201,\"name\":\"Needs Cleaning\"}],\"repairTasks\":[]},{\"id\":35,\"name\":\"Rear seats\",\"passedChoices\":[5200],\"choices\":[{\"id\":5200,\"name\":\"Ready\"},{\"id\":5201,\"name\":\"Needs Cleaning\"}],\"repairTasks\":[]}]}\n" +
                "checklistDetails_4={\"name\":\"There is smoking\",\"id\":21,\"checkItems\":[{\"id\":36,\"name\":\"Smoking \",\"passedChoices\":[5000,5001],\"choices\":[{\"id\":5000,\"name\":\"Available\"},{\"id\":5001,\"name\":\"Not Available\"}],\"repairTasks\":[{\"id\":99,\"name\":\" smoking\",\"isRepeated\":false,\"cost\":{\"value\":200.0,\"currencyId\":1}}]}]}"

    }


    public static int minLengthSubstring(String s, String t) {
        Map<Character,  List<Integer> > tInHashMap = new HashMap<>();
        Map<Character, List<Integer>> sInHashMap = new HashMap<>();
        for ( int i =0; i < t.length();i++) {
            tInHashMap.put(t.charAt(i), i);
        }
        for ( int i =0; i < s.length();i++) {
            sInHashMap.put(s.charAt(i), i);
        }
        int max =0;
        for ( Map.Entry<Character,Integer> e : tInHashMap.entrySet()) {
            if ( sInHashMap.get(e.getKey()) == null ) return -1;
            if ( max < sInHashMap.get(e.getKey()))  max = sInHashMap.get(e.getKey());
        }
        return max+1;
    }

}
