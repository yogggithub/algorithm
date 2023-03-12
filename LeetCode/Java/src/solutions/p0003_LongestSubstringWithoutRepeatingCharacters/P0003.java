package solutions.p0003_LongestSubstringWithoutRepeatingCharacters;

public class P0003 {
    public static void main(String[] args) {
        P0003 solution = new P0003();

        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));   // 3

        s = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s));   // 1

        s = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s));   // 3

        s = " ";
        System.out.println(solution.lengthOfLongestSubstring(s));   // 1

        s = "au";
        System.out.println(solution.lengthOfLongestSubstring(s));   // 2

        s = "dvdf";
        System.out.println(solution.lengthOfLongestSubstring(s));   // 3

    }

    public int lengthOfLongestSubstring(String s) {

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 10 ms @ (beats) 33.21%
         * Memory Usage: 43.2 MB @ (beats) 17.67%
         */

        // if (s.length() == 1) {
        //     return 1;
        // } else if (s.length() == 0) {
        //     return 0;
        // }
        //
        // int ans = 0;
        // String temp = "";
        //
        // for (int i = 0; i < s.length(); i++) {
        //     String curr = String.valueOf(s.charAt(i));
        //     // System.out.println(curr);
        //     if (temp.contains(curr)) {
        //         ans = Math.max(ans, temp.length());
        //         temp = temp.substring(temp.indexOf(curr) + 1) + curr;
        //     } else {
        //         temp += curr;
        //     }
        // }
        //
        // return Math.max(ans, temp.length());

        /*
         * Solution v2: Pointers
         *
         * Runtime: 6 ms @ (beats) 76.17%
         * Memory Usage: 43.4 MB @ (beats) 15.42%
         */

        // if (s.length() == 1) {
        //     return 1;
        // } else if (s.length() == 0) {
        //     return 0;
        // }
        //
        // int ans = 0;
        // int start = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     String curr = String.valueOf(s.charAt(i));
        //     if (s.substring(start, i).contains(curr)) {
        //         ans = Math.max(ans, i - start);
        //         start = s.indexOf(curr, start) + 1;
        //         // System.out.println(sub + " @ " + curr + " -> " + start);
        //     }
        // }
        // return Math.max(ans, s.length() - start);

        /*
         * Solution v3: Array to store last position
         *
         * Runtime: 6 ms @ (beats) 76.17%
         * Memory Usage: 43.4 MB @ (beats) 15.42%
         */

        int ans = 0;
        int[] pos = new int[96];
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 32;
            start = Math.max(pos[curr], start);
            ans = Math.max(ans, i - start + 1);
            // has to give a bit behind
            // coz default val 0 makes a bit hard to treat
            // when compare start pointer
            pos[curr] = i + 1;
        }

        return ans;
    }
}
