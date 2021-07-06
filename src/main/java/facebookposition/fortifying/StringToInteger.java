package facebookposition.fortifying;

public class StringToInteger {
    public static void main(String[] args) {

        String s12 = "42";
        System.out.println(myAtoi4(s12));

        String s4 = "-91283472332";
        System.out.println(myAtoi4(s4));


        String s11 = "-5-";
        System.out.println(myAtoi4(s11));


        String s10 = "   +0 123";
        System.out.println(myAtoi4(s10));


        String s9 = "  -0012a42";
        System.out.println(myAtoi4(s9));

        String s8 = " ";
        System.out.println(myAtoi4(s8));

        String s = "   -42";
        System.out.println(myAtoi4(s));

        String s2 = "4193 with words";
        System.out.println(myAtoi4(s2));

        String s3 = "words and 987";
        System.out.println(myAtoi4(s3));


        String s5 = "+-12";
        System.out.println(myAtoi4(s5));

        String s6 = "+1";
        System.out.println(myAtoi4(s6));

        String s7 = "00000-42a1234";
        System.out.println(myAtoi4(s7));
    }

    public static int myAtoi4(String s) {
        int index=0,sign =1, total=0;
        if(s.length() == 0 ) return 0;

        //remove space
        while ( index < s.length()-1 && s.charAt(index) == ' ' )
            index++;

            //handling sign
            if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
            }

            //converting numbers and avoiding overflow
            while ( index < s.length()) {
                int digit = s.charAt(index) - '0';
                if ( digit < 0 || digit > 9) break;

                //check is total will be overflow after 10 times and add digit
                if ( Integer.MAX_VALUE/10 < total ||  Integer.MAX_VALUE/10== total &&  Integer.MAX_VALUE%10 < digit) {
                        return sign == 1 ?  Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                total = 10 * total +  digit;
                index++;

            }
        return total * sign;
    }

    public static int myAtoi(String s) {

        if (s.length() == 0) return 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = false, whiteSpaceFoundFinished = false, numberFound = false, signWasFound = false;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                if (whiteSpaceFoundFinished)
                    break;
                else
                    continue;
            }
            whiteSpaceFoundFinished = true;
            if ((numberFound || signWasFound) && (c == '-' || c == '+')) break;

            if (c == '-' || c == '+') {
                sb.append(c);
                signWasFound = true;
            }

            if (!Character.isDigit(c)) {
                if (!numberFound)
                    continue;
                else break;
            }
            if (Character.isDigit(c)) {
                numberFound = true;
                sb.append(c);
                continue;
            }
        }
        int result = 0;
        try {
            result = Integer.parseInt
                    (sb.toString());
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    public static int myAtoi3(String s) {
        if (s.length() == 0) return 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = false, whiteSpaceFoundFinished = false, numberFound = false, signWasFound = false;
        for (char c : s.toCharArray()) {
            if (!whiteSpaceFoundFinished && Character.isWhitespace(c)) {
                continue;
            }
            whiteSpaceFoundFinished = true;
            if (!Character.isDigit(c) && !flag && c != '-' && c != '+') return 0;
            if (Character.isDigit(c) || c == '-' || c == '+') {
                if (numberFound && signWasFound && (c == '-' || c == '+')) break;
                if (c == '-' || c == '+') signWasFound = true;
                if (Character.isDigit(c)) numberFound = true;
                sb.append(c);
                flag = true;
                continue;
            }
            if (!Character.isDigit(c) && whiteSpaceFoundFinished) {
                if (!numberFound) return 0;
                if (sb.length() == 1 && (sb.charAt(0) == '-' || sb.charAt(0) == '+')) return 0;
                long re = 0l;
                try {
                    re = Long.parseLong(sb.toString());
                } catch (Exception e) {
                    return 2147483647;
                }
                return re < 0 ? (int) Math.max(re, Integer.MIN_VALUE) : (int) Math.min(re, Integer.MAX_VALUE);
            }

        }
        if (sb.length() == 1 && (sb.charAt(0) == '-' || sb.charAt(0) == '+')) return 0;
        if (!numberFound) return 0;
        long re = 0l;
        try {
            re = Long.parseLong(sb.toString());
        } catch (Exception e) {
            return 2147483647;
        }
        return re < 0 ? (int) Math.max(re, Integer.MIN_VALUE) : (int) Math.min(re, Integer.MAX_VALUE);
    }
}


//    Implement atoi which converts a string to an integer.
//
//        The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//
//        The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//
//        If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//
//        If no valid conversion could be performed, a zero value is returned.
//
//        Note:
//
//        Only the space character ' ' is considered a whitespace character.
//        Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, 231 − 1 or −231 is returned.
//
//
//        Example 1:
//
//        Input: str = "42"
//        Output: 42
//        Example 2:
//
//        Input: str = "   -42"
//        Output: -42
//        Explanation: The first non-whitespace character is '-', which is the minus sign. Then take as many numerical digits as possible, which gets 42.
//        Example 3:
//
//        Input: str = "4193 with words"
//        Output: 4193
//        Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
//        Example 4:
//
//        Input: str = "words and 987"
//        Output: 0
//        Explanation: The first non-whitespace character is 'w', which is not a numerical digit or a +/- sign. Therefore no valid conversion could be performed