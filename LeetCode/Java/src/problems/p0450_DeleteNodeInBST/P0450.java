package problems.p0450_DeleteNodeInBST;

import auxiliary.TreeNode;

public class P0450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        // idea
        // If the node to be deleted has
        // 1. Only left child: Overwrite it with left child
        // 2. Only right child: Overwrite it with right child
        // 3. Both left and right child
        // 3.1. find the min node in the right child
        // 3.2. append the left child of the node to be deleted to this min node's left child
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null && cur.val != key) {
            prev = cur;
            if (key < cur.val) {
                cur = cur.left;
            } else if (key > cur.val) {
                cur = cur.right;
            }
        }

        //deleting root
        if (prev == null) {
            return deleteThisNode(cur);
        }

        //deleting prev's left node
        if (prev.left == cur) {
            prev.left = deleteThisNode(cur);
        }
        //deleting prev's right node
        else {
            prev.right = deleteThisNode(cur);
        }

        return root;
    }

    //Finding the min node, ie, the leftmost node
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private TreeNode deleteThisNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        //since left child is null, overwrite it with right child
        if (root.left == null) {
            return root.right;
        }

        //since right child is null, overwrite it with left child
        if (root.right == null) {
            return root.left;
        }

        // if both the left and right child exists, then
        // 1. find the min node in the right child         //TreeNode next = findMin(root.right);
        // 2. append the left child of the node to
        // be deleted to this min node's left child    //next.left = root.left;
        TreeNode next = findMin(root.right); //find the min value in the right child
        next.left = root.left;//so that the left child of the node to be deleted is not lost
        return root.right;
    }
}
