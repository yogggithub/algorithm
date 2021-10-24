package top_interview_questions.easy.trees;

import java.util.LinkedList;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {
    static class Solution {
        public int maxDepth(TreeNode root) {

            // base case
            if (root == null) {
                return 0;
            } else if (root.left == null && root.right == null) {
                return 1;
            } else {

                /*
                 * Solution v1: Recursive
                 *
                 * Runtime: 0 ms @ (beats) 100%
                 * Memory Usage: 40.3 MB @ (beats) 35.41%
                 */

                //     int left = 1 + maxDepth(root.left);
                //     int right = 1 + maxDepth(root.right);
                //     return left >= right ? left : right;
                // }

                /*
                 * Solution v2: Iterative
                 *
                 * Runtime: 7 ms @ (beats) 7.17%
                 * Memory Usage: 41.7 MB @ (beats) 0%
                 */
                Stack<TreeNode> nodes = new Stack<>();
                Stack<Integer> depths = new Stack<>();

                nodes.add(root);
                depths.add(1);

                int currentDep, depth = 0;

                while (!nodes.isEmpty()) {
                    root = nodes.pop();
                    currentDep = depths.pop();

                    if (root != null) {
                        depth = Math.max(depth, currentDep);

                        nodes.add(root.left);
                        nodes.add(root.right);
                        depths.add(currentDep + 1);
                        depths.add(currentDep + 1);
                    }
                }
                return depth;
            }
        }
    }
}
