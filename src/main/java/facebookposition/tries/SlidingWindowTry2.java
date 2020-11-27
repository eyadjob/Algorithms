package facebookposition.tries;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowTry2 {


    public static void main(String[] args) {
        String s = "donutsandwafflemakemehungry";
        String t = "flea";
        System.out.println(minWindow(s, t));

    }

    public static String minWindow(String searchString, String target) {
        Map<Character, Integer> requiredCharacters = new HashMap<>();
        Map<Character, Integer> windowCharacters = new HashMap<>();
        String currentMinWindowSoFar = "";
        for (char c : target.toCharArray()) {
            fillMap(requiredCharacters, c);
        }
        int right = 0, left = 0, minWindowLength = Integer.MAX_VALUE, currentWindowLength = 0, n = searchString.length(),
                currentMatchMet = 0, requiredCharactersCriteria = 0;

        requiredCharactersCriteria = requiredCharacters.size();
        while (right < n) {
            char rightChar = searchString.charAt(right);
            fillMap(windowCharacters, rightChar);
            boolean rightCharacterIsRequired = requiredCharacters.containsKey(searchString.charAt(right));


            if (rightCharacterIsRequired) {
                boolean requiredCharsMet = requiredCharacters.get(rightChar).intValue() == windowCharacters.get(rightChar).intValue();
                if (requiredCharsMet) {
                    currentMatchMet++;
                }
            }

            while (currentMatchMet == requiredCharactersCriteria && left < right) {
                char leftChar = searchString.charAt(left);
                String currentWindow = searchString.substring(left, right + 1);
                if (currentWindow.length() < minWindowLength) {
                    minWindowLength = currentWindow.length();
                    currentMinWindowSoFar = searchString.substring(left, right + 1);;
                }
                windowCharacters.put(leftChar, windowCharacters.get(leftChar) - 1);
                boolean isLeftCharacterRequired = requiredCharacters.containsKey(leftChar);

                if (isLeftCharacterRequired) {
                    boolean criteriaMetFail = windowCharacters.get(leftChar).intValue() < requiredCharacters.get(leftChar).intValue();
                    if (criteriaMetFail) {
                        currentMatchMet--;
                    }
                }
                left++;
            }
            right++;
        }
        return currentMinWindowSoFar;

    }

    public static void fillMap(Map<Character, Integer> chars, char c) {
        chars.put(c, chars.getOrDefault(c, 1) + 1);

    }

}
