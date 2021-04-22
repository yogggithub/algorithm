package princeton.i.week_5.lecture;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeSearch {

    /**
     * 辅助树结构
     */
    static class TreeNode {
        int node;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.node = value;
        }
    }

    TreeNode root;

    public BinaryTreeSearch(int[] array) {
        root = makeBinaryTreeByArray(array, 1);
    }

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    private TreeNode makeBinaryTreeByArray(int[] array, int i) {
        if (i < array.length) {
            int value = array[i];
            if (value != 0) {
                TreeNode node = new TreeNode(value);
                array[i] = 0;
                node.left =
                    makeBinaryTreeByArray(array, i * 2);
                node.right =
                    makeBinaryTreeByArray(array, i * 2 + 1);
                return node;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            /*
             * Stack的特点：后进先出
             * 所以，每次都会先研究刚放进来的这个节点
             * 先放右子节点，后放左子节点
             * 所以会先遍历左子树
             */
            TreeNode node = stack.pop();
            System.out.print(node.node + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.print("\n");
    }

    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.node + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }

    /**
     * 13
     * /  \
     * 65   5
     * / \   \
     * 97 25   37
     * /  /\   /
     * 22 4 28 32
     */
    public static void main(String[] args) {
        int[] arr = {0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0};
        BinaryTreeSearch tree = new BinaryTreeSearch(arr);
        tree.depthOrderTraversal();
        tree.levelOrderTraversal();
    }
}