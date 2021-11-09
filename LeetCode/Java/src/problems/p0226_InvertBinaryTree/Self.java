package problems.p0226_InvertBinaryTree;

import auxiliary.TreeNode;

public class Self {
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
