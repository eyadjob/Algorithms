

public class FindPalindromes {


    public static int find_all_palindrome_substrings(String s) {
        int count = 0;
        StringBuilder revS = new StringBuilder();

        outLoop:
        for (int i = 0; i < s.length(); i++) {
            innerLoop:
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                for (int k = sub.length() - 1; k >= 0; k--) {
                    revS.append(sub.charAt(k));
                }

                if (sub.equals(revS.toString())) {
                    if (sub.length() > 1) {
                        count++;
                    }
                }
                revS = new StringBuilder();


            }
        }

        return count;
    }


    public static void main(String[] args) {
        String str = "aabbbaa";
        int count = find_all_palindrome_substrings(str);
        System.out.println("count :" + count);
        System.out.println(count == 7);
    }


}
