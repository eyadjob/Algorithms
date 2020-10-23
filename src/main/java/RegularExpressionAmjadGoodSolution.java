import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionAmjadGoodSolution {
       static int count =0;
        public static void main(String[] args) {
            test("abb", "abb");
            test("abbc", "ab*operator");
            test("abb", "ab*");

            test("", "b*operator");
            test("a", "ab*");

            test("aaabbbbbcccd", "a*bbb*operator*d");
            test("a", "ab*");
            test("aaabbbbbcccd", "a*bbb*.*d");
            test("aaabbbbbcccde", "a*bbb*.*d");
            test("b", "b*");
            test("aabcd", "aa*d");
            test("", "aa*d");
            test("", "a*");
            test("b", "b*operator");
            test("b", "b.*");
            test("bh", "b.*");
            System.out.println(count);
        }

        public static void test(String s, String p) {
            boolean output2 = regx_match(s, p);

            Pattern pattern = Pattern.compile(p);
            Matcher matcher = pattern.matcher(s);

            if (output2) {
                System.out.println(s + " " + p + " matched - " + matcher.find());
            } else {
                System.out.println(s + " " + p + " did not match - " + matcher.find());
            }

        }

        private static boolean regx_match(String s, String p) {

            int j = 0;
            char lastChar = '\0';
            char nextP = '\0';
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if (i + 1 < p.length()) {
                    nextP = p.charAt(i + 1);
                }
                if (c == '*') {
                    while (j < s.length()) {
                        if (lastChar == s.charAt(j)) {
                            j++;
                        } else {
                            break;
                        }
                        count++;
                    }

                } else if (j < s.length() && (c == '.' || c == s.charAt(j))) {
                    lastChar = s.charAt(j);
                    j++;
                    count++;
                } else if (nextP != '*') {
                    count++;
                    return false;
                }
            }
            return true;
        }


        static boolean match(String text, String pattern, int i, int j) {
            if (text.length() == i && pattern.length() == j) {
                return true;
            }

            if (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
                for (int k = i; k <= text.length(); ++k) {
                    count++;
                    if (match(text, pattern, k, j + 2)) {
                        return true;
                    }

                    if (k >= text.length()) {
                        return false;
                    }

                    if (pattern.charAt(j) != '.' && text.charAt(k) != pattern.charAt(j)) {
                        return false;
                    }
                }
            } else if (i < text.length() && j < pattern.length() &&
                    (pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i))) {
                return match(text, pattern, i + 1, j + 1);
            }

            return false;
        }

        public static boolean match2(String text, String pattern) {
            return match(text, pattern, 0, 0);
        }
    }

//    Regular Expression
//    Given a text and a pattern, determine if the pattern matches with the text completely or not at all by using regular expression matching. For simplicity, assume that the pattern may contain only two operators: '.' and ''. Operator '' in the pattern means that the character preceding '*' may not appear or may appear any number of times in the text. Operator '.' matches with any character in the text exactly once.
//
//            We'll cover the following
//    Try it yourself
//            Description
//    Given a text and a pattern, determine if the pattern matches with the text completely or not at all by using regular expression matching. For simplicity, assume that the pattern may contain only two operators: '.' and ''. Operator '' in the pattern means that the character preceding '*' may not appear or may appear any number of times in the text. Operator '.' matches with any character in the text exactly once.
//
//    Below is an example of a text and its matching and non-matching patterns.
//
//    Text
//            aabbbbbcdda
//    Matching Patterns
//    Non-Matching Patterns
//    a*bb*cdda
//            aabbbbbcdd
//    a*bb*.dda
//    a*b*operator*da
//    aab*lines*cd*a
//    a*b*operator*d*a*
//            .b*operator*d*a
//            aabbbbbcdda
//    Hints
//            Recursion
//    Backtracking
//            Pruning
