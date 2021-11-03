package top_interview_questions.medium.treesandgraphics;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        // base case
        List<Integer> result = new LinkedList<>();

        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }

        /*
         * Solution v1: Recursive
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 37.7 MB @ (beats) 42.12%
         */
        // if (root.left != null) {
        //     result.addAll(0, inorderTraversal(root.left));
        // }
        // result.add(root.val);
        // if (root.right != null) {
        //     result.addAll(inorderTraversal(root.right));
        // }

        /*
         * Solution v2: Iterative
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 37.2 MB @ (beats) 74.43%
         */
        // Stack<TreeNode> stack = new Stack<>();
        //
        // TreeNode node = root;
        // stack.add(node);
        // while (!stack.isEmpty()) {
        //     if (node != null) {
        //         stack.push(node);
        //         node = node.left;
        //     } else {
        //         node = stack.pop();
        //         result.add(node.val);
        //         node = node.right;
        //     }
        // }

        /*
         * (learn from Internet)
         * Solution v3: Morris Traversal
         */
        // idea:  Threaded binary tree
        // A binary tree is  threaded  by
        // making all right child pointers that would normally be null
        // point to the inorder successor of the node ( if it exists),
        // and all left child pointers that would normally be null
        // point to the inorder predecessor of the node.
        TreeNode current = root;
        TreeNode prenode;
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                prenode = current.left;
                while (prenode.right != null &&
                       prenode.right != current) {
                    prenode = prenode.right;
                }
                if (prenode.right == null) {
                    prenode.right = current;
                    current = current.left;
                } else {
                    prenode.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }

        return result;
    }
}
