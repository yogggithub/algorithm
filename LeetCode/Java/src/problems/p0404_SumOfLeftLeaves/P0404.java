package problems.p0404_SumOfLeftLeaves;

import auxiliary.TreeNode;
import java.util.Stack;

/*
 * Given the root of a binary tree, return the sum of all left leaves.
 *
 * Example 1:
 *     3
 *    / \
 *   9  20
 *      / \
 *     15  7
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
 *
 * Example 2:
 * Input: root = [1]
 * Output: 0
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 */

public class P0404 {
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
