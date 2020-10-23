//package toptal;
//
//public class StringCompression {
//
//
//    public static void main(String[] args) {
//        String str = "wwwwaaadexxxxxxywww";
//        System.out.println(new StringCompression().solution(str, 3));
//    }
//
//
//    public int solution2(String s, int k) {
//        int cc = 1;
//        int cs = 0;
//        StringBuilder sb = new StringBuilder();
//
//        for (int j = 0; j < s.length(); j++) {
//            sb = new StringBuilder(s.substring(j, k));
//            cc = sb.charAt(0);
//            for (int i = 1; i < sb.length(); i++) {
//                if (cc == sb.charAt(i)) {
//
//                }
//
//            }
//        }
//    }
//
//    public int solution(String S, int k) {
//
//        int ss = 0;
//        int cc = 1;
//        char currentC = S.charAt(0);
//        StringBuilder cs = new StringBuilder();
//
//        for (int j = 0; j < S.length(); j++) {
//
//            String subString = cs.delete(j, Math.min(j+k,S.length())).toString();
//
//            for (int i = 1; i < subString.length(); i++) {
//                if (S.charAt(i) == currentC) {
//                    cc++;
//                    continue;
//                } else {
//                    if (cc == 1) {
//                        cs.append(currentC);
//                        currentC = subString.charAt(i);
//                    } else {
//                        cs.append(String.valueOf(cc) + S.charAt(i - 1));
//                        currentC = subString.charAt(i);
//                        cc = 1;
//
//                    }
//                }
//            }
//
//            if (cc == 1) {
//                cs.append(currentC);
//                currentC = subString.charAt(subString.length() - 1);
//            } else {
//                cs.append(String.valueOf(cc) + subString.charAt(subString.length() - 1));
//                currentC = subString.charAt(subString.length() - 1);
//                cc = 1;
//
//            }
//
//            System.out.println(cs.toString());
//
//            if (ss < cs.length()) {
//                ss = cs.length();
//            }
//        }
//
//        return ss;
//
//    }
//
//
//}
