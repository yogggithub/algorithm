package problems.pN0437_PathSumIII;

import java.util.HashMap;

public class solution {
    public int pathSum(TreeNode root, int sum) {

        // Approach 1:  recursive DFS (Brute Force)
        /*
         * 这是经典的暴力循环思路，理解并运用
         *
         * */

        if (root == null) {
            return 0;
        }
        // 这里为什么还要分别用left和right求一次？配套方法不是有分别的迭代？
        return pathSumFrom(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);


        // Approach 2: HashMap
        /*
         * we check if prefix sum - target exists in hashmap or not,
         * if it does, we added up the ways of prefix sum - target into res.
         *
         * For instance :
         * in one path we have 1,2,-1,-1,2,
         * then the prefix sum will be: 1, 3, 2, 1, 3,
         * let's say we want to find target sum is 2,
         * then we will have{2}, {1,2,-1}, {2,-1,-1,2} and {2}ways.
         *
         *
         * comment：
         * 1. In any node, we could have currSum, we have the target.
         *    we will always have currSum = target + A.
         *    ( A is the number we tried to find)
         * 2. We will store the number of ways from top->bottom to hit this node.
         * 3. If we find A with non-zero value in the HashMap, means,
         *    there are 'non-zero' ways to get that node.
         *    we will add those ways into total.
         *
         * 这里有几个难理解的点：
         * 1. 为什么是 currSum - target，而不是 target - currSum？
         *
         *
         * */

        // HashMap<Integer, Integer> preSum = new HashMap();
        // preSum.put(0, 1);
        // return helper(root, 0, sum, preSum);
    }

    // Approach 1:  recursive DFS 配套方法，用来计数
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val)
                + pathSumFrom(node.right, sum - node.val);
    }

    // Approach 2: HashMap 配套方法，用来计算
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
