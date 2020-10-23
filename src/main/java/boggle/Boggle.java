//package boggle;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class Boggle {
//
//    Set<String> dic = new HashSet<>();
//    char[][] grid;
//
//    Set<StringBuilder> word = new HashSet<>();
//
//    Boggle(char[][] grid, Set dic) {
//
//        this.grid = grid;
//        this.dic = dic;
//    }
//
//    public static void main(String[] args) {
//        char[][] grid = new char[][]{
//                {'c', 'a', 't'},
//                {'r', 'r', 'e'},
//                {'t', 'o', 'n'}
//        };
//
//        Set<String> dictionary = new HashSet<String>();
//        dictionary.add("art");
//        dictionary.add("cat");
//        dictionary.add("cater");
//        dictionary.add("cartoon");
//        dictionary.add("toon");
//        dictionary.add("moon");
//        dictionary.add("not");
//        dictionary.add("apple");
//        dictionary.add("ton");
//
//        Boggle b = new Boggle(grid, dictionary);
//        Set<String> words = b.find_all_words();
//        for (String s : words) {
//            System.out.println(s);
//        }
//    }
//
//
//
//    public Set<String> find_all_words() {
//        StringBuilder wo = new StringBuilder();
//        for (int i = 0; i < grid.length; i++) {
//            innerLoop:
//            for (int k = 0; k < grid[i].length; k++) {
//                wo.append(grid[i][k]);
//                if (dic.contains(wo)) {
//                    word.add(wo);
//                } else {
//                    continue innerLoop;
//                }
//
//            }
//
//            return null;
//        }
//    }
//
//
//}
