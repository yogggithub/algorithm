package problems.p404_SumOfLeftLeaves;

import java.util.Stack;

public class Self {
    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            return result;
        }

        /*
         * Solution v1: Recursive
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 36.9 MB @ (beats) 52.85%
         */
        // if (root.left != null &&
        //     (root.left.left == null && root.left.right == null)) {
        //     return root.left.val + sumOfLeftLeaves(root.right);
        // }
        //
        // return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);


        /*
         * Solution v2: Iterative
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 36.7 MB @ (beats) 83.54%
         */
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null &&
                (node.left.left == null && node.left.right == null)) {
                result += node.left.val;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
