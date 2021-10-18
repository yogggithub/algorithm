package problems.$$0543_DiameterofBinaryTree;

public class solution {
    int ans;    // Approach 1: Depth-First Search 配套成员变量

    public int diameterOfBinaryTree(TreeNode root) {

        // Approach 1: Depth-First Search
        /*
         * 这个和我的思路一样，但是我没能写出来
         * 注意：最后的结果应该是深度 - 1
         *
         * */

        ans = 1;
        depth(root);
        return ans - 1;
    }

    // Approach 1: Depth-First Search 配套方法，用来求深度
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1); // 给成员变量赋值，作为实际的结果
        // 这里不能不给返回值，原因：
        // 因为要迭代，需要将子树结果赋值给left & right，就必须有int返回
        return Math.max(L, R) + 1;
    }
}
