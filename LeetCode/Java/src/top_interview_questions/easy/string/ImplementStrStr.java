package top_interview_questions.easy.string;

public class ImplementStrStr {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack1 = "hello";
        String needle1 = "ll";
        String haystack2 = "aaaaa";
        String needle2 = "bba";
        String haystack3 = "";
        String needle3 = "";
        String haystack4 = "abc";
        String needle4 = "c";

        System.out.println(solution.strStr(haystack1, needle1));
        System.out.println(solution.strStr(haystack2, needle2));
        System.out.println(solution.strStr(haystack3, needle3));
        System.out.println(solution.strStr(haystack4, needle4));


    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            /*
             * This problem is to create own indexOf() function
             * And when needle is empty, just return 0
             */

            // common part
            int hLength = haystack.length();
            int nLength = needle.length();

            // special cases
            if (nLength == 0) {
                return 0;
            } else if (hLength == 0 || haystack.length() < nLength) {
                return -1;
            } else if (hLength == nLength) {
                if (haystack.equals(needle)) {
                    return 0;
                } else {
                    return -1;
                }
            }
            /*
             * Solution v1.1: Sub String
             *
             * Runtime: 307 ms @ (beats) 77.73%
             * Memory Usage: 39.4 MB @ (beats) 48.55%
             */
            int i = 0;
            while (i <= hLength - nLength) {
                if (haystack.substring(i, i + nLength).equals(needle)) {
                    return i;
                }
                i++;
            }

            return -1;  // assume no finding by default

            /*
             * Solution v1.2: Sub-String with Set
             *
             * Runtime: 333 ms @ (beats) 65.70%
             * Memory Usage: 39.6 MB @ (beats) 45.10%
             */
            // int i = 0;
            // Set<String> set = new HashSet<>();
            // set.add(needle);
            // while (i <= hLength - nLength) {
            //     if (set.contains(haystack.substring(i, i + nLength))) {
            //         return i;
            //     }
            //     i++;
            // }

            /*
             * Solution v2: Two pointers
             *
             * Runtime: 1445 ms @ (beats) 22.65%
             * Memory Usage: 38.9 MB @ (beats) 84.45%
             */
            // int count = 0;
            // for (int i = 0; i <= hLength - nLength; i++) {
            //     count = 0;
            //     for (int j = 0; j < nLength; j++) {
            //         // System.out.println(haystack.charAt(i + j) + " | " + needle.charAt(j));
            //         if (haystack.charAt(i + j) == needle.charAt(j)) {
            //             count++;
            //             // System.out.println(count);
            //         } else {
            //             break;
            //         }
            //         if (count == nLength) {
            //             return i;
            //         }
            //     }
            // }
            // return -1;
        }
    }
}
