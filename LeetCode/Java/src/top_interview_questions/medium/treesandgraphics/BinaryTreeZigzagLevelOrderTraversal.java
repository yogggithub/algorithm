package top_interview_questions.medium.treesandgraphics;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        /*
         * Solution v1: Recursive
         *
         * Runtime: ms @ (beats) %
         * Memory Usage: MB @ (beats) %
         */
        zigzagLevelOrder(root, result, 0);

        /*
         * Solution v1: Iterative
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 39.3 MB @ (beats) 51.80%
         */
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(root);
        // int depth = 0;
        // while (!queue.isEmpty()) {
        //     List<Integer> level = new ArrayList<>();
        //     for (int i = queue.size(); i > 0; --i) {
        //         TreeNode node = queue.poll();
        //         level.add(node.val);
        //         if (node.left != null) {
        //             queue.add(node.left);
        //         }
        //         if (node.right != null) {
        //             queue.add(node.right);
        //         }
        //     }
        //     if (depth % 2 == 1) {
        //         Collections.reverse(level);
        //     }
        //     result.add(level);
        //     depth++;
        // }


        return result;
    }

    /*
     * Solution v1: Recursive
     */
    private void zigzagLevelOrder(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }

        List<Integer> list;
        if (level >= result.size()) {
            list = new ArrayList<>();
            result.add(list);
        }
        list = result.get(level);

        if (level % 2 == 0) {
            // for even levels, add val to the end
            list.add(root.val);
        } else {
            // for odd levels, add val to the beginning
            list.add(0,root.val);
        }
        zigzagLevelOrder(root.left, result, level + 1);
        zigzagLevelOrder(root.right, result, level + 1);
    }
}

