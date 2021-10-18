package top_interview_questions.easy.array;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // Input array
        int[] expectedNums = {0, 1, 2, 3, 4}; // The expected answer with correct length
        int k = solution.removeDuplicates(nums); // Calls your implementation

        // Custom Judge
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }

        // print out modified array;
        System.out.print("[ ");
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.print(" ] \n");
        System.out.println(solution.removeDuplicates(nums));
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int k = 0; // unique element amount

            /*
             * Solution v1: Two layer loop with double pointers.
             * Runtime: 5 ms
             * Memory Usage: 40.2 MB
             *
             * Summary: Runtime only beats 8.72%.
             */

            // for (int i = 0; i < nums.length; i++) {
            //     boolean isUnique = true;
            //     for (int j = 0; j < k; j++) {
            //         if (nums[j] == nums[i]) {
            //             isUnique = false;
            //             break;
            //         }
            //     }
            //     if (isUnique) {
            //         nums[k] = nums[i];
            //         k++;
            //     }
            // }

            /*
             * Solution v2: Single layer loop
             * (Because given a sorted array)
             * Runtime: 1 ms
             * Memory Usage: 44.7 MB
             *
             * Summary: Runtime only beats 86.47%.
             */
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    nums[k++] = nums[i];
                } else if (nums[k - 1] < nums[i]) {
                    nums[k++] = nums[i];
                }
            }

            return k;
        }
    }
}
