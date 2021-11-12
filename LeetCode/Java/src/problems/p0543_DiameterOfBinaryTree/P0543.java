package problems.p0543_DiameterOfBinaryTree;

import auxiliary.TreeNode;

public class P0543 {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        /*
         * Solution v1: Recursive & DFS
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 38.6 MB @ (beats) 94.62%
         */
        // idea
        // for each node, the diameter is the sum of left and right sub trees
        // And from the problem, the routine may not pass through root node
        // Thus it is better to calculate max depth of every node
        // at last return the maximum one
        DFS(root);
        return diameter;
    }

    private int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = DFS(root.left);
        int right = DFS(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
