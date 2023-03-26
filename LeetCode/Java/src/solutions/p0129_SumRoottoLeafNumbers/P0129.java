package solutions.p0129_SumRoottoLeafNumbers;

import auxiliary.TreeNode;

public class P0129 {
    public int sumNumbers(TreeNode root) {
        /*
         * Solution v1: Recursive DFS
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 40.4 MB @ (beats) 28.58%
         */

        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        int new_v = val * 10 + root.val;

        if (root.left == null && root.right == null) {
            return new_v;
        }

        return dfs(root.left, new_v) + dfs(root.right, new_v);
    }
}
