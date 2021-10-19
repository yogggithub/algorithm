package top_interview_questions.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {2, 7, 11, 15}, nums2 = {-1, -2, -3, -4, -5}, nums3 = {3, 3};
        System.out.println(Arrays.toString(solution.twoSum(nums1, 9)));
        System.out.println(Arrays.toString(solution.twoSum(nums2, -8)));
        System.out.println(Arrays.toString(solution.twoSum(nums3, 6)));

    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {

            int[] result = new int[2];

            /*
             * Solution v1: Two pointers
             *
             * Runtime: 102 ms @ (beats) 9.80%
             * Memory Usage: 42.1 MB @ (beats) 26.81%
             */

            // int i = 0, j = 1;
            //
            // while (i < nums.length - 1) {
            //     if (j < nums.length) {
            //         if (nums[j] == target - nums[i]) {
            //             result[0] = i;
            //             result[1] = j;
            //             break;
            //         }
            //         j++;
            //         continue;
            //     }
            //     i++;
            //     j = i + 1;
            // }

            /*
             * Solution v2: Auxiliary data structure
             *
             * Runtime: 690 ms @ (beats) 0%
             * Memory Usage: 43.1 MB @ (beats) 6.71%
             */
            // List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            //
            // for (int i = 0; i < nums.length; i++) {
            //     int j = list.indexOf(target - nums[i]);
            //     if (j != -1) {
            //         result[1] = i;
            //         result[0] = j;
            //         break;
            //     }
            // }
            // return result;

            /*
             * Solution v3: Auxiliary data structure
             *
             * Runtime: 690 ms @ (beats) 0%
             * Memory Usage: 43.1 MB @ (beats) 6.71%
             */

            Map<Integer, Integer> num_map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (num_map.containsKey(complement)) {
                    return new int[]{num_map.get(complement), i};
                }
                num_map.put(nums[i], i);
            }
            throw new IllegalArgumentException("no match found");
        }
    }

}
