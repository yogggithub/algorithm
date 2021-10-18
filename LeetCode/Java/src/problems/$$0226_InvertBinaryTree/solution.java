package problems.$$0226_InvertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class solution {
    public static void main(String[] args) {
        solution self = new solution();

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

        self.invertTree(tree1);
        // System.out.println(self.invertTree(tree1).right.right.val);
    }

    public TreeNode invertTree(TreeNode root) {

        // Approach 1: Recursive
        /*
         * 不要去考虑指针，就是想办法迭代，左变成右，右变成左
         * 这个思路通过2个中间变量，把左、右分别迭代、存储，然后交换
         *
         * */

        // if (root == null) {
        //     return null;
        // }
        // TreeNode right = invertTree(root.right);
        // TreeNode left = invertTree(root.left);
        // root.left = right;
        // root.right = left;
        // return root;


        // Approach 2: Iterative
        /*
         * 使用queue来操作，注意queue是先进先出的list
         * 所以下面的code，实际是先从变更左子树
         * 直到左子树全变更完，回到右子树顶端，开始转换
         *
         * 但，这些操作为什么会影响root？
         * 我的理解是，current这个对象不是new出来的，而是传入了地址值
         * 所以，current的变更，影响了有相同地址值的root及其各个子树
         *
         * 所以，这个方法，要加强对new和Object的理解
         *
         * */

        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);  // 传入的是地址值，指向的是整个Tree
        System.out.println(queue.peek());
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return root;
    }
}
