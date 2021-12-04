package solutions.p0101_SymmetricTree;

import auxiliary.TreeNode;

import java.util.Stack;

public class P0101 {
    public boolean isSymmetric(TreeNode root) {
        // base case
        if (root == null) {
            return true;
        }
        /*
         * Solution v1: Recursive
         *
         * Runtime: 1 ms @ (beats) 0%
         * Memory Usage: 39 MB @ (beats) 0%
         */

        // return isSymmetric(root.left, root.right);

        /*
         * Solution v1: Iterative
         *
         * Runtime: 1 ms @ (beats) 0%
         * Memory Usage: 38.1 MB @ (beats) 55.70%
         */
        Stack<TreeNode> leftNodes = new Stack<>();
        Stack<TreeNode> rightNodes = new Stack<>();
        leftNodes.add(root.left);
        rightNodes.add(root.right);

        while (!leftNodes.isEmpty() && !rightNodes.isEmpty()) {
            TreeNode left = leftNodes.pop();
            TreeNode right = rightNodes.pop();
            // left and right are all null, continue
            if (left == null & right == null) {
                continue;
            }
            // either is null while the other is not null, false
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            // pay attention to the order of adding element
            // put the nodes by pair into the stack
            leftNodes.add(left.left);
            leftNodes.add(left.right);
            rightNodes.add(right.right);
            rightNodes.add(right.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // pay attention
        // to judge symmetric, need to compare leftmost and rightmost subtrees
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
