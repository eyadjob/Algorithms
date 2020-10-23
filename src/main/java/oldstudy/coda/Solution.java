package oldstudy.coda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class Solution {
    public String[] solution(int N, int K) {
        if (N == 0) {
            return new String[] {""};
        }

        ArrayList<String> result = new ArrayList<String>();
        for (String p : solution(N - 1, K - 1)) {
            for (char l : new char[] {'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }

        int prefSize = Math.min(result.size(), K  > 0 ? K  : result.size() );
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] re= solution.solution(4,100000);
        System.out.println(re.length);
            for (String s : re) {
                System.out.println(s);
            }

        Set<String> test = new HashSet<>(Arrays.asList(re));

        System.out.println(test.size());
    }

}
