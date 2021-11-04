package problems.pN0101_SymmetricTree;

public class solution {


    public boolean isSymmetric(TreeNode root) {
        // Approach 1: Recursive
        return isMirror(root, root);

        // Approach 2: Iterative
        // if (root == null) {
        //     return true;
        // }
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        // q.add(root);
        // while (!q.isEmpty()) {
        //     TreeNode t1 = q.poll();
        //     TreeNode t2 = q.poll();
        //     if (t1 == null && t2 == null){
        //         continue;
        //     }
        //     if (t1 == null || t2 == null){
        //         return false;
        //     }
        //     if (t1.val != t2.val){
        //         return false;
        //     }
        //     q.add(t1.left);
        //     q.add(t2.right);
        //     q.add(t1.right);
        //     q.add(t2.left);
        // }
        // return true;
    }

    // Approach 1: Recursive
    public boolean isMirror(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}