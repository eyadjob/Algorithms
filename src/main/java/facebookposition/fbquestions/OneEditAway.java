package facebookposition.fbquestions;

public class OneEditAway {

    public static void main(String[] args) {

        System.out.println(oneEditApart("cat", "dog"));
        System.out.println(oneEditApart("cat", "cats"));
        System.out.println(oneEditApart("cat", "cut"));
        System.out.println(oneEditApart("cat", "cast"));
        System.out.println(oneEditApart("cat", "at"));
        System.out.println(oneEditApart("cat", "act"));

    }

    public static boolean oneEditApart(String a, String b) {
        StringBuilder a_sb = new StringBuilder(a);
        StringBuilder b_sb = new StringBuilder(b);
        if (b_sb.length() < a_sb.length()) {
            int re = 0;
            for (int i = 0; i < b_sb.length(); i++) {
                if (b_sb.charAt(i) != a_sb.charAt(i)) {
                    a_sb.deleteCharAt(i);
                    re = 1;
                    break;
                }
            }
            if (re == 0) a_sb.deleteCharAt(b_sb.length() - 1);
            return a_sb.toString().equals(b_sb.toString());
        }
        if (a_sb.length() < b_sb.length()) {
            int re = 0;
            for (int i = 0; i < a_sb.length(); i++) {
                if (a_sb.charAt(i) != b_sb.charAt(i)) {
                    b_sb.deleteCharAt(i);
                    re = 1;
                    break;
                }
            }
            if (re == 0) b_sb.deleteCharAt(b_sb.length() - 1);
            return a_sb.toString().equals(b_sb.toString()) ;
        }
            // we are at replacing possibility
            int count = 0;
        for (int i = 0; i < b_sb.length(); i++) {
            if (a_sb.charAt(i) != b_sb.charAt(i))
                count++;
        }
        return count < 2;
    }
}
