package top_interview_questions.easy.array;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {0, 1, 0, 3, 1,2}, nums2 = {2, 1}, nums3 = {1, 0};
        solution.moveZeroes(nums1);
        // solution.moveZeroes(nums2);
        // solution.moveZeroes(nums3);
        // System.out.println(Arrays.toString(nums1));
        // System.out.println(Arrays.toString(nums2));
        // System.out.println(Arrays.toString(nums3));

    }

    static class Solution {
        public void moveZeroes(int[] nums) {

            /*
             * Solution v1: Auxiliary queue
             *
             * Runtime: 10 ms @ (beats) 8.19%
             * Memory Usage: 52.3 MB @ (beats) 12.97%
             */

            // Queue<Integer> temp = new LinkedList<>() ;
            //
            // for (int i : nums) {
            //     if (i != 0) {
            //         temp.add(i);
            //     }
            // }
            // int l = temp.size();
            // System.out.println(temp.toString());
            // for (int i = 0; i < nums.length; i++) {
            //     if (i < l) {
            //         nums[i] = temp.poll();
            //     } else {
            //         nums[i] = 0;
            //     }
            // }

            /*
             * Solution v2.1: Two pointers
             *
             * Runtime: 122 ms @ (beats) 0%
             * Memory Usage: 53 MB @ (beats) 0%
             */
            // int i = 0, j = 0;
            //
            // while (i < nums.length) {
            //     if (nums[i] == 0) {
            //         while (j < nums.length) {
            //             if (nums[j] != 0) {
            //                 nums[i] = nums[j];
            //                 nums[j] = 0;
            //                 break;
            //             }
            //             j++;
            //         }
            //     }
            //     i++;
            //     j = i;
            // }
            // for (int k = i + 1; k < nums.length; k++) {
            //     nums[k] = 0;
            // }


            /*
             * Solution v2.2: Modified two pointers
             *
             * Runtime: 5 ms @ (beats) 11.43%
             * Memory Usage: 52 MB @ (beats) 15.35%
             */
            // int i = 0, j = 0;
            //
            // while (i < nums.length) {
            //     if (j == nums.length) {
            //         nums[i] = 0;
            //     } else if (nums[i] == 0) {
            //         while (j < nums.length) {
            //             if (nums[j] != 0) {
            //                 nums[i] = nums[j];
            //                 nums[j++] = 0;
            //                 break;
            //             }
            //             j++;
            //         }
            //     }
            //     i++;
            //     if (j < i) {
            //         j = i;
            //     }
            // }

            /*
             * Solution v2.3: Two pointers with reduced loops
             *
             * Runtime: 5 ms @ (beats) 11.43%
             * Memory Usage: 52.9 MB @ (beats) 0%
             */
            // int i = 0, j = 0;
            //
            // while (i < nums.length && j <= nums.length) {
            //     if (j == nums.length) {
            //         nums[i++] = 0;
            //     } else if (nums[i] == 0) {
            //         if (nums[j] != 0) {
            //             nums[i] = nums[j];
            //             nums[j] = 0;
            //             continue;
            //         }
            //         j++;
            //     } else {
            //         i++;
            //         if (j < i) {
            //             j = i;
            //         }
            //     }
            // }

            /*
             * (learn from Internet)
             * Solution v2.4: Two pointers, the correct logic
             */
            int slow = 0, fast = 0;

            while (fast < nums.length) {
                if (nums[fast] == 0) {
                    fast++;
                    continue;
                }
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
                fast++;
                // System.out.println(fast + " | " + Arrays.toString(nums));
            }

        }
    }
}
