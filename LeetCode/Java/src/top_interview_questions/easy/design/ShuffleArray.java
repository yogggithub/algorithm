package top_interview_questions.easy.design;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
    private int[] nums;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 77 ms @ (beats) 71.15%
         * Memory Usage: 47.8 MB @ (beats) 53.16%
         */
        Random random = new Random();
        int[] result = Arrays.copyOf(this.nums, this.nums.length);
        for (int i = 0; i < result.length; i++) {
            // generate a random index, then swap with current element
            int target = random.nextInt(i + 1);
            int temp = result[i];
            result[i] = result[target];
            result[target] = temp;
        }
        return result;
    }
}
