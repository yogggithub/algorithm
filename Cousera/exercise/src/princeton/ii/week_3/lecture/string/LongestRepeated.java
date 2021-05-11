package princeton.ii.week_3.lecture.string;

import java.util.Arrays;

public class LongestRepeated {
    public String lrs(String s) {
        int N = s.length();
        String[] suffixes = new String[N];

        // create suffixes (linear time and space)
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i, N);
        }

        // sort suffixes
        Arrays.sort(suffixes);
        String lrs = "";

        // find LCP between adjacent suffixes in sorted order
        for (int i = 0; i < N - 1; i++) {
            int len = lcp(suffixes[i], suffixes[i + 1]);
            if (len > lrs.length()) {
                lrs = suffixes[i].substring(0, len);
            }
        }
        return lrs;
    }

    // Longest common prefix
    public static int lcp(String s, String t) {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return i;
            }
        }
        return N;
    }
}
