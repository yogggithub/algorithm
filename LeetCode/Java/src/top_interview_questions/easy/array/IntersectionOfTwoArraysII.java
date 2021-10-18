package top_interview_questions.easy.array;

import java.util.Arrays;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution.intersect(nums1, nums2)));

        int[] nums3 = {1, 2, 2, 1}, nums4 = {2, 2};
        System.out.println(Arrays.toString(solution.intersect(nums3, nums4)));
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {

            /*
             * Solution v1: Brute Force
             *
             * Runtime: 24 ms @ (beats) 0%
             * Memory Usage: 40.9 MB @ (beats) 14.35%
             */
            // ArrayList<Integer> temp = new ArrayList<>();
            // ArrayList<Integer> n1 = new ArrayList<>();
            // Arrays.stream(nums1).forEach(n1::add);
            // ArrayList<Integer> n2 = new ArrayList<>();
            // Arrays.stream(nums2).forEach(n2::add);
            //
            // for (Integer i : n1) {
            //     int index = n2.indexOf(i);
            //     if (index != -1) {
            //         temp.add(i);
            //         n2.remove(index);
            //     }
            // }
            //
            // int[] result = new int[temp.size()];
            // for (int i = 0; i < temp.size(); i++) {
            //     result[i] = temp.get(i);
            // }


            /*
             * Solution v2.1: Two pointers (Stack)
             *
             * Runtime: 5 ms @ (beats) 32.92%
             * Memory Usage: 40.3 MB @ (beats) 41.70%
             */
            // Arrays.sort(nums1);
            // Arrays.sort(nums2);
            // Stack<Integer> stack = new Stack<>();
            // int i = 0, j = 0, n = 0;
            // while (i < nums1.length && j < nums2.length) {
            //     if (nums1[i] < nums2[j]) {
            //         i++;
            //         continue;
            //     } else if (nums1[i] > nums2[j]) {
            //         j++;
            //         continue;
            //     } else {
            //         stack.push(nums1[i]);
            //         i++;
            //         j++;
            //     }
            // }
            // int[] result = new int[stack.size()];
            // for (int k = 0; k < result.length; k++) {
            //     result[k] = stack.pop();
            // }

            /*
             * Solution v2.2: Two pointers (Arrays.copy)
             *
             * Runtime: 2 ms @ (beats) 93.42%
             * Memory Usage: 40.5 MB @ (beats) 33.53%
             */
            // Arrays.sort(nums1);
            // Arrays.sort(nums2);
            // int[] temp = new int[Math.min(nums1.length, nums2.length)];
            // int i = 0, j = 0, n = 0;
            // while (i < nums1.length && j < nums2.length) {
            //     if (nums1[i] < nums2[j]) {
            //         i++;
            //         continue;
            //     } else if (nums1[i] > nums2[j]) {
            //         j++;
            //         continue;
            //     } else {
            //         temp[n++] = nums1[i];
            //         i++;
            //         j++;
            //     }
            // }
            // int[] result = Arrays.copyOf(temp,n);


            /*
             * (learn from Internet)
             * Solution v3: visited array with element from given arrays as index, boolean as value
             */
            int[] visited = new int[1000];  // given condition: 0 <= nums1[i], nums2[i] <= 1000
            int resultsCount = 0;  // total number of intersection part

            // get length of the two given arrays
            int[] shorter, longer;
            if (nums1.length < nums2.length) {
                shorter = nums1;
                longer = nums2;
            } else {
                shorter = nums2;
                longer = nums1;
            }

            // intersection part can only up to smaller array's size
            // this array used to store the index of intersect elements
            boolean[] indicatorArray = new boolean[shorter.length];

            // for each element in larger array, increment visited[integer] by 1
            // means this index is in the larger array, and the value is how many times.
            for (int value : longer) {
                visited[value] += 1;
            }

            // transversal smaller array
            for (int i = 0; i < shorter.length; i++) {
                int value = shorter[i];
                if (visited[value] > 0) {
                    // mark this value as matched together
                    indicatorArray[i] = true;
                    // decrement, avoid duplicate count
                    visited[value] -= 1;
                    resultsCount++;
                }
            }

            int[] result = new int[resultsCount];
            int j = 0;
            for (int i = 0; i < indicatorArray.length; i++) {
                if (indicatorArray[i]) {
                    result[j++] = shorter[i];
                }
            }

            return result;
        }
    }
}
