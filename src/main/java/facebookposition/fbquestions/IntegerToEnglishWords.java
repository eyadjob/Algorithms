package facebookposition.fbquestions;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {

    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static String numberToWords2(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        StringBuilder words = new StringBuilder();

        while (num > 0) {
            if (num % 1000 != 0)
                words = new StringBuilder( helper(num % 1000) +THOUSANDS[i] + " " + words);
            num /= 1000;
            i++;
        }

        return words.toString().trim();
    }


    private static String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);

    }

    public static void main(String[] args) {
        int num = 123;
        System.out.println(numberToWords2(num));

        int num2 = 12345;
        System.out.println(numberToWords2(num2));
    }

    public static String numberToWords(int num) {
        Map<Integer, String> numbersNames = new HashMap<>();
        numbersNames.put(1, "One");
        numbersNames.put(2, "Two");
        numbersNames.put(3, "Three");
        numbersNames.put(4, "Four");
        numbersNames.put(5, "Five");
        numbersNames.put(6, "Six");
        numbersNames.put(7, "Seven");
        numbersNames.put(8, "Eight");
        numbersNames.put(9, "Nine");
        numbersNames.put(11, "Eleven");
        numbersNames.put(12, "Twelve");
        numbersNames.put(13, "Thirteen");
        numbersNames.put(14, "Fourteen");
        numbersNames.put(15, "Fifteen");
        numbersNames.put(16, "Sixteen");
        numbersNames.put(17, "Seventeen");
        numbersNames.put(18, "Eighteen");
        numbersNames.put(19, "Nineteen");
        numbersNames.put(20, "Twenty");
        numbersNames.put(30, "Thirty");
        numbersNames.put(40, "Forty");
        numbersNames.put(50, "Fifty");
        numbersNames.put(60, "Sixty");
        numbersNames.put(70, "Seventy");
        numbersNames.put(80, "Eighty");
        numbersNames.put(90, "Ninety");
        Map<Integer, String> numberCategory = new HashMap<>();
        numberCategory.put(1, "");
        numberCategory.put(2, "");
        numberCategory.put(3, "Hundred");
        numberCategory.put(4, "Thousand");
        numberCategory.put(5, "");
        numberCategory.put(6, "");
        numberCategory.put(7, "Million");
        numberCategory.put(8, "");
        numberCategory.put(9, "");
        numberCategory.put(10, "Billion");

        StringBuilder sb = new StringBuilder();
        int modResult = num, i = 1, remaining = num, place = 1, categoryAmount = 0;
        while (remaining != 0) {
            modResult = remaining % 10;
            String numName;
            if (place % 2 != 0) {
                numName = numbersNames.get(modResult);
            } else {
                numName = numbersNames.get(modResult * 10);
            }
            if (i == 1) {
                sb.insert(0, numName).insert(0, " ");
            } else if (i == 2) {
                sb.insert(0, numName).append(" ");
            } else if (i == 3) {
                sb.insert(0, numName).insert(0, " ").insert(numbersNames.get(modResult).length() + 1, " Hundred ");
            } else if (i >= 4 && i <= 6) {
                if (remaining / 100 < 1) {
                    sb.insert(0, numbersNames.get(remaining)).insert(0, " ").insert(numbersNames.get(remaining).length() + 1, " Thousand");
                    remaining = remaining / 100;
                } else {

                    remaining = remaining / 100;
                    sb.insert(0, numbersNames.get(remaining % 100)).insert(0, " Hundered ");
                    remaining = remaining / 10;
                    sb.insert(0, numbersNames.get(remaining % 10)).insert(0, " Hundered ");
                }
            } else if (i >= 7 && i <= 10) {

            }

            i++;
            place++;
            remaining = remaining / 10;

        }
        return sb.toString();
    }
}
