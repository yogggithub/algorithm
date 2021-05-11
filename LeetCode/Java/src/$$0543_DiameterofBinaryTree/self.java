package $$0543_DiameterofBinaryTree;

/*
 * Given a binary tree, you need to compute the length of the diameter
 * of the tree. The diameter of a binary tree is the length of the longest
 * path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by
 * the number of edges between them.
 *
 * */
public class self {
    public int diameterOfBinaryTree(TreeNode root) {

        // 没做出来
        // 从求二叉树深度 $104_MaximumDepthofBinaryTree 抄来的
        int dep = 0;
        if (root == null) {
            return 0;
        } else {
            int left = diameterOfBinaryTree(root.left);
            int right = diameterOfBinaryTree(root.right);
            if (dep < left + right) {
                dep = left + right;
            }
        }
        return dep;
    }
}
