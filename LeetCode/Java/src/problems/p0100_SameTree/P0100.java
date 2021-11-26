package problems.p0100_SameTree;

import auxiliary.TreeNode;

import java.util.Stack;

public class P0100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*
         * Solution v1.1: Recursive
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 38.4 MB @ (beats) 21.51%
         */
        // if (p == null && q == null) {
        //     return true;
        // } else if (p != null && q != null) {
        //     if (p.val != q.val) {
        //         return false;
        //     } else {
        //         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        //     }
        // } else {
        //     return false;
        // }

        /*
         * Solution v1.2: Recursive Optimize
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 38.4 MB @ (beats) 21.51%
         */
        // if (p == null && q == null) {
        //     return true;
        // } else if (p == null || q == null) {
        //     return false;
        // }
        // return p.val == q.val &&
        //        isSameTree(p.left, q.left) &&
        //        isSameTree(p.right, q.right);

        /*
         * Solution v2.1: Iterative
         *
         * Runtime: 1 ms @ (beats) 100%
         * Memory Usage: 38.5 MB @ (beats) 16.78%
         */

        Stack<TreeNode> p_s = new Stack<>();
        Stack<TreeNode> q_s = new Stack<>();
        p_s.push(p);
        q_s.push(q);

        while (!p_s.isEmpty() && !q_s.isEmpty()) {
            TreeNode p_temp = p_s.pop();
            TreeNode q_temp = q_s.pop();

            if (p_temp == null && q_temp == null) {
                continue;
            } else if (p_temp == null || q_temp == null) {
                return false;
            } else {
                if (p_temp.val != q_temp.val) {
                    return false;
                }
            }
            p_s.push(p_temp.left);
            p_s.push(p_temp.right);
            q_s.push(q_temp.left);
            q_s.push(q_temp.right);
        }

        return p_s.isEmpty() && q_s.isEmpty();
    }
}
