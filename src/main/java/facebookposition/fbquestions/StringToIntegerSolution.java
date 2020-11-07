package facebookposition.fbquestions;

public class StringToIntegerSolution {
    public static void main(String[] args) {


        String s4= "-91283472332";
        System.out.println(myAtoi(s4));
        String s1 = "4193 with words";
        System.out.println(myAtoi(s1));

        String s3 =  "   -42";
        System.out.println(myAtoi(s3));

        String s2 = "words and 987";
        System.out.println(myAtoi(s2));


    }

    public static int myAtoi2(String s) {
        StringBuilder vNumber = new StringBuilder();
        for (int i =0; i < s.length(); i++) {
            if ( Character.isDigit(s.charAt(i)) || s.charAt(i)== '-' || s.charAt(i)== '+' ) {
                vNumber.append(s.charAt(i));
            } else {
                continue;
            }
        }
        return (int)Long.parseLong(vNumber.toString());
    }

    public static int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;

        if(str.length() == 0) return 0;

        while(index < str.length() && str.charAt(index) == ' ' )
            index ++;

        if ( index == str.length())
            return 0;

        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
}
