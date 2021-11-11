package problems.p0543_DiameterOfBinaryTree;

import auxiliary.TreeNode;

/*
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Example 2:
 * Input: root = [1,2]
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 */
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
