package facebookposition;

import java.util.LinkedHashMap;
import java.util.Map;

public class LookAndSayPattern {

//    Implement a function that outputs the Look and Say sequence:
//            1
//            11
//            21
//            1211
//            111221
//            312211
//            13112221
//            1113213211
//            31131211131221
//            13211311123113112211


    public static void main(String[] args) {
//        lookAndSay("1");
        lookAndSay2("1");
    }

    public static void lookAndSay(String n) {
        if (!n.equals("1") | n.isEmpty()) return;
        Map<Character, Integer> re = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder(n);
        System.out.println(sb.toString());
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < sb.length(); k++) {
                if (re.get(sb.charAt(k)) == null) re.put(sb.charAt(k), 1);
                else
                    re.put(sb.charAt(k), re.get(sb.charAt(k)) + 1);
            }
            sb = new StringBuilder();
            for (Map.Entry<Character, Integer> e : re.entrySet()) {
                sb.append(e.getValue()).append(e.getKey());
            }
            System.out.println(sb.toString());
            re = new LinkedHashMap<>();
        }
    }


    public static void lookAndSay2(String n) {
        if (!n.equals("1") | n.isEmpty()) return;
        StringBuilder sb = new StringBuilder(n);
        System.out.println(sb.toString());
        int index = 0;
        for (int i = 0; i < 50; i++) {
            StringBuilder re = new StringBuilder();
            for (int k = 0; k < sb.length(); k++) {
                if (k == 0) re.append(1).append(sb.charAt(k));
                else if (sb.charAt(k) == sb.charAt(k - 1))
                    re.replace(index, index + 1, String.valueOf(Integer.parseInt(String.valueOf(re.charAt(index)))+1));
                else {
                    re.append(1).append(sb.charAt(k));
                    index = re.length()-2;
                }
            }
            System.out.println(re.toString());
            index =0;
            sb = new StringBuilder(re);
        }
    }
}
