package solutions.p0014_LongestCommonPrefix;

public class P0014 {
    public String longestCommonPrefix(String[] strs) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 1 ms @ (beats) 75.20%
         * Memory Usage: 40.3 MB @ (beats) 77.5%
         */
        // if (strs.length == 0) {
        //     return "";
        // }
        //
        // String candidate = strs[0];
        // for (String s : strs) {
        //     if (s.length() < candidate.length()) {
        //         candidate = s;
        //     }
        // }
        //
        // for (int i = 0; i < candidate.length(); i++) {
        //     for (String s : strs) {
        //         if (s.charAt(i) != candidate.charAt(i)) {
        //             return candidate.substring(0, i - 1);
        //         }
        //     }
        // }
        // return candidate;

        /*
         * Solution v2: Built-in search
         *
         * Runtime:  ms @ (beats) %
         * Memory Usage:  MB @ (beats) %
         */
        if (strs == null || strs.length == 0) {
            return "";
        }

        String ans = strs[0];

        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(ans) != 0) {
                ans = ans.substring(0, ans.length() - 1);
            }
        }
        return ans;
    }
}
