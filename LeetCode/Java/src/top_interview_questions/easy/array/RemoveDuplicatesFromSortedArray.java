package top_interview_questions.easy.array;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // Input array
        System.out.println(solution.removeDuplicates(nums));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0; // unique element amount

        /*
         * Solution v1:
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
         * Solution v2:
         * Runtime: 5 ms
         * Memory Usage: 40.2 MB
         *
         * Summary: Runtime only beats 8.72%.
         */
        

        return k;
    }

    // Custom Judge
    public void customJudge(int[] nums, int[] expectedNums) {
        // int[] expectedNums = {0,1,2,3,4}; // The expected answer with correct length
        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

}
