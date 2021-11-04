package problems.p0617_MergeTwoBinaryTrees;

import java.util.Stack;

public class solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        // Approach 1: Using Recursion
        /*
         * 这个思路和我的一样，不过比我的更精简
         *
         * */

        // 在这个判断条件下，确实无需再考虑两个都是null的情况
        // if (t1 == null){
        //     return t2;
        // }
        // if (t2 == null) {
        //     return t1;
        // }
        // t1.val += t2.val;
        // t1.left = mergeTrees(t1.left, t2.left);
        // t1.right = mergeTrees(t1.right, t2.right);
        // return t1;


        // Approach 2: Iterative Method
        /*
         * 思路：特殊类型及相应的数组运用，外加stack，很复杂
         * 将两个树作为数组的两个元素，并将数组装入stack
         * 在循环中，将子树不断装入stack，并将stack中取出来加和
         * 最终子树到头，stack取空
         *
         * */

        if (t1 == null) {
            return t2;
        }
        // 这里的TreeNode类型，为什么加了数组符号[]？把两个树当作一个数组？
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;
    }
}
