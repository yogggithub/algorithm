package top_interview_questions.medium.arrays_strings;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return 1;
            } else {
                return 2;
            }
        }


        /*
         * Solution v1.1: Brute Force with Map
         *
         * Runtime: 142 ms @ (beats) 11.60%
         * Memory Usage: 48.4 MB @ (beats) 9.54%
         */
        // Map<Character, Integer> temp = new HashMap<>();
        //
        // int length = 0;
        // String sub = "";
        // int cur = 0;
        // while (cur < s.length()) {
        //     char c = s.charAt(cur);
        //     if (temp.containsKey(c)) {
        //         length = Math.max(length, temp.size());
        //         sub = s.substring(temp.get(c) + 1);
        //         break;
        //     }
        //     temp.put(c, cur);
        //     cur++;
        // }
        // length = Math.max(length, temp.size());
        //
        // return Math.max(length, lengthOfLongestSubstring(sub));

        /*
         * (learn from Internet)
         * Solution v1.2: Optimized by processing in a single loop
         */
        // int left = 0;
        // int right = 0;
        // int max = 0;
        // int flag = 0;
        // Map<Character, Integer> mp = new HashMap<>();
        // while (right < s.length()) {
        //     if (mp.containsKey(s.charAt(right))) {
        //         if (flag == 0) {
        //             flag = 1;
        //             max = right;
        //         }
        //         flag = 1;
        //         int index = mp.get(s.charAt(right));
        //         int sum = right - left;
        //         if (index >= left) {
        //             left = index + 1;
        //         }
        //
        //         mp.replace(s.charAt(right), index, right);
        //         max = Math.max(sum, max);
        //     } else {
        //         mp.put(s.charAt(right), right);
        //     }
        //     right++;
        // }
        // if (flag == 0) {
        //     return s.length();
        // }
        // int b = right - left;
        // return Math.max(max, b);

        /*
         * (learn from Internet)
         * Solution v1.3: Optimized by simpling the procedure
         * use just one marker to store the beginning position of substring
         */
        // HashMap<Character, Integer> map = new HashMap<>();
        // int max = 0;
        // for (int i = 0, j = 0; i < s.length(); i++) {
        //     if (map.containsKey(s.charAt(i))) {
        //         j = Math.max(j, map.get(s.charAt(i)) + 1);
        //     }
        //     map.put(s.charAt(i), i);
        //     max = Math.max(max, i - j + 1);
        // }
        // return max;

        /*
         * (learn from Internet)
         * Solution v1.4: Optimized by adding a condition
         */
        // Map<Character, Integer> used = new HashMap<>();
        // int start = 0, maxLength = 0;
        //
        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     int lastPos = used.getOrDefault(ch, 0);
        //
        //     if (used.containsKey(ch) && start <= lastPos) {
        //         start = lastPos + 1;
        //     } else {
        //         maxLength = Math.max(maxLength, i - start + 1);
        //     }
        //     used.put(ch, i);
        // }
        //
        // return maxLength;


        /*
         * (learn from Internet)
         * Solution v2.1: Integer Array to indicator char
         */
        // Integer[] chars = new Integer[128];
        // int left = 0, right = 0, max = 0;
        // while (right < s.length()) {
        //     char r = s.charAt(right);
        //     Integer index = chars[r];
        //     if (index != null && index >= left && index < right) {
        //         left = index + 1;
        //     }
        //     max = Math.max(max, right - left + 1);
        //     chars[r] = right;
        //     right++;
        // }
        // return max;

        /*
         * (learn from Internet)
         * Solution v2.1: Array Integer to indicator char
         */
        char[] ch = s.toCharArray();
        int start = 0;
        int left = 0, right = 0;
        int max = 0;

        while (right < ch.length) {
            left = start;
            while (left < right) {
                if (ch[left] == ch[right]) {
                    max = Math.max(max, right - start);
                    start = left + 1;
                    break;
                }
                left++;
            }
            right++;
        }
        return Math.max(max, ch.length - start);
    }
}
