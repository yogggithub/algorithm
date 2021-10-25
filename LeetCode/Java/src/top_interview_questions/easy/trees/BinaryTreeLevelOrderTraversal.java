package top_interview_questions.easy.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();
        if (root == null) {
            return null;
        }

        /*
         * Solution v1: Recursive
         *
         * Runtime: 1 ms @ (beats) 21.03%
         * Memory Usage: 40 MB @ (beats) 40.44%
         */
        // int level = 0;
        // nodes.add(new ArrayList<>());
        //
        // return levelOrder(root, level, nodes);

        /*
         * Solution v2: Iterative
         *
         * Runtime: 1 ms @ (beats) 21.03%
         * Memory Usage: 40.4 MB @ (beats) 12.14%
         */
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        while (!levelNodes.isEmpty()) {
            //
            int size = levelNodes.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = levelNodes.poll();
                curLevel.add(node.val);
                if (node.left != null) {
                    levelNodes.add(node.left);
                }
                if (node.right != null) {
                    levelNodes.add(node.right);
                }
            }
            nodes.add(curLevel);
        }
        return nodes;
    }

    /*
     * Solution v1: Recursive
     */
    public List<List<Integer>> levelOrder(TreeNode root,
                                          int level,
                                          List<List<Integer>> nodes) {
        if (root == null) {
            return nodes;
        }

        if (nodes.size() == level) {
            nodes.get(level).add(root.val);
        }

        // should not increment List by this
        // cause it would add extra level when
        // recursive with both left and right subtrees.
        if (root.left != null || root.right != null) {
            List<Integer> nextLevel = new ArrayList<>();
            nodes.add(nextLevel);
        }

        if (root.left != null) {
            levelOrder(root.left, level + 1, nodes);
        }
        if (root.right != null) {
            levelOrder(root.right, level + 1, nodes);
        }

        return nodes;
    }
}
