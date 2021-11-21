package problems.p0106_ConstructBinaryTreeFromInorderAndPostorderTraversal;

import auxiliary.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P0106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        /*
         * Solution v1: Recursive
         *
         * Runtime: 4 ms @ (beats) 30.32%
         * Memory Usage: 38.9 MB @ (beats) 74.78%
         */
        // idea
        // from the problem, all node is unique
        // and the last element of post order always is root
        // it is easy to break array to left and right subtrees by match root
        // and recur this process

        return buildTree(inorder, 0, inorder.length - 1,
                         postorder, 0, postorder.length - 1);

    }

    /*
     * Solution v1: Recursive
     */
    private TreeNode buildTree(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {

        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        // get root node
        TreeNode root = new TreeNode(postorder[postRight]);

        // find the root from inorder array
        int index = 0;
        for (index = inLeft; index < inorder.length; index++) {
            if (inorder[index] == root.val) {
                break;
            }
        }


        // the interval of post order: postLeft + index - inLeft - 1
        // index - inLeft -> is the setback amount of inorder array
        root.left = buildTree(inorder, inLeft, index - 1,
                              postorder, postLeft, postLeft + index - inLeft - 1);
        root.right = buildTree(inorder, index + 1, inRight,
                               postorder, postLeft + index - inLeft, postRight - 1);
        return root;
    }
}
