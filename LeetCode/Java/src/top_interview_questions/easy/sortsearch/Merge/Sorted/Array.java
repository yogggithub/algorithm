package top_interview_questions.easy.sortsearch.Merge.Sorted;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);

        int[] nums3 = new int[1];
        int[] nums4 = {1};
        solution.merge(nums3, 0, nums4, 1);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums3));


    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            /*
             * Solution v1: Brute Force
             *
             * Runtime: 0 ms @ (beats) 100%
             * Memory Usage: 39.4 MB @ (beats) 44.79%
             */
            if (m == 0) {
                for (int i = 0; i < n; i++) {
                    nums1[i] = nums2[i];
                }
                return;
            }
            if (n == 0) {
                return;
            }
            int length = m + n;
            for (int i = length - 1; i >= 0; i--) {
                if (nums1[m - 1] >= nums2[n - 1]) {
                    nums1[i] = nums1[m - 1];
                    // change to the minimum value indicate already visited.
                    nums1[m - 1] = Integer.MIN_VALUE;
                    m--;

                } else {
                    nums1[i] = nums2[n - 1];
                    n--;

                }

                // when reach the head of nums1
                // copy all left in nums1 into result array
                if (m < 1) {
                    for (int j = 0; j < n; j++) {
                        nums1[j] = nums2[j];
                    }
                    return;
                }

                // when nums2 is all added into nums1
                // stop program
                if (n < 1) {
                    return;
                }
            }

        }
    }
}
