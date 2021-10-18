package top_interview_questions.easy.array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));

    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            /*
             * Solution v1: Use an auxiliary array
             *
             * 38 / 38 test cases passed
             * Runtime: 3 ms @ (beats) 17.35%
             * Memory Usage: 63.9 MB @ (beats) 25.74%
             *
             */
            // int[] temp = Arrays.copyOf(nums, nums.length);
            //
            // for (int i = 0; i < nums.length; i++) {
            //     /*
            //      * every element should move back for k position
            //      * image the length of temp array is nums.length + k
            //      * reminder could be used to avoid the out-of-bound issue
            //      */
            //     int index = (i + k) % nums.length;
            //     nums[index] = temp[i];
            // }

            /*
             * Solution v2.1: Two layer of loop to move element back step by step
             * (Solute it in-place with O(1) space)
             * 37 / 38 test cases passed
             *
             * Time Limit Exceeded
             */

            // if (nums.length < 2) {
            //     return;
            // } else {
            //     int m, n = 0;   // two temp variables
            //     for (int i = 0; i < k; i++) {
            //         m = nums[0];
            //         for (int j = 1; j < nums.length; j++) {
            //             n = nums[j];
            //             nums[j] = nums[0];
            //             nums[0] = n;
            //         }
            //         nums[0] = n;
            //     }
            // }

            /*
             * Solution v2.2: Single loop to move element back step by step
             * (Solute it in-place with O(1) space)
             * 38 / 38 test cases passed
             *
             * Runtime: 4 ms @ (beats) 9.56%
             * Memory Usage: 64.3 MB @ (beats) 0%
             */
            // if (nums.length < 2 || (k %= nums.length) == 0) {
            //     return;
            // } else {
            //     int m = nums[0];    // m refers to value of the start element
            //     int n = 0;   // n stores value of element stand at the position
            //     int l = nums.length;    // array's size
            //     int i = 0;  // index
            //     int s = 0;  // a temp that indicate start point, avoid duplicate moving
            //
            //     // noticed that loop start with 0th (i) element and the value already stored in m.
            //     for (int j = 0; j < l; j++) {
            //         i = (i + k) % l;    // find the afterward position
            //         n = nums[i];    // store the waiting element's value
            //         nums[i] = m;    // replace the value
            //         m = n;  // exchange temp variables
            //         if (i == s) {   // When index back to start point,
            //             i = ++s;    // must move both index and start point one element behind
            //             m = nums[i];    // get the value of element
            //         }
            //         // System.out.println(Arrays.toString(nums));
            //     }
            // }

            /*
             * Solution v3: Reverse two sub arrays then reverse the whole generated array
             * (Solute it in-place with O(1) space)
             * 38 / 38 test cases passed
             *
             * Runtime: 3 ms @ (beats) 17.35%
             * Memory Usage: 64.2 MB @ (beats) 12.90%
             */
            if (nums.length < 2 || (k %= nums.length) == 0) {
                return;
            } else {
                reverseArr(nums, 0, nums.length - 1 - k);
                reverseArr(nums, nums.length - k, nums.length - 1);
                reverseArr(nums, 0, nums.length - 1);
            }

        }

        /*
         * Solution v3: Reverse Triple times
         */
        private void reverseArr(int[] arr, int begin, int end) {
            // int n = end - begin;
            // int k = 0;
            // for (int i = 0; i <= n / 2; i++) {
            //     k = arr[begin + i];
            //     arr[begin + i] = arr[end - i];
            //     arr[end - i] = k;
            // }

            // a better solution for reversing
            while (begin < end) {
                int temp = arr[begin];
                arr[begin++] = arr[end];
                arr[end--] = temp;
                // begin++;
                // end--;
            }
        }
    }

}
