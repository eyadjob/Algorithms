package facebookposition.fbquestions;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
//            Character[] current = strs[i].chars().mapToObj(c -> (char)c).toArray(Character[]::new);


    public static void main(String[] args) {
        String[] st = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams(st).toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> temp = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] current = strs[i].toCharArray();
            Arrays.sort(current);
            String currentString = Arrays.toString(current);
            if (temp.get(currentString) == null) {
                List<String> forMap = new ArrayList<>();
                forMap.add(strs[i]);
                temp.put(currentString, forMap);
            } else {
                temp.get(currentString).add(strs[i]);
            }
        }
        for (Map.Entry<String, List<String>> v : temp.entrySet()) {
            result.add(v.getValue());
        }
        return result;
    }
}
