package facebookposition.recalling;

import java.util.HashMap;
import java.util.Map;

public class MiniMumWindowSubString {

    public static void main(String[] args) {
        String s = "donutsandwaffelmakemehungry";
        String t = "flea";
        System.out.println(minWindowBruteForce(s, t));

        System.out.println(minWindowOptimal(s, t));
    }

    public static String minWindowOptimal(String searchString, String t) {
        Map<Character, Integer> requiredCharacters = buildMappingOfCharactersToOccurrences(t);
        Map<Character, Integer> windowCharacterMapping = new HashMap<Character, Integer>();

        int left = 0;
        int right = 0;

        int totalCharFrequenciesToMatch = requiredCharacters.size();
        int charFrequenciesInWindowThatMatch = 0;

        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
        String minWindow = "";

        while (right < searchString.length()) {
            char characterAtRightPointer = searchString.charAt(right);
            addCharacterToHashtableMapping(windowCharacterMapping, characterAtRightPointer);

            boolean rightCharIsARequirement = requiredCharacters.containsKey(characterAtRightPointer);

            if (rightCharIsARequirement) {
                boolean requirementForCharacterMet = requiredCharacters.get(characterAtRightPointer).intValue() == windowCharacterMapping.get(characterAtRightPointer).intValue();

                if (requirementForCharacterMet) {
                    charFrequenciesInWindowThatMatch++;
                }
            }

            while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {
                char characterAtLeftPointer = searchString.charAt(left);
                int windowSize = right - left + 1;

                if (windowSize < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = windowSize;
                    minWindow = searchString.substring(left, right + 1);
                }

                windowCharacterMapping.put(characterAtLeftPointer, windowCharacterMapping.get(characterAtLeftPointer) - 1);

                boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
                if (leftCharIsARequirement) {
                    boolean characterFailsRequirement = windowCharacterMapping.get(characterAtLeftPointer).intValue() < requiredCharacters.get(characterAtLeftPointer).intValue();

                    if (characterFailsRequirement) {
                        charFrequenciesInWindowThatMatch--;
                    }
                }

                left++;
            }
            right++;
        }
        return minWindow;
    }

    private static Map<Character, Integer>  buildMappingOfCharactersToOccurrences(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            int occurrencesOfCharacter = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), occurrencesOfCharacter + 1);
        }

        return map;
    }

    private static void addCharacterToHashtableMapping(Map<Character, Integer> map, Character c) {
        int occurrences = map.getOrDefault(c, 0);
        map.put(c, occurrences + 1);
    }


    public static String minWindowBruteForce(String searchString, String target) {
        int n = searchString.length();
        int minWindowSoFar = Integer.MAX_VALUE;
        String currentSubString = "", minWindowString="";
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                currentSubString = searchString.substring(left, right + 1);
                boolean containsAllCharacters = containsAllCharacters(target, currentSubString);
                if (containsAllCharacters && currentSubString.length() < minWindowSoFar) {
                    minWindowSoFar = currentSubString.length();
                    minWindowString =  currentSubString;
                }
            }
        }
        return minWindowString;
    }

    public static boolean containsAllCharacters(String target, String currentString) {
        Map<Character, Integer> requiredChars = new HashMap<>();

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            requiredChars.put(c, requiredChars.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < currentString.length(); i++) {
            int occurrenceForCharacter = 0;
            char cc = currentString.charAt(i);
            if (requiredChars.containsKey(cc)) {
                occurrenceForCharacter = requiredChars.get(cc) - 1;
            }

            if (occurrenceForCharacter == 0) {
                requiredChars.remove(cc);
            } else {
                requiredChars.put(cc, occurrenceForCharacter);
            }

        }
        return requiredChars.isEmpty();
    }
}
