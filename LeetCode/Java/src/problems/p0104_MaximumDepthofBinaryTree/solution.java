package problems.p0104_MaximumDepthofBinaryTree;

import auxiliary.TreeNode;

public class solution {
    public int maxDepth(TreeNode root) {

        // 这个解法语句更简练
            return root == null ?
                    0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
