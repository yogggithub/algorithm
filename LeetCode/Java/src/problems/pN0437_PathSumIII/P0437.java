package problems.pN0437_PathSumIII;

import auxiliary.TreeNode;

/*
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 *
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * Return 3. The paths that sum to 8 are:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * */



public class P0437 {
    public int pathSum(TreeNode root, int sum) {

        // 没做出来，超时
        if (root == null) {
            return 0;
        }
        return _pathSum(root, sum);
    }

    public int _pathSum(TreeNode root, int num) {
        int count = 0, sum = 0;
        while (sum <= num) {
            if (root.val < num) {
                sum += root.val;
                if (root.left != null) {
                    root = root.left;
                } else if (root.right != null){
                    root = root.right;
                } else{
                    break;
                }
                if (sum == num) {
                    count++;
                }
            }
        }
        return count;
    }
}
