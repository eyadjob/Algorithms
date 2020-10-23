public class ReverseWordsAmjadSolution {


   static int counter = 0;

    private static void reverse_words(char[] s) {

        double middle = Math.ceil((s.length - 1) / 2.0);
        for (int i = 0, j = s.length - 2; i <= middle && j >= middle; i++, j--) {
            ++counter;
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }

        System.out.println(new String(s));
        int from = 0;
        for (int i = 0; i < s.length; i++) {
            ++counter;
            if (s[i] == ' ' || s[i] == '\0') {
                middle = Math.ceil((i - from - 1) / 2.0) + from;
                for (int j = from, l = i - 1; j < middle; j++, l--) {
                    ++counter;
                    char t = s[j];
                    s[j] = s[l];
                    s[l] = t;
                }
                from = i + 1;

            }
        }

    }

    static void print(char[] s) {
        int i = 0;
        while (s[i] != '\0') {
            System.out.print(s[i]);
            ++i;
        }
        System.out.println();
    }
    static char[] getArray(String t) {
        char[] s = new char[t.length() + 1];
        int i = 0;
        for (;i < t.length(); ++i) {
            s[i] = t.charAt(i);
        }
        s[i] = '\0';
        return s;
    }

    public static void main(String[] args) {
//        char[] s = getArray("Hello World!");
//        print(s);
//        reverse_words (s);
//        print(s);
//
//        s = getArray("Quick brown fox jumped over the lazy dog");
        char[] s = getArray("                                                                                                    ");
        print(s);
        reverse_words(s);
        print(s);
        System.out.println(counter);
    }

}
