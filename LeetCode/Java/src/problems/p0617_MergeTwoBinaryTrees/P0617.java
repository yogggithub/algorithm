package problems.p0617_MergeTwoBinaryTrees;

import auxiliary.TreeNode;

public class P0617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }
        return mergeTrees(t1, t2);

        // 竟然一次做对了
        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Binary Trees.
        // Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Merge Two Binary Trees.
    }

    public TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.left = mergeTrees(t1.left, t2.left);
        treeNode.right = mergeTrees(t1.right, t2.right);
        return treeNode;
    }
}
