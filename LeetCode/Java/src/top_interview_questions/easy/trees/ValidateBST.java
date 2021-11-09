package top_interview_questions.easy.trees;

import auxiliary.TreeNode;

import java.util.Stack;

public class ValidateBST {


    class Solution {
        public boolean isValidBST(TreeNode root) {

            if (root == null) {
                return true;
            }
            /*
             * Solution v1: Recursive
             *
             * Runtime: 0 ms @ (beats) 100%
             * Memory Usage: 41.1 MB @ (beats) 30.82%
             */

            // valid right subtree must large than any of the left subtree
            // thus, need additional variables to store the boundaries
            // there are values exceed Integer limitation
            // return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

            /*
             * Solution v2: Iterative
             *
             * Runtime: 0 ms @ (beats) 100%
             * Memory Usage: 41.1 MB @ (beats) 30.82%
             */
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            TreeNode prev = null;

            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                if (prev != null && prev.val >= curr.val) {
                    return false;
                }
                prev = curr;
                curr = curr.right;
            }
            return true;
        }

        /*
         * Solution v1: Recursive
         *
         */
        public boolean isValidBST(TreeNode root, long lower, long upper) {
            if (root == null) {
                return true;
            }
            // node value is not in the valid range
            if (root.val <= lower || root.val >= upper) {
                return false;
            }
            return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
        }
    }
}
