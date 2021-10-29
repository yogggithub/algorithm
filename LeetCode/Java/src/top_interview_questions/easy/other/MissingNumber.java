package top_interview_questions.easy.other;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 916 ms @ (beats) 0%
         * Memory Usage: 40.4 MB @ (beats) 47.34%
         */
        // ArrayList<Integer> list = new ArrayList<>();
        // for (int i = 1; i < nums.length; i++) {
        //     list.add(i);
        // }
        //
        // for (int i : nums) {
        //     list.remove(list.indexOf(i));
        // }
        // System.out.println(list.toString());
        // return list.get(0);

        /*
         * Solution v2: sum up then substract
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 39.6 MB @ (beats) 52.82%
         */

        // idea:
        // calculate sum, the subtract nums, difference is missing number
        // based on given condition: every number is unique

        // get sum of all numbers
        // int sum = (1 + nums.length) * nums.length / 2;
        // for (int num : nums) {
        //     sum -= num;
        // }
        // return sum;

        /*
         * (learn from Internet)
         * Solution v3: bit operation
         */
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n = n ^ i ^ nums[i];
        }
        return n;
    }
}
