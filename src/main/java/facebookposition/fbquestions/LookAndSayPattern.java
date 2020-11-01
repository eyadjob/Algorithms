package facebookposition.fbquestions;

public class LookAndSayPattern {

//    Implement a function that outputs the Look and Say sequence:
//            1
//            11
//            21
//            1211
//            111221
//            312211
//            13112221
//            1113213211
//            31131211131221
//            13211311123113112211


    public static void main(String[] args) {
        lookAndSay2("1");
    }

    public static void lookAndSay2(String n) {
        if (n.isEmpty()) return;
        StringBuilder sb = new StringBuilder(n);
        System.out.println(sb.toString());
        int index = 0;
        for (int i = 0; i < 50; i++) {
            StringBuilder re = new StringBuilder();
            for (int k = 0; k < sb.length(); k++) {
                if (k == 0) re.append(1).append(sb.charAt(k));
                else if (sb.charAt(k) == sb.charAt(k - 1))
                    re.replace(index, index + 1, String.valueOf(Integer.parseInt(String.valueOf(re.charAt(index))) + 1));
                else {
                    re.append(1).append(sb.charAt(k));
                    index = re.length() - 2;
                }
            }
            System.out.println(re.toString());
            index = 0;
            sb = new StringBuilder(re);
        }
    }
}
