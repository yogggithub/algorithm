package top_interview_questions.easy.array;

public class ContainsDuplicate {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            /*
             * Solution v1.1: Brute Force
             * 19 / 20 test cases passed
             *
             * Time Limit Exceeded
             */
            // for (int i = 0; i < nums.length; i++) {
            //     for (int j = i + 1; j < nums.length; j++) {
            //         if (nums[i] == nums[j]) {
            //             return true;
            //         }
            //     }
            // }
            // return false;

            /*
             * Solution v1.2: Brute Force
             * 20 / 20 test cases passed
             *
             * Runtime: 3 ms @ (beats) 69.52%
             * Memory Usage: 64.2 MB @ (beats) 40.76%
             */
            // Arrays.sort(nums);
            // for (int i = 0; i < nums.length - 1; i++) {
            //     if (nums[i] == nums[i + 1]) {
            //         return true;
            //     }
            // }

            /*
             * Solution v2.1: HashSet
             * (HashSet doesnot allowed duplicate value)
             * 20 / 20 test cases passed
             *
             * Runtime: 16 ms @ (beats) 13.46%
             * Memory Usage: 54.1 MB @ (beats) 6.54%
             */
            // HashSet<Integer> hashSet = new HashSet<>();
            // for (int i = 0; i < nums.length; i++) {
            //     if (!hashSet.add(nums[i])) {
            //         return true;
            //     }
            // }

            /*
             * Solution v2.2: HashSet
             * (HashSet doesnot allowed duplicate value)
             * 20 / 20 test cases passed
             *
             * Runtime: 21 ms @ (beats) 13.46%
             * Memory Usage: 54.1 MB @ (beats) 9.84%
             */

            // HashSet<Integer> hashSet = new HashSet<>();
            // for (int i = 0; i < nums.length; i++) {
            //     // determine whether in set already before adding to set
            //     if (hashSet.contains(nums[i])) {
            //         return true;
            //     }
            //     hashSet.add(nums[i]);
            // }

            /*
             * (learn from Internet)
             * Solution v3: Boolean array
             */

            // 1st, find max and min of the array
            int max = nums[0];
            int min = nums[0];
            for (int i : nums) {
                if (max < i) {
                    max = i;
                }
                if (min > i) {
                    min = i;
                }
            }

            // 2nd, initiate a boolean array contains (max - min + 1) elements
            // the array will cover all possible value in given array
            // and all default value of boolean array will be false
            boolean arr[] = new boolean[max - min + 1];

            // 3rd, traversal given int array, use the number as index to fetch a boolean
            for (int i : nums) {
                // if the index (int number) has been visited, return true
                if (arr[i - min]) {
                    return true;
                }
                // if the index (int number) is first time to meet, change it to true
                arr[i - min] = true;
            }

            return false;

        }
    }
}

