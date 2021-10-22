package top_interview_questions.easy.string;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "a.";
        String str2 = " ";
        String str3 = "0P";
        String str4 = ".,";
        String str5 = "aa";
        System.out.println(solution.isPalindrome(str1));
        System.out.println(solution.isPalindrome(str2));
        System.out.println(solution.isPalindrome(str3));
        System.out.println(solution.isPalindrome(str4));
        System.out.println(solution.isPalindrome(str5));


    }

    static class Solution {
        public boolean isPalindrome(String s) {
            /*
             * Solution v1: Char array
             *
             * Runtime: 30 ms @ (beats) 22.02%
             * Memory Usage: 43.8 MB @ (beats) 14.44%
             */

            // convert string to all lower case, and remove characters other than 0-9 or a-z
            // s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
            // if (s.length() > 1) {
            //     int i = 0, j = s.length() - 1;
            //
            //     while (i <= j) {
            //         char l = s.charAt(i);
            //         char r = s.charAt(j);
            //         if (l != r) {
            //             return false;
            //         } else {
            //             i++;
            //             j--;
            //         }
            //     }
            // }

            /*
             * (learn from Internet)
             * Solution v1.2: judge in loop
             */
            if (s == null || s.length() == 0) {
                return false;
            }
            s = s.toLowerCase();
            int i = 0, j = s.length() - 1;
            char[] chars = s.toCharArray();
            while (i <= j) {
                while (i < j && (!Character.isLetter(chars[i]) && !Character.isDigit(chars[i]))) {
                    i++;
                }
                while (j > i && (!Character.isLetter(chars[j]) && !Character.isDigit(chars[j]))) {
                    j--;
                }
                char l = chars[i], r = chars[j];
                if (l != r) {
                    return false;
                }
                i++;
                j--;
            }


            return true;
        }
    }
}
