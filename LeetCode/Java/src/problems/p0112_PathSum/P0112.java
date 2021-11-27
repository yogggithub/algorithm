package problems.p0112_PathSum;

import auxiliary.TreeNode;

public class P0112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        /*
         * Solution v1: Recursive
         *
         * Runtime: 1 ms @ (beats) 100%
         * Memory Usage: 40.7 MB @ (beats) 18.60%
         */
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        } else {
            return hasPathSum(root.left, targetSum - root.val) ||
                   hasPathSum(root.right, targetSum - root.val);
        }
    }
}
