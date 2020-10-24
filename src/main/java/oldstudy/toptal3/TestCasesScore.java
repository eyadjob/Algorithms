package oldstudy.toptal3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCasesScore {

    public static void main(String[] args) {


        String[] T = {"codility1","codility3","codility2","codility4b","codility4a"};
        String[] R = {"Wrong answer","OK","OK","Runtime error","OK"};

        String[] T2 = {"test1a", "test2", "test1b", "test1c", "test3"};
        String[] R2 = {"Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"};

        String[] T3 = {"codility1", "codility3", "codility2", "codility4b", "codility4a"};
        String[] R3 = {"Wrong answer", "OK", "OK", "Time limit exceeded", "OK"};

        TestCasesScore solution = new TestCasesScore();
        System.out.println("T1, R1");
        System.out.println(solution.solution(T, R));

        System.out.println("T2, R2");
        System.out.println(solution.solution(T2, R2));

        System.out.println("T3, R3");
        System.out.println(solution.solution(T3, R3));


    }


    public int solution(String[] T, String[] R) {

        Map<Integer, List<String>> testGroupMap = new HashMap<>();
        StringBuilder tn = new StringBuilder();

        for (int i = 0; i < T[0].length(); i++) {
            if (!Character.isDigit(T[0].charAt(i))) {
                tn.append(T[0].charAt(i));
            } else {
                break;
            }
        }


        for (int i = 0; i < T.length; i++) {
            String tg = T[i].replace(tn, "");
            StringBuilder tempTestGroup = new StringBuilder();
            testGroupLoop:
            for (int x = 0; x < tg.length(); x++) {
                if (Character.isDigit(tg.charAt(x))) {
                    tempTestGroup.append(tg.charAt(x));
                } else {
                    break testGroupLoop;
                }
            }

            int tgInteger = Integer.parseInt(tempTestGroup.toString());

            if (testGroupMap.get(tgInteger) == null) {
                List<String>  re = new ArrayList<>();
                re.add(R[i]);
                testGroupMap.put(tgInteger, re);
            } else {
                testGroupMap.get(tgInteger).add(R[i]);
            }
        }


        int scoreCounter = 0;
        for (Map.Entry<Integer, List<String>> v : testGroupMap.entrySet()) {

            boolean flag = true;
            for (int i = 0; i < v.getValue().size(); i++) {
                if (v.getValue().get(i) == "OK") {
                    continue;
                } else {
                    flag = false;
                }
            }

            if (flag)scoreCounter++;

        }

        return (int) Math.floor(100 * ((double) scoreCounter / testGroupMap.size()));

    }


}