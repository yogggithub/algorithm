package top_interview_questions.easy.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "leetcode";
        String str2 = "loveleetcode";
        String str3 = "aabb";

        System.out.println(solution.firstUniqChar(str1));
        System.out.println(solution.firstUniqChar(str2));
        System.out.println(solution.firstUniqChar(str3));


    }

    static class Solution {
        public int firstUniqChar(String s) {



            /*
             * Solution v1.1: array
             *
             * Runtime: 9 ms @ (beats) 77.69%
             * Memory Usage: 46.6 MB @ (beats) 28.60%
             */

            // int[] seen = new int[26];
            // char[] chars = s.toCharArray();
            //
            // for (char c : chars) {
            //     seen[c - 97]++;
            // }
            // for (int i = 0; i < chars.length; i++) {
            //     if (seen[chars[i] - 97] == 1) {
            //         return i;
            //     }
            //
            // }


            /*
             * Solution v1.1: optimize memory usage
             *
             * Runtime: 7 ms @ (beats) 90.8%
             * Memory Usage: 45.4 MB @ (beats) 35.03%
             */

            // int[] seen = new int[26];
            //
            // for (int i = 0; i < s.length(); i++) {
            //     seen[s.charAt(i) - 'a']++;
            // }
            //
            // for (int i = 0; i < s.length(); i++) {
            //     if (seen[s.charAt(i) - 'a'] == 1) {
            //         return i;
            //     }
            // }

            /*
             * (learn from Internet)
             * Solution v2: (Fastest) compare first index and last index
             */
            // int ans = Integer.MAX_VALUE;
            //
            // for (char c = 'a'; c <= 'z'; c++) {
            //     int left = s.indexOf(c);
            //     if (left != -1 && left == s.lastIndexOf(c)) {
            //         ans = Math.min(left, ans);
            //     }
            //
            // }
            // return ans == Integer.MAX_VALUE ? -1 : ans;

            /*
             * (learn from Internet)
             * Solution v3: (Least)
             */
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i),
                        map.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }

            // default as -1 indicate no finding
            return -1;
        }
    }
}
