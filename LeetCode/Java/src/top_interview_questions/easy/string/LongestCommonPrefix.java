package top_interview_questions.easy.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] str1 = {"flower", "fkow"};
        String[] str2 = {"a"};
        String[] str3 = {"ab", "a"};
        String[] str4 = {"dog", "racecar", "car"};

        System.out.println(solution.longestCommonPrefix(str1));
        System.out.println(solution.longestCommonPrefix(str2));
        System.out.println(solution.longestCommonPrefix(str3));
        System.out.println(solution.longestCommonPrefix(str4));


    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            String result = "";
            if (strs.length == 0) {
                return result;
            } else if (strs.length == 1) {
                return strs[0];
            }

            // choose the shortest element as candidate
            result = strs[0];
            for (String str : strs) {
                if (str.length() < result.length()) {
                    result = str;
                }
            }

            /*
             * Solution v1: Brute Force
             *
             * Runtime: 0 ms @ (beats) 100%
             * Memory Usage: 36.9 MB @ (beats) 93.41%
             */
            int i = 0;
            while (i < strs.length) {
                int l = result.length();
                if (!strs[i].substring(0, l).equals(result)) {
                    if (l > 1) {
                        result = result.substring(0, l - 1);
                        continue;
                    } else {
                        return "";
                    }
                }
                i++;
            }
            return result;
        }
    }
}
