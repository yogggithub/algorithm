package top_interview_questions.easy.array;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 1};
        System.out.println(solution.containsDuplicate(nums));
    }

    static class Solution {
        public int containsDuplicate(int[] nums) {
            int result = 0;
            /*
             * Solution v1: Brute Force
             * 61 / 61 test cases passed
             *
             * Runtime: 12 ms @ (beats) 19.49%
             * Memory Usage: 47.6 MB @ (beats) 31.36%
             */
            // if (nums.length == 1) {
            //     result = nums[0];
            // } else {
            //     Arrays.sort(nums);
            //     for (int i = 0; i < nums.length; i++) {
            //         if (i == 0 && nums[i + 1] != nums[i]) {
            //             result = nums[i];
            //         } else if (i == nums.length - 1 && nums[i - 1] != nums[i]) {
            //             result = nums[i];
            //         } else if (i > 0 && i < nums.length - 1 && nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
            //             result = nums[i];
            //         }
            //     }
            // }

            /*
             * Solution v2: two dimensional Boolean array
             * 61 / 61 test cases passed
             *
             * Runtime: 1 ms @ (beats) 94.91%
             * Memory Usage: 38.8 MB @ (beats) 91.79%
             */

            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i : nums) {
                if (max < i) {
                    max = i;
                }
                if (min > i) {
                    min = i;
                }
            }

            boolean[] a = new boolean[max - min + 1];
            boolean[] b = new boolean[max - min + 1];

            for (int i : nums) {
                if (a[i - min]) {
                    b[i - min] = true;
                } else {
                    a[i - min] = true;
                }
            }
            for (int i = 0; i < b.length; i++) {
                if (a[i] && !b[i]) {
                    System.out.println(i);
                    result = i + min;
                }
            }


            return result;
        }
    }
}
