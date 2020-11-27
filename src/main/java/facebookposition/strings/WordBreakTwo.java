package facebookposition.strings;

import java.util.*;

public class WordBreakTwo {

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
//        List<String> dict = new ArrayList<>();
//        String s = "catsanddog";
//
//        dict.add("cat");
//        dict.add("cats");
//        dict.add("and");
//        dict.add("sand");
//
//        dict.add("dog");
//
//
//        Set<String> founds = new HashSet<>();
//        System.out.println(wordBreak(s, dict).toString());

        String s2 = "pineapplepenapple";
        List<String> wordDict2 = new ArrayList<>(){{add("apple"); add("pen"); add("applepen"); add("pine"); add("pineapple");}};
        System.out.println(wordBreak(s2, wordDict2).toString());
//        "pine apple pen apple",
//                "pineapple pen apple",
//                "pine applepen apple"

    }
    static List<String> getResult = new ArrayList<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
         getResult = new ArrayList<>();
         wordBreakRec(s, wordDict, 0, new StringBuilder(),new HashSet<>());
         return getResult;
    }


    public static void wordBreakRec(String s, List<String> wordDict, int index, StringBuilder sb, Set<String> picked) {
       String currentString="";
        while( index < s.length()) {
            sb.append(s.charAt(index));
            if ( wordDict.contains(sb.toString())) {
                picked.add(sb.toString());
                wordBreakRec(s,wordDict, ++index,new StringBuilder(sb),picked);
                index--;
                sb.append(" ");
                currentString += sb.toString();
                sb = new StringBuilder();
            }
            index++;
        }
        if (currentString.length()!= 0) getResult.add(currentString);
        currentString = "";
    }


    private Map<String,List<String>> cache = new HashMap<>();
    public List<String> wordBreak2(String s, List<String> wordDict) {
        return backtrack(s,wordDict);
    }
    public List<String> backtrack(String s, List<String> wordDict){
        if(cache.containsKey(s)) return cache.get(s);
        List<String> result = new ArrayList<>();
        for(String word: wordDict) {
            if(!s.startsWith(word)) continue;   // string does not start with this word?
            String next = s.substring(word.length());
            if(next.isEmpty()) {                        // awesome!
                result.add(word);
                continue;
            }
            for(String sub: backtrack(next, wordDict))
                result.add(word + " " + sub);
        }
        cache.put(s, result);
        return result;
    }
}

