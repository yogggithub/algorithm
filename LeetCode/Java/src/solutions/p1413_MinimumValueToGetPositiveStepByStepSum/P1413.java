package solutions.p1413_MinimumValueToGetPositiveStepByStepSum;

public class P1413 {
    public int minStartValue(int[] nums) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 36.5 MB @ (beats) 51.66%
         */
        int sum = 0, minimum = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            minimum = Math.min(sum, minimum);
        }
        // Minimum start value should be positive.
        return minimum < 1 ? Math.abs(minimum) + 1 : 1;
    }
}
