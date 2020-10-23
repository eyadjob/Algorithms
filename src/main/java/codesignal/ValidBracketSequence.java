package codesignal;

import java.util.Stack;

public class ValidBracketSequence {

    public static void main(String[] args) {

    }

    boolean validBracketSequence(String sequence) {
        Stack<Character> ar = new Stack<>();
        int n = sequence.length();
        if (n == 0) return true;
        for (char v : sequence.toCharArray()) {
            switch (v) {
                case '(':
                case '{':
                case '[':
                    ar.push(v);
                    break;
                case ')':
                    if (ar.size() == 0 || ar.pop() != '(') return false;
                    break;
                case '}':
                    if (ar.size() == 0 || ar.pop() != '{') return false;
                    break;
                case ']':
                    if (ar.size() == 0 || ar.pop() != '[') return false;
                    break;
            }
        }
        return ar.size() == 0;

    }

}

