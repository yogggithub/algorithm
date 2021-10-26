package top_interview_questions.easy.dynamic;

public class HouseRobber {
    public int rob(int[] nums) {
        // give condition: 1 <= nums.length <= 100
        if (nums.length == 1) {
            return nums[0];
        }

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 36.5 MB @ (beats) 63.18%
         */

        // for any house[i], there are two exclusive options: rob or not
        // if rob, value is nums[i] + profit[i - 2]
        // if not, value is profit[i - 1]
        // just follow the Greedy rule to maximize the profit

        int length = nums.length;
        int[] profit = new int[length];
        // for the first two house, just decide rob 0 or 1
        profit[0] = nums[0];
        profit[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < length; i++) {
            profit[i] = Math.max(nums[i] + profit[i - 2], profit[i - 1]);
            System.out.println("profit[" + i + "] = " + profit[i]);
        }
        return profit[length - 1];

    }
}
