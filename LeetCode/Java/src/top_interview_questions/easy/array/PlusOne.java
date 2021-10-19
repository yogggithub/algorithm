package top_interview_questions.easy.array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, nums2 = {6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3}, nums3 = {9, 9};
        System.out.println(Arrays.toString(solution.plusOne(nums1)));
        System.out.println(Arrays.toString(solution.plusOne(nums2)));
        System.out.println(Arrays.toString(solution.plusOne(nums3)));

    }

    static class Solution {
        public int[] plusOne(int[] digits) {

            /*
             * Solution v1.1: Brute Force
             *
             * Runtime: 1 ms @ (beats) 15.97%
             * Memory Usage: 39.9 MB @ (beats) 11.50%
             */
            // int surplus = 0;
            // ArrayList<Integer> numbers = new ArrayList<>();
            // for (int i = digits.length - 1; i >= 0; i--) {
            //     if (i == digits.length - 1) {
            //         if (digits[i] == 9) {
            //             surplus = 1;
            //             numbers.add(0);
            //         } else {
            //             numbers.add(digits[i] + 1);
            //         }
            //     } else {
            //         if (surplus == 1) {
            //             if (digits[i] == 9) {
            //                 numbers.add(0);
            //             } else {
            //                 numbers.add(digits[i] + 1);
            //                 surplus = 0;
            //             }
            //         } else {
            //             numbers.add(digits[i]);
            //         }
            //     }
            //     if (i == 0 && surplus == 1) {
            //         numbers.add(1);
            //         surplus = 0;
            //     }
            // }
            //
            // int[] result = new int[numbers.size()];
            // for (int i = 0; i < result.length; i++) {
            //     result[i] = numbers.get(numbers.size() - 1 - i);
            // }
            // return result;

            /*
             * Solution v1.2: Brute Force (In-place)
             *
             * Runtime: 1 ms @ (beats) 15.97%
             * Memory Usage: 39.4 MB @ (beats) 11.50%
             */
            // int surplus = 0;
            // for (int i = digits.length - 1; i >= 0; i--) {
            //     if (i == digits.length - 1) {
            //         if (digits[i] == 9) {
            //             surplus = 1;
            //             digits[i] = 0;
            //         } else {
            //            digits[i] += 1;
            //         }
            //     } else {
            //         if (surplus == 1) {
            //             if (digits[i] == 9) {
            //                 digits[i] = 0;
            //             } else {
            //                 digits[i] += 1;
            //                 surplus = 0;
            //             }
            //         }
            //     }
            // }
            //
            // if (surplus == 1) {
            //     int[] result = new int[digits.length + 1];
            //     result[0] = 1;
            //     surplus = 0;
            //     for (int i = 0; i < digits.length; i++) {
            //         result[i + 1] = digits[i];
            //     }
            //     return result;
            // } else {
            //     return digits;
            // }


            /*
             * Solution v2: Brute Force (In-place)
             *
             * Runtime: 1 ms @ (beats) 15.97%
             * Memory Usage: 39.4 MB @ (beats) 11.50%
             */

            /*
             * (learn from Internet)
             * Solution v2: Clearer and more concise logic
             */
            // // Base Conditions.
            // if (digits.length == 0) {
            //     return digits;
            // }
            // if (digits[0] == 0) {
            //     return new int[]{1};
            // }
            //
            // // Perform Addition.
            // int index = digits.length - 1;
            // int carry = 1;
            // while (index > -1) {
            //     if (carry == 1 && digits[index] + 1 == 10) {
            //         digits[index] = 0;
            //         carry = 1;
            //     } else {
            //         digits[index] = digits[index] + carry;
            //         carry = 0;
            //     }
            //     index--;
            // }
            //
            // // all 9's case
            // if (digits[0] == 0) {
            //     int[] longDigits = new int[digits.length + 1];
            //     longDigits[0] = 1;
            //     return longDigits;
            // }
            // return digits;

            /*
             * (learn from Internet)
             * Solution v3: addition method
             */
            if (digits == null || digits.length == 0) {
                return new int[]{1};
            }

            int digit = 0;
            int i = digits.length - 1;
            int[] result = new int[digits.length];
            while (i >= 0) {
                if (i == digits.length - 1) {
                    int sum = digits[i] + 1;
                    result[i] = sum % 10;
                    digit = sum / 10;
                    i--;
                } else {
                    int sum = digits[i] + digit;
                    result[i] = sum % 10;
                    digit = sum / 10;
                    i--;
                }
            }

            int[] newResult = new int[digits.length + 1];
            if (digit != 0) {
                newResult[0] = digit;
                for (int j = 1; j <= digits.length; j++) {
                    newResult[j] = result[j - 1];
                }
                return newResult;
            }
            return result;
        }
    }
}
