package problems.p0058_LengthOfLastWord;

public class P0058 {
    public int lengthOfLastWord(String s) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 38.4 MB @ (beats) 33.03%
         */
        // if (s.length() == 1) {
        //     if (!s.equals(" ")) {
        //         return s.length();
        //     } else {
        //         return 0;
        //     }
        // }
        // s = s.trim();
        // int ans = 0, i = s.length() - 1;
        // while (i >= 0) {
        //     if (s.charAt(i) == ' ') {
        //         return ans;
        //     }
        //     ans++;
        //     i--;
        // }
        // return ans;

        /*
         * Solution v2: Use String class
         *
         * Runtime: ms @ (beats) %
         * Memory Usage: MB @ (beats) %
         */
        // s = s.trim();
        // return s.length() - s.lastIndexOf(" ") - 1;

        /*
         * (learn from Internet)
         * Solution v3: Convert to string array
         */
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }
}
