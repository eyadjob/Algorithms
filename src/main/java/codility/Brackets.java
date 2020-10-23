package codility;

import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        String A = "{[()()]}";
        System.out.println(solution(A));

        String B = "([)()]";
        System.out.println(solution(B));

        String C = ")(";
        System.out.println(solution(C));

        String D = "{{{{";
        System.out.println(solution(C));

    }

    public static int solution(String S) {
        Stack<Character> ar = new Stack<>();
        int n = S.length();
        if (n == 0) return 1;
        for (char v : S.toCharArray()) {
            switch (v) {
                case '(':
                case '{':
                case '[':
                    ar.push(v);
                    break;
                case ')':
                    if (ar.size() == 0 || ar.pop() != '(') return 0;
                    break;
                case '}':
                    if (ar.size() == 0 || ar.pop() != '{') return 0;
                    break;
                case ']':
                    if (ar.size() == 0 || ar.pop() != '[') return 0;
                    break;
            }
        }
       return  ar.size() != 0 ?  0 :  1;
    }
}


//    A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
//
//        S is empty;
//        S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
//        S has the form "VW" where V and W are properly nested strings.
//        For example, the string "{[()()]}" is properly nested but "([)()]" is not.
//
//        Write a function:
//
//class Solution { public int solution(String S); }
//
//that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
//
//        For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [0..200,000];
//        string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
//        Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.