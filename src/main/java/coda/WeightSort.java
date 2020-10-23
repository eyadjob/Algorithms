package coda;

import java.util.Map;
import java.util.TreeMap;

public class WeightSort {

    public static void main(String[] args) {

//        System.out.println("180".compareTo("90"));
//        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
//        System.out.println(orderWeight("58281 137612 54400 461755 10373 214471 392760 489910 471556 426829 270571 490421 6757 25936 165052 474993 382380 483641 254699 335687 19"));

        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
//        System.out.println(orderWeight("71899703 200 6 91 425 4 67407 7 96488 6 4 2 7 31064 9 7920 1 34608557 27 72 18 81"));


    }

    public static String recOrder(String st, String newString) {
        StringBuilder re = new StringBuilder(st.trim());
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) != ' ') {
                tempString.append(st.charAt(i));
            }
            if (st.charAt(i) == ' ' || i == st.length() - 1) {
                if (tempString.toString().compareTo(newString) == 0) {
                    re.insert(st.lastIndexOf(tempString.toString()), newString + " ");
                    return re.toString();
                } else {
                    if (tempString.toString().compareTo(newString) < 0) {
                        tempString = new StringBuilder();
                        if (i == st.length() - 1) {
                            re.append(" " + newString);
                        }
                        continue;
                    } else {
                        if (tempString.toString().compareTo(newString) > 0) {
                            re.insert(st.lastIndexOf(tempString.toString()), newString + " ");
                            break;
                        }
                    }
                }
            }
        }

        return re.toString().trim();
    }

    public static String orderWeight(String strng) {
        int tempInt = 0;
        StringBuilder tempString = new StringBuilder();
        TreeMap<Integer, String> indexes = new TreeMap<>();
        for (int i = 0; i < strng.length(); i++) {
            if (strng.charAt(i) != ' ') {
                tempInt += Integer.parseInt(String.valueOf(strng.charAt(i)));
                tempString.append(strng.charAt(i));
            }
            if (strng.charAt(i) == ' ' || i == strng.length() - 1) {
                if (indexes.get(tempInt) != null) {
                    indexes.put(tempInt, recOrder(indexes.get(tempInt), tempString.toString()));
                } else {
                    indexes.put(tempInt, tempString.toString());
                }
                tempString = new StringBuilder();
                tempInt = 0;
            }
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> e : indexes.entrySet()) {
            result.append(e.getValue() + " ");
        }
        return result.toString().trim();
    }


}

