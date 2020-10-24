package oldstudy.coda;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Test4 {

    public static void main(String[] args) {
        Test4 t = new Test4();
        String test = "([{}])";
        System.out.println(t.isValid(test));


        String t5 = "(){}[]";
        System.out.println(t.isValid(t5));


        String t2 = "(}";
        System.out.println(t.isValid(t2));

        String t3 = "[(])";
        System.out.println(t.isValid(t3));

        String t4 = "[({})](]";
        System.out.println(t.isValid(t4));

        String t6 = "}}]]))}])";
        System.out.println(t.isValid(t6));


//        System.out.println(orderWeight("56 65 74 100 99 68 86 180 90"));
//        System.out.println(orderWeight("123 103 2000 4444 99 0"));
        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
        System.out.println(orderWeight("58281 137612 54400 461755 10373 214471 392760 489910 471556 426829 270571 490421 6757 25936 165052 474993 382380 483641 254699 335687 19"));
    }


    public static String orderWeight(String strng) {
        StringBuilder tempString = new StringBuilder();
        int tempInt = 0;
        TreeMap<Integer, String> indexes = new TreeMap<>();

        for (int i = 0; i < strng.length(); i++) {

            if (strng.charAt(i) != ' ') {

                tempInt += Integer.parseInt(String.valueOf(strng.charAt(i)));
                tempString.append(strng.charAt(i));

            } else {
                if (indexes.get(tempInt) != null) {

                    TreeMap<String, Integer> tt = new TreeMap<>();
                    if (!indexes.get(tempInt).equals(tempString.toString())) {
                        tt.put(indexes.get(tempInt), 0);
                        tt.put(tempString.toString(), 0);
                    } else {
                        tt.put(indexes.get(tempInt) + tempString.toString(),0);
                    }

                    StringBuilder ts = new StringBuilder();
                    for (Map.Entry<String, Integer> e : tt.entrySet()) {
                        ts.append(e.getKey() + " ");
                    }
                    indexes.put(tempInt, ts.toString().trim());

                } else {
                    indexes.put(tempInt, tempString.toString());
                }
                tempString = new StringBuilder();
                tempInt = 0;

            }
        }

        if (indexes.get(tempInt) != null) {
            indexes.put(tempInt, indexes.get(tempInt) + " " + tempString.toString());
        } else {
            indexes.put(tempInt, tempString.toString());
        }
        tempString = new StringBuilder();
        tempInt = 0;

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, String> e : indexes.entrySet()) {
            result.append(e.getValue());
            result.append(" ");

        }
        return result.toString().trim();
    }


    public boolean isValid(String braces) {
        Stack<Character> bs = new Stack<>();
        for (int i = 0; i < braces.length(); i++) {
            if (braces.charAt(i) == '{' || braces.charAt(i) == '(' || braces.charAt(i) == '[') {
                bs.push(braces.charAt(i));
            } else {
                if (bs.empty()) {
                    return false;
                }
                if (braces.charAt(i) == '}' && bs.pop() != '{') {
                    return false;
                } else if (braces.charAt(i) == ')' && bs.pop() != '(') {
                    return false;
                } else if (braces.charAt(i) == ']' && bs.pop() != '[') {
                    return false;
                }
            }
        }
        return bs.empty();
    }

}
