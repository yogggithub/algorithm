package top_interview_questions.easy.trees;

import java.util.Arrays;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {

        // base case
        int size = nums.length;
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return new TreeNode(nums[0]);
        }

        /*
         * Solution v1: Recursive
         *
         * Runtime: 1 ms @ (beats) 0%
         * Memory Usage: 41.2 MB @ (beats) 0%
         */
        // base case to speed up
        if (size == 2) {
            return new TreeNode(nums[1], new TreeNode(nums[0]), null);
        }
        if (size == 3) {
            return new TreeNode(nums[1], new TreeNode(nums[0]), new TreeNode(nums[2]));
        }

        int[] left = Arrays.copyOfRange(nums, 0, size / 2);
        int[] right = Arrays.copyOfRange(nums, size / 2 + 1, size);
        return new TreeNode(nums[size / 2], sortedArrayToBST(left), sortedArrayToBST(right));


        /*
         * Solution v2: Iterative (Unfinished)
         *
         * Runtime: ms @ (beats) 0%
         * Memory Usage: MB @ (beats) 0%
         */

    }
}
