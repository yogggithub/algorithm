package problems.p0096_UniqueBinarySearchTrees;

/*
 * Given an integer n,
 * return the number of structurally unique BST's (binary search trees)
 * which has exactly n nodes of unique values from 1 to n.
 *
 * Example 1:
 * Input: n = 3
 * Output: 5
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= n <= 19
 */
public class P0096 {
    public int numTrees(int n) {
        /*
         * Solution v1: Catalan Number
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 35.6 MB @ (beats) 85.71%
         */
        // idea
        // Catalan Number:
        // arr[3] = arr[0] * arr[1] -> 0 as root, left sub is null and right sub has two number
        //        + arr[1] * arr[1] -> 1 as root, one number for each sub trees
        //        + arr[2] * arr[0] -> 2 as root, left sub has two number and right sub is null
        // first two component could be consider as arr[2]
        // thus arr[3] = arr[2] + arr[2] * arr[0]

        int[] arr = new int[n + 1];
        // base case
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j] * arr[i - j - 1];
            }
        }
        return arr[n];
    }
}
