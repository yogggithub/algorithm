package top_interview_questions.easy.string;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] str1 = {'h', 'e', 'l', 'l', 'o'};
        char[] str2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString(str1);
        solution.reverseString(str2);
        System.out.println(Arrays.toString(str1));
        System.out.println(Arrays.toString(str2));

    }

    static class Solution {
        public void reverseString(char[] s) {

            /*
             * Solution v1: Two pointers
             *
             * Runtime: 1 ms @ (beats) 96.21%
             * Memory Usage: 45.6 MB @ (beats) 87.97%
             */
            int i = 0, j = s.length - 1;
            while (i < j) {
                char temp = s[i];
                s[i++] = s[j];
                s[j--] = temp;
            }

        }
    }
}
