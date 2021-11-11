package problems.p0226_InvertBinaryTree;

import auxiliary.TreeNode;

/*
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example 1:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

public class P0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        /*
         * Solution v1: Iterative
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 36.2 MB @ (beats) 96.72%
         */
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(root);
        // while (!queue.isEmpty()) {
        //     TreeNode node = queue.poll();
        //     TreeNode temp = node.left;
        //     node.left = node.right;
        //     node.right = temp;
        //     if (node.left != null) {
        //         queue.add(node.left);
        //     }
        //     if (node.right != null) {
        //         queue.add(node.right);
        //     }
        // }
        // return root;

        /*
         * Solution v2: Recursive
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 36.6 MB @ (beats) 54.60%
         */
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        return root;
    }

}
