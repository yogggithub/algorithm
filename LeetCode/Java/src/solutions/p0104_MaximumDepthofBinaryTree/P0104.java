package solutions.p0104_MaximumDepthofBinaryTree;

import auxiliary.TreeNode;

public class P0104 {
    public int maxDepth(TreeNode root) {

        // 正好整理的Binary Tree资料里面有高度的解法
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return left > right ? (left + 1) : (right + 1);
        }

        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
        // Memory Usage: 38.9 MB, less than 94.62% of Java online submissions for Maximum Depth of Binary Tree.

    }
}
