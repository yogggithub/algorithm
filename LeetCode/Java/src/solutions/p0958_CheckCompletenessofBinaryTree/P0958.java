package solutions.p0958_CheckCompletenessofBinaryTree;

import auxiliary.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P0958 {
    public boolean isCompleteTree(TreeNode root) {
        /*
         * Solution v1: BFS
         *
         * Runtime: 1 ms @ (beats) 83.31%
         * Memory Usage: 42.5 MB @ (beats) 13.75%
         */
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean missed = false;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                missed = true;
                continue;
            }

            if (missed) {
                return false;
            }

            q.add(node.left);
            q.add(node.right);
        }

        return true;
    }
}
