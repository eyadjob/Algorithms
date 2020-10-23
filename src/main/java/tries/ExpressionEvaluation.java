package tries;

import java.util.Stack;

public class ExpressionEvaluation {


    public static Stack<Character> operator = new Stack<>();
    public static Stack<Double> d = new Stack<>();
        static int flag = 0;

    public static void test(String s) {

        try {
            for (int i = 0; i < s.length(); i++) {
                char cha = s.charAt(i);

                if (cha == ' ') {
                } else if (cha == '+') {
                    operator.push('+');
                    flag++;
                } else if (cha == '/') {
                    operator.push('/');
                    flag++;
                } else if (cha == '*') {
                    operator.push('*');
                    flag++;
                } else if (flag == 3 ) {
                    char op = operator.pop();
                    double v = d.pop();

                    if (op == '+') {
                        v = d.pop() + v;
                        flag=0;

                    } else if (op == '-') {
                        v = d.pop() - v;
                        flag=0;
                    } else if (op == '*') {
                        v = d.pop() * v;
                        flag=0;
                    } else if (op == '/') {
                        v = d.pop() / v;
                        flag=0;
                    }
                    d.push(v);

                } else {
                    d.push(Double.parseDouble(String.valueOf(cha)));
                flag++;}


            }
        } catch (Exception e) { e.getMessage();}
        System.out.println( d.pop());
        operator = new Stack<>();
        Stack<Double> d = new Stack<>();

    }

    public static void main(String[] args) {
        test("4 +  5 ");
        test("3");
//        test("          4   ");
//        test("  3    +  2.45    /8");
    }


}
