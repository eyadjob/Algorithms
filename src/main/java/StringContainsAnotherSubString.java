import java.util.ArrayList;
import java.util.List;

public class StringContainsAnotherSubString {

    public static int counter = 1;
    public static boolean subStringIsFound(List<String> list, String os) {

        for (int i = 0; i < list.size(); i++) {
            String tempInner = list.get(i);
            for (int j = 0; j < os.length(); j++) {
                for (int k = tempInner.length() - 1; k >= 0; k--) {
                    ++counter;
                    if (k != 0) {
                        if (os.charAt(j) == tempInner.charAt(k)) {
                            return false;
                        }
                    } else {
                        if (os.charAt(j) == tempInner.charAt(k)) {
                            if (tempInner.length() > 1) {
                                tempInner = tempInner.substring(1);
                            } else {
                                tempInner = "";
                            }
                        }
                    }
                }
                if (tempInner.length() == 0) {
                    tempInner = list.get(i);
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {

        List<String> s = new ArrayList<>();
        s.add("abc");
        s.add("xyz");
        String f = "axbyczabc";
        System.out.println(subStringIsFound(s, f));
        System.out.println(counter);
    }

}
