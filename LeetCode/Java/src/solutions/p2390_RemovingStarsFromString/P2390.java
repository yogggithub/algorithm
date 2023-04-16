package solutions.p2390_RemovingStarsFromString;

public class P2390 {
    public String removeStars(String s) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 159 ms @ (beats) 70.4%
         * Memory Usage: 44.7 MB @ (beats) 46.30%
         */
        // Stack<Character> stack = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (c == '*') {
        //         stack.pop();
        //         continue;
        //     }
        //     stack.push(c);
        // }
        // StringBuilder ans = new StringBuilder("");
        // for (Character c : stack) {
        //     ans.append(c);
        // }
        // return ans.toString();

        /*
         * Solution v1.1: Brute Force
         *
         * Runtime: 42 ms @ (beats) 84.2%
         * Memory Usage: 43.3 MB @ (beats) 87.43%
         */
        // StringBuilder ans = new StringBuilder("");
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (c == '*') {
        //         int idx = ans.length() - 1;
        //         ans.deleteCharAt(idx);
        //         continue;
        //     }
        //     ans.append(c);
        // }
        // return ans.toString();

        /*
         * Solution v2: Pointer & Backward
         *
         * Runtime: 12 ms @ (beats) 99.88%
         * Memory Usage: 43.2 MB @ (beats) 94.12%
         */
        int l = s.length();
        char[] chars = new char[l];
        int idx = l;
        int count = 0;

        for (int i = l - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    chars[--idx] = c;
                }
            }
        }
        return String.valueOf(chars, idx, l - idx);
    }
}
