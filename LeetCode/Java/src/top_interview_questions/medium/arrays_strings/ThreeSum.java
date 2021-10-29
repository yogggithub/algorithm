package top_interview_questions.medium.arrays_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 17 ms @ (beats) 95.30%
         * Memory Usage: 43.4 MB @ (beats) 58.18%
         */

        // idea:
        // sum three number to 0, mean there should have both negative and positive
        // thus, could sort the given array, put negative to the front
        // then implement two pointers to find two-sum result
        Arrays.sort(nums);
        // if array contains all positive / negative numbers
        // it can not sum to 0
        // should include 0 because all 0 array is one particular test case
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            // once element greater than 0, ending loop
            if (nums[i] > 0) {
                return list;
            }
            // pass duplicate numbers
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // treat as a two sum problem
            int target = 0 - nums[i];
            // two pointers
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[l]);
                    result.add(nums[r]);
                    list.add(result);
                    // pass duplicate numbers
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    l++;
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    // when two sum less then target, move left pointer
                    // to increment the sum
                    l++;
                } else {
                    // when two sum less then target, move right pointer
                    // to decrement the sum
                    r--;
                }
            }
        }
        return list;
    }
}
