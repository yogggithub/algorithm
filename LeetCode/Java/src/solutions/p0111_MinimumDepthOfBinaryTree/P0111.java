package solutions.p0111_MinimumDepthOfBinaryTree;

import auxiliary.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P0111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /*
         * Solution v1: Recursive
         *
         * Runtime: 18 ms @ (beats) 6.57%
         * Memory Usage: 93.6 MB @ (beats) 10.62%
         */
        // if (root.left == null && root.right == null) {
        //     return 1;
        // } else if (root.left == null) {
        //     return 1 + minDepth(root.right);
        // } else if (root.right == null) {
        //     return 1 + minDepth(root.left);
        // } else {
        //     return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        // }

        /*
         * Solution v2: Iterative
         *
         * Runtime: 1 ms @ (beats) 87.52%
         * Memory Usage: 92.5    MB @ (beats) 22.47%
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // BFS because find one leaf node could stop the app
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                // begin with 1 and increment each layer
                // thus no need to plus 1 here
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
