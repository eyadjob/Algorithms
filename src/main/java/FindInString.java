
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindInString {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public boolean searchText(String s,List<String> wordDict) {

        StringBuilder  text = new StringBuilder() ;
         wordDict.forEach(d -> text.append(d.toString()));
        String textToFind = text.toString();
        if (textToFind.length() > 0) {
            List<Character> searchInText = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

            for (int i = 0; i <= searchInText.size() - 1; i++) {
                if (searchInText.get(i).toString().equals(textToFind.substring(0, 1))) {
                    StringBuilder sb = new StringBuilder();
                    for (int z = 0; z < textToFind.length() - 1; z++) {
                        if (z + i < searchInText.size()) {
                            sb.append(searchInText.get(i + z));
                        } else {
                            return Boolean.FALSE;
                        }
                    }
                    if (sb.toString().equals(sb.toString())) {
                        return Boolean.TRUE;
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    public void printResults(String text, int index) {
        if (index != -1) {
            System.out.println("The text \"" + text + "\" was found and at index : " + index);
        } else System.out.println("The text " + text + " was NOT found in your text");

    }


    public static void main(String[] args) {

        FindInString findInString = new FindInString();
        String find = "tamam";
        List<String> test = new ArrayList<>();
        test.add("a");
        test.add("b");
        test.add("bbb");
        test.add("bbbb");


        Boolean  result = findInString.searchText("bb", test);
      System.out.println(result);
    }


}
