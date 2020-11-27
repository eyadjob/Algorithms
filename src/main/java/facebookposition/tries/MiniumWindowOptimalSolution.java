package facebookposition.tries;

import java.util.HashMap;
import java.util.Map;

public class MiniumWindowOptimalSolution {

    public static void main(String[] args) {

        String s = "donutsandwafflemakemehungry";
        String t = "flea";
        System.out.println(minWindow(s, t));

    }

    public static String minWindow(String searchString, String target) {
        Map<Character, Integer> requiredCharacters = new HashMap<>();
        Map<Character, Integer> windowCharacters = new HashMap<>();
        int right = 0, left = 0, n = searchString.length(), charactersInWindowCriteriaMet = 0, charactersRequiredCriteria, minWindowSize = Integer.MAX_VALUE;
        String minWindowString = "";
        for (char c : target.toCharArray()) {
            putInMap(requiredCharacters, c);
        }
        charactersRequiredCriteria = requiredCharacters.size();
        while (right < n) {
            char rc = searchString.charAt(right);
            putInMap(windowCharacters, rc);
            boolean isRequiredCharacter = requiredCharacters.containsKey(rc);
            if (isRequiredCharacter) {
                boolean requiredCriteriaWasMet = requiredCharacters.get(rc).intValue() == windowCharacters.get(rc).intValue();
                if (requiredCriteriaWasMet) {
                    charactersInWindowCriteriaMet++;
                }
            }
            while (charactersInWindowCriteriaMet == charactersRequiredCriteria && left < right) {
                char leftChar = searchString.charAt(left);
                int windowSize = right - left + 1;
                if (windowSize < minWindowSize) {
                    minWindowSize = windowSize;
                    minWindowString = searchString.substring(left, right + 1);
                }
                windowCharacters.put(leftChar, windowCharacters.get(leftChar)-1);

                boolean isLeftCharacterRequired = requiredCharacters.containsKey(leftChar);
                if (isLeftCharacterRequired) {
                    boolean criteraMetFail = windowCharacters.get(leftChar).intValue() < requiredCharacters.get(leftChar).intValue();

                    if ( criteraMetFail) {
                        charactersInWindowCriteriaMet--;
                    }
                }
                left++;
            }
            right++;
        }
        return minWindowString;
    }

    public static void putInMap(Map<Character, Integer> map, char c) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
}
