package duplicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*
         * Solution v1: boolean array
         *
         * Runtime:  4 ms @ (beats) 90.89%
         * Memory Usage:  48.1 MB @ (beats) 62.03%
         */
        // boolean[] visited = new boolean[nums.length + 1];
        // for (int i = 0; i < nums.length; i++) {
        //     if (!visited[nums[i]]) {
        //         visited[nums[i]] = true;
        //     }
        // }
        // List<Integer> result = new ArrayList<>();
        // for (int i = 1; i < visited.length; i++) {
        //     if (!visited[i]) {
        //         result.add(i);
        //     }
        // }
        // return result;

        /*
         * Solution v2: Use index as indicator
         *
         * Runtime: 5 ms @ (beats) 81.82%
         * Memory Usage: 48.1 MB @ (beats) 71.65%
         */
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
        /*
         * Solution v1: boolean array
         *
         * Runtime:  ms @ (beats) %
         * Memory Usage:  MB @ (beats) %
         */
    }
}
