package top_interview_questions.easy.dynamic;

public class MaximumSubarray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        // given condition: 1 <= nums.length <= 10^5
        if (nums.length == 1) {
            return nums[0];
        }

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 1 ms @ (beats) 87.08%
         * Memory Usage: 50MB @ (beats) 23.85%
         */

        int result = Integer.MIN_VALUE, current = 0;
        for (int num : nums) {
            // all previous elements is valuable unless their sum is less than 0
            current = Math.max(current + num, num);
            result = Math.max(current, result);
        }
        return result;
    }
}
