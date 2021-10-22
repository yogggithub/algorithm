package top_interview_questions.easy.string;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "aacc";
        String t2 = "ccac";

        System.out.println(solution.isAnagram(s1, t1));
        System.out.println(solution.isAnagram(s2, t2));


    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            /*
             * Solution v1: char array
             *
             * Runtime: 12 ms @ (beats) 24.44%
             * Memory Usage: 40.5 MB @ (beats) 35.67%
             */
            // if (s.length() > 0 && t.length() == s.length()) {
            //     int[] chars = new int[26];
            //     for (char c : s.toCharArray()) {
            //         chars[c - 'a']++;
            //     }
            //
            //     for (int i = 0; i < t.length(); i++) {
            //         int index = t.charAt(i) - 'a';
            //         if (chars[index] <= 0) {
            //             break;
            //         } else {
            //             chars[index]--;
            //         }
            //         if (i == t.length() - 1) {
            //             return true;
            //         }
            //     }
            // }

            /*
             * Solution v2.1: HashMap
             *
             * Runtime: 19 ms @ (beats) 14.53%
             * Memory Usage: 43.8 MB @ (beats) 0%
             */
            // if (s.length() > 0 && t.length() == s.length()) {
            //     Map<Character, Integer> map = new HashMap<>();
            //     for (char c : s.toCharArray()) {
            //         map.put(c, map.getOrDefault(c, 0) + 1);
            //     }
            //
            //     for (int i = 0; i < t.length(); i++) {
            //         if (map.get(t.charAt(i)) == null || map.get(t.charAt(i)) <= 0) {
            //             break;
            //         } else {
            //             map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            //         }
            //         if (i == t.length() - 1) {
            //             return true;
            //         }
            //     }
            // }



            /*
             * Solution v2.2: ArrayList
             *
             * Runtime: 407 ms @ (beats) 0%
             * Memory Usage: 42.6 MB @ (beats) 11.82%
             */
            // if (s.length() > 0 && t.length() == s.length()) {
            //     ArrayList<Character> chars = new ArrayList<>();
            //
            //     for (char c : s.toCharArray()) {
            //         chars.add(c);
            //     }
            //
            //     for (char c : t.toCharArray()) {
            //         int i = chars.indexOf(c);
            //         if (i == -1) {
            //             break;
            //         } else {
            //             chars.remove(i);
            //             if (chars.size() == 0) {
            //                 return true;
            //             }
            //         }
            //     }
            // }

            /*
             * Solution v3: sorted then compare
             *
             * Runtime: 7 ms @ (beats) 43.11%
             * Memory Usage: 42.1 MB @ (beats) 13.12%
             */
            char[] sVal = s.toCharArray();
            Arrays.sort(sVal);
            char[] tVal = t.toCharArray();
            Arrays.sort(tVal);

            s = String.valueOf(sVal);
            t = String.valueOf(tVal);
            if (s.equals(t)) {
                return true;
            }

            return false;
        }
    }
}
