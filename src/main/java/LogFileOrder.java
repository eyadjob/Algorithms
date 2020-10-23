import java.util.ArrayList;
import java.util.List;

public class LogFileOrder {


    public static List<String> getOrder(int logFileSize, int logLines, String[] logFile) {


        List<String> textLines = new ArrayList<>();
        List<String> numberLines = new ArrayList<>();
        List<String> sortedString = new ArrayList<>();


        for (int i = 0; i < logFile.length; i++) {
            try {
                Integer.parseInt(logFile[i].split("\\s")[1]);
                numberLines.add(logFile[i]);
            } catch (Exception exception) {
                textLines.add(logFile[i]);

            }
        }


        for ( int i=0; i< textLines.size(); i++) {
            String cur  = textLines.get(i);
            int j = i;
            while ( j > 0 && compareString(textLines.get(j-1),textLines.get(j)) > 0) {
                textLines.set(j, textLines.get(j-1));
                textLines.set(j-1, cur);
                j--;

                }
            }

            for ( int i =0; i  < numberLines.size();i++){
                textLines.add(numberLines.get(i));
        }


return textLines;

    }

    public static int compareString(String a, String b) {
    int compare = a.substring(a.indexOf(a.split("\\s")[1]),a.length()).compareTo(b.substring(b.indexOf(b.split("\\s")[1]),b.length())) ;
        if ( compare !=0) {
            return compare;
        } else return  a.split("\\s")[0].compareTo(b.split("\\s")[0]);

    }

    public static void main(String[] args) {

        String[] file = {"a1 9 2 3 1", "ab act zoo","g1 act car", "zo4 4 7", "ab1 off key dog", "aa act zoo"};
       System.out.println(getOrder(5, 5, file));
    }

}
