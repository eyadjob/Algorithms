package facebookposition.fbquestions;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import org.w3c.dom.ls.LSOutput;

public class ValidateIPAddress {

    public static void main(String[] args) {
        String IP = "172.16.254.1";

//        Output: "IPv4"
//        Explanation: This is a valid IPv4 address, return "IPv4".
        System.out.println(validIPAddress(IP));

        String IP2 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
//        Output: "IPv6"
//        Explanation: This is a valid IPv6 address, return "IPv6".
        System.out.println(validIPAddress(IP2));

    }

    public static String validIPAddress(String IP) {
        boolean ip4type = false;
        String ipCheckingResult = "Neither";
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == '.') {
                ip4type = true;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int sectionsNumber = 0;
        if (ip4type) {
            for (int i = 0; i < IP.length(); i++) {
                sb.append(IP.charAt(i));
                if (IP.charAt(i) == '.' || sectionsNumber == 3) {
                    sectionsNumber++;
                    if (sb.charAt(0) == '0') return "Neither";
                    int numberValue = 0;
                    try {
                        numberValue = Integer.parseInt(sectionsNumber == 4 ? sb.substring(0,sb.length()) : sb.substring(0,sb.length()-1));
                    } catch (Exception e) {
                        return "Neither";
                    }
                    if (numberValue > 255 || numberValue < 0) return "Neither";
                    sb = new StringBuilder();
                }
            }
            if (sectionsNumber != 4) return "Neither";
            ipCheckingResult = "IPv4";
        } else {
            for (int i = 0; i < IP.length(); i++) {
                if (IP.charAt(i) != ':' && !Character.isDigit(IP.charAt(i)) && !Character.isAlphabetic(IP.charAt(i))) return "Neither";
                sb.append(IP.charAt(i));
                if (IP.charAt(i) == ':' || i == IP.length()-1 ) {
                    sectionsNumber++;
                    sb = new StringBuilder(i == IP.length() -1 ? sb : sb.substring(0,sb.length()-1));
                    if (sb.length() > 4 || sb.length() < 1) return "Neither";
                    sb = new StringBuilder();
                }
            }
            if (sectionsNumber != 8) return "Neither";
            ipCheckingResult = "IPv6";
        }
        return ipCheckingResult;
    }

}

