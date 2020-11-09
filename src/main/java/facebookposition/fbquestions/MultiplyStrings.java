package facebookposition.fbquestions;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {


    public static void main(String[] args) {
        String num1 = "2"; String  num2 = "3";
        System.out.println(multiply(num1, num2));


        String num3 = "123", num4 = "456";
        System.out.println(multiply3(num3, num4));


    }
    public static String multiply2(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }



    public static String multiply(String num1, String num2) {
        double temp =0, total =0, carry=0;
        List<StringBuilder> sbl =  new ArrayList<>();
        for( int i =num1.length()-1; i >= 0; i-- ) {
            for( int k =num2.length()-1; k >= 0 ; k-- ) {
                temp = (Math.pow(10,k) * Character.getNumericValue(num2.charAt(k))) * (Math.pow(10,i) * Character.getNumericValue(num1.charAt(i)))  + carry;
                if ( temp > 10 ) {
                    carry = temp - 10;
                    sbl.add(new StringBuilder(String.valueOf(temp - 10)));
                } else {
                    sbl.add(new StringBuilder(String.valueOf(temp)));
                }
            }
        }
        return "  dd";
    }

    public static String multiply3(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

