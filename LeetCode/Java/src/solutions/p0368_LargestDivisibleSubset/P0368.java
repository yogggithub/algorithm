package solutions.p0368_LargestDivisibleSubset;

import java.util.*;

public class P0368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 17 ms @ (beats) 69.41%
         * Memory Usage: 39.2 MB @ (beats) 71.55%
         */
        // // small number absolutely can not divide a larger number
        // // thus, sort given array first.
        // Arrays.sort(nums);
        // // store the count of each element in nums
        // int[] count = new int[nums.length];
        // // store previous divisible element
        // int[] prev = new int[nums.length];
        //
        // // store the max count and corresponding num
        // int max_count = 0, max_pointer = 0;
        // // transversal the given array
        // for (int i = 0; i < nums.length; i++) {
        //     // initiate prev array
        //     prev[i] = -1;
        //     // for every element, search every before element that divisible
        //     for (int j = i - 1; j >= 0; j--) {
        //         // divisible and could increase the count
        //         // otherwise, ignore
        //         if (nums[i] % nums[j] == 0 && count[i] < count[j] + 1) {
        //             count[i] = count[j] + 1;
        //             prev[i] = j;
        //         }
        //
        //         if (count[i] > max_count) {
        //             max_count = count[i];
        //             max_pointer = i;
        //         }
        //     }
        // }
        //
        // // convert index to result list
        // List<Integer> result = new ArrayList<>();
        // while (max_pointer != -1) {
        //     result.add(nums[max_pointer]);
        //     max_pointer = prev[max_pointer];
        // }
        // return result;

        /*
         * Solution v2: Set to store all sub numbers
         *
         * Runtime: 66 ms @ (beats) 5.13%
         * Memory Usage: 39.9 MB @ (beats) 33.69%
         */
        Arrays.sort(nums);
        int max_count = 0, max_pointer = 0;
        Map<Integer, Set<Integer>> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> i_list = new HashSet<>();
            count.put(nums[i], i_list);
            for (int j = i - 1; j >= 0; j--) {
                Set<Integer> j_list = count.get(nums[j]);
                if (nums[i] % nums[j] == 0 && j_list.size() + 1 > i_list.size()) {
                    i_list.clear();
                    i_list.addAll(j_list);
                }
            }

            i_list.add(nums[i]);
            if (i_list.size() > max_count) {
                max_count = i_list.size();
                max_pointer = nums[i];
            }
        }

        return new ArrayList<>(count.get(max_pointer));
    }
}
