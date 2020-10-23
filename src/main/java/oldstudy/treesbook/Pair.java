package oldstudy.treesbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

class Pair<X, Y> {
    public X first;
    public Y second;
    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }
}



class IntPair extends Pair<Integer, Integer> {
    public IntPair(int first, int second) {
        super(first, second);
    }
}



interface token {
    boolean is_operator();
};



class token_operator implements token {
    char m_value;
    public token_operator() {m_value = 0;}
    public token_operator(char d) {m_value = d;}
    public void set_value(char d) {m_value = d;}
    char get_value() {return m_value;}
    public boolean is_operator() { return true;}
}




class token_operand implements token {
    double m_value;
    public token_operand(){ m_value = 0;}
    public token_operand(double d) { m_value = d; }
    void set_value(double d) {m_value = d;}
    double get_value() {return m_value;}
    public boolean is_operator() { return false;}
}




class expression_evaluation1 {
    static boolean is_operator(char temp) {
        return temp == '+' ||
                temp == '-' ||
                temp == '*' ||
                temp == '/';
    }

    // returns true if op1 has higher/equal precedence
    // compared to op2
    static boolean preced(char op1, char op2) {
        if (op1 == '*' || op1 == '/') {
            return true;
        }

        if (op1 == '+' || op1 == '-')  {
            if (op2 == '+' || op2 == '-') {
                return true;
            }
        }

        return false;
    }



    static boolean is_digit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static Pair<Double, Integer> str_to_double(String s, int i) {
        int len = s.length();
        if (i >= len){
            return null;
        }

        StringBuilder temp = new StringBuilder();
        while(i < len && (s.charAt(i) == ' ' || s.charAt(i) == '\t')) {
            ++i;
        }

        if (i >= len){
            return null;
        }

        if (s.charAt(i) == '-') {
            temp.append('-');
            ++i;
        }

        for (;i < len; ++i) {
            char ch = s.charAt(i);
            if (ch != '.' && !is_digit(ch)) {
                break;
            }

            temp.append(ch);
        }

        return new Pair<Double, Integer>(Double.parseDouble(temp.toString()), i);

    }

    static List<token> convert_to_postfix(String expr) {
        List<token> post_fix = new ArrayList<token>();

        Stack<Character> operators = new Stack<Character>();
        int len = expr.length();
        for (int i = 0; i < len;) {
            char ch = expr.charAt(i);
            if (ch == ' ' || ch == '\t') {
                ++i;
                continue;
            }

            if (is_operator(ch)) {
                while (!operators.empty() && preced(operators.peek(), ch)) {
                    post_fix.add(new token_operator(operators.peek()));
                    operators.pop();
                }
                operators.push(ch);
                ++i;
            } else {
                Pair<Double, Integer> p = str_to_double(expr, i);
                i = p.second;
                post_fix.add(new token_operand(p.first));
            }
        }

        while(!operators.empty()) {
            post_fix.add(new token_operator(operators.peek()));
            operators.pop();
        }

        return post_fix;
    }

    public static double evaluate(List<token> post_fix) {
        Stack<Double> operands = new Stack<Double>();
        for (token x : post_fix) {
            if (x.is_operator()) {
                double val2 = operands.peek();
                operands.pop();
                double val1 = operands.peek();
                operands.pop();

                char op = ((token_operator)x).get_value();
                if (op == '+') {
                    operands.push(val1 + val2);
                } else if (op == '-') {
                    operands.push(val1 - val2);
                } else if (op == '*') {
                    operands.push(val1 * val2);
                } else if (op == '/') {
                    operands.push(val1 / val2);
                }

            } else {
                double val = ((token_operand)x).get_value();
                operands.push(val);
            }
        }

        if (operands.empty()) {
            return 0;
        }

        return operands.peek();
    }

    static double evaluate(String expr) {
        return evaluate(convert_to_postfix(expr));
    }
}




class expression_evaluation {

    static String generate_expression(int nOperators) {
        char[] ops = new char[]{'+', '/', '*', '-'};
        StringBuilder expression = new StringBuilder();

        Random rnd = new Random();
        double d = rnd.nextInt(100);

        expression.append(d);
        for (int i = 0; i < nOperators; ++i) {
            char c = ops[rnd.nextInt(4)];
            d = rnd.nextInt(100);
            if (c == '/' && d == 0) d = d + 1;
            expression.append(c);
            expression.append(d);
        }

        return expression.toString();
    }

    public static void test(String expression) {
        double result = expression_evaluation1.evaluate(expression);
        System.out.println(result);
    }
    public static void main(String[] args) {
        test("4+5");
        test("3");
        test("          4   ");
        test("  3    +  2.45    /8");
    }
}