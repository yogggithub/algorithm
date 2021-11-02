package top_interview_questions.medium.arrays_strings;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.charAt(0) + "";
            }
        }

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 6 ms @ (beats) 99.23%
         * Memory Usage: 38.8 MB @ (beats) 92.60%
         */
        // idea: from Hint #2
        // transversal the given string
        // for every character, try to find palindrome by
        // append left and right character besides to it
        // pay attention to odd / even situation

        // int length = s.length(), begin = 0, max = 0;
        // for (int i = 0; i < length; ) {
        //     // there is no need to continue
        //     // when the number of remaining characters is less
        //     // than half of the currently known longest
        //     if (length - i <= max / 2) {
        //         break;
        //     }
        //
        //     // two pointers
        //     int left = i, right = i;
        //     // special judgement for even
        //     // if the right side char is same as current
        //     // move right pointer one step forward
        //     while (right < length - 1 && s.charAt(right) == s.charAt(right + 1)) {
        //         right++;
        //     }
        //     // move index, and skip duplicate character
        //     i = right + 1;
        //
        //     // if left equals right character
        //     // move two pointers forward
        //     while (right < length - 1 && left > 0 &&
        //            s.charAt(right + 1) == s.charAt(left - 1)) {
        //         right++;
        //         left--;
        //     }
        //
        //     if (max < right - left + 1) {
        //         max = right - left + 1;
        //         begin = left;
        //     }
        // }
        // return s.substring(begin, begin + max);

        /*
         * (learn from Internet)
         * Solution v2: dynamic
         */
        // idea:
        // implement a two dimensional boolean array
        // isPalindrome[i][j] represent whether substring(i,j) is palindrome or not
        // when i = j + 1, means that they are adjacent,
        // need to determine whether s[i] is equal to s[j]
        // otherwise, when i > j + 1, means that they are not adjacent,
        // have to check whether dp[i + 1][j - 1] is true or not
        // int length = s.length(), left = 0, maxLen = 0;
        // boolean[][] isPalindrome = new boolean[length][length];
        // for (int i = 0; i < length; i++) {
        //     isPalindrome[i][i] = true;
        //     for (int j = 0; j < i; j++) {
        //         isPalindrome[j][i] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1]));
        //         if (isPalindrome[j][i] && maxLen < i - j + 1) {
        //             maxLen = i - j + 1;
        //             left = j;
        //         }
        //     }
        // }
        // return s.substring(left, left + maxLen);

        /*
         * (learn from Internet)
         * Solution v3: Manacher's Algorithm
         */
        String result = "";
        // preprocessing: eliminate odd / even difference
        // abc -> #a#b#c#
        // abcd -> #a#b#c#d#
        String str = "#";
        for (int i = 0; i < s.length(); ++i) {
            str += s.charAt(i);
            str += '#';
        }
        int len = str.length();
        int[] p = new int[str.length()];
        //stores the center of the longest palindromic substring until now
        int c = 0;
        //stores the right boundary of the longest palindromic substring until now
        int r = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            //get mirror index of i
            int mirror = (2 * c) - i;

            // see if the mirror of i is expanding beyond
            // the left boundary of current longest palindrome at center c
            // if it is, then take r - i as P[i]
            // else take P[mirror] as P[i]
            if (i < r) {
                p[i] = Math.min(r - i, p[mirror]);
            }

            // expand at i
            int a = i + (1 + p[i]);
            int b = i - (1 + p[i]);
            while (a < len && b >= 0 && str.charAt(a) == str.charAt(b)) {
                p[i]++;
                a++;
                b--;
            }

            // check if the expanded palindrome at i is expanding
            // beyond the right boundary of current longest palindrome at center c
            // if it is, the new center is i
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
                //update maxlen & longest substring
                if (p[i] > maxLen) {
                    maxLen = p[i];
                    result = s.substring((i - maxLen) / 2, r / 2);
                }
            }
        }
        return result;
    }
}
