package problems.pN0226_InvertBinaryTree;

/*
 * Invert a binary tree.
 *
 * Example:
 * Input:
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * */


import auxiliary.TreeNode;

public class P0226 {
    public static void main(String[] args) {
        P0226 self = new P0226();

        TreeNode tree1 = new TreeNode(4);
        TreeNode tree21 = new TreeNode(2);
        TreeNode tree22 = new TreeNode(7);
        TreeNode tree311 = new TreeNode(1);
        TreeNode tree312 = new TreeNode(3);
        TreeNode tree321 = new TreeNode(6);
        TreeNode tree322 = new TreeNode(9);

        tree21.left = tree311;
        tree21.right = tree312;
        tree22.left = tree321;
        tree22.right = tree322;
        tree1.left = tree21;
        tree1.right = tree22;

        System.out.println(self.invertTree(tree1).right.right.val);
    }

    // 没做出来
    public TreeNode invertTree(TreeNode root) {
        // 为什么不加这个判定就空指针错误？
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
