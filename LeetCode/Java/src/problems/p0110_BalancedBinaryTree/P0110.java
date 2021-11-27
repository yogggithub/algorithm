package problems.p0110_BalancedBinaryTree;

import auxiliary.TreeNode;

public class P0110 {
    public boolean isBalanced(TreeNode root) {
        /*
         * Solution v1: Recursive && Depth judgement
         *
         * Runtime: 2 ms @ (beats) 17.80%
         * Memory Usage: 41.8 MB @ (beats) 19.73%
         */
        // if (root == null) {
        //     return true;
        // }
        //
        // int left = maxDepth(root.left);
        // int right = maxDepth(root.right);
        // // pay attention here
        // // need to judge whether current node is balanced
        // // and all left and right sub trees are balanced
        // return Math.abs(left - right) < 2 &&
        //        isBalanced(root.left) &&
        //        isBalanced(root.right);

        /*
         * (learn from Internet)
         * Solution v2: Bottom up
         */
        //idea
        // Instead of calling depth() explicitly for each child node,
        // we return the height of the current node in DFS recursion.
        // When the sub tree of the current node (inclusive) is balanced,
        // the function dfsHeight() returns a non-negative value as the height.
        // Otherwise -1 is returned.
        // According to the leftHeight and rightHeight of the two children,
        // the parent node could check if the sub tree
        // is balanced, and decides its return value.
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }

        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    /*
     * Solution v1: Recursive && Depth judgement
     */
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
