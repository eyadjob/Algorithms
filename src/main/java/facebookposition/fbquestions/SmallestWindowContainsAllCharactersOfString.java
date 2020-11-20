package facebookposition.fbquestions;

import java.util.Arrays;

public class SmallestWindowContainsAllCharactersOfString {

    public static void main(String[] args) {
        String s = "aabcbcdbca";
        System.out.println(findSubstring(s));

    }

    public static String findSubstring(String st) {
        final int MAX_CHARS = 256;

        int n = st.length(), distCount = 0, min_len = Integer.MAX_VALUE;
        boolean[] visited = new boolean[MAX_CHARS];
        Arrays.fill(visited, false);


        for (int i = 0; i < st.length(); i++) {
            if (visited[st.charAt(i)] == false) {
                visited[st.charAt(i)] = true;
                distCount++;
            }
        }

        int start = 0, startIndex = -1;
        int count = 0;
        int[] currCount = new int[MAX_CHARS];
        for (int j = 0; j < n; j++) {
            currCount[st.charAt(j)]++;

            if (currCount[st.charAt(j)] == 1)
                count++;

            if (count == distCount) {
                while (currCount[st.charAt(j)] > 1) {
                    if (currCount[st.charAt(j)] > 1)
                        currCount[st.charAt(j)]--;
                    start++;


                }
                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    startIndex = start;
                }
            }
        }
        return st.substring(startIndex,startIndex+min_len);
    }
}
