package $0104_MaximumDepthofBinaryTree;

/*
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 * */

public class self {
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
