package top_interview_questions.easy.string;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num1 = -123;
        int num2 = 1534236469;

        System.out.println(solution.reverse(num1));
        System.out.println(solution.reverse(num2));
        System.out.println(Integer.MIN_VALUE);  // -2147483648
        System.out.println(Integer.MAX_VALUE);  // 2147483647


    }

    static class Solution {
        public int reverse(int x) {
            int result = 0;
            /*
             * Solution v1: bit by bit
             *
             * Wrong Answer
             * Cannot deal with big number that exceed integer bound
             */
            // if (x > Integer.MIN_VALUE && x < Integer.MAX_VALUE) {
            //     if (x > -10 && x < 10) {
            //         return x;
            //     } else {
            //         int temp = Math.abs(x);
            //         Stack<Integer> stack = new Stack<>();
            //         while (true) {
            //             if (temp != 0) {
            //                 stack.push(temp % 10);
            //                 temp /= 10;
            //             } else {
            //                 break;
            //             }
            //         }
            //         for (int i = 0; ; i++) {
            //             result += stack.pop() * Math.pow(10, i);
            //             if (stack.isEmpty()) {
            //                 break;
            //             }
            //         }
            //
            //         if (x < 0) {
            //             result = -result;
            //         }
            //     }
            // }


            /*
             * Solution v2.1: convert to a string
             *
             * Runtime: 13 ms @ (beats) 5.41%
             * Memory Usage: 37.4 MB @ (beats) 45.59%
             */

            // String nums = String.valueOf(x);
            // String newVal = "";
            //
            // for (int i = nums.length() - 1; i >= 0; i--) {
            //     if (nums.charAt(i) == '-') {
            //         newVal = nums.charAt(i) + newVal;
            //     } else {
            //         newVal += nums.charAt(i);
            //     }
            // }
            // try {
            //     result = Integer.parseInt(newVal);
            // } catch (NumberFormatException e) {
            //     return 0;
            // }

            /*
             * Solution v2.2: convert to a char array
             *
             * Runtime: 2 ms @ (beats) 51.86%
             * Memory Usage: 35.8 MB @ (beats) 92.57%
             */
            // char[] nums = String.valueOf(x).toCharArray();
            //
            // int i = 0, j = nums.length - 1;
            // while (i < j) {
            //     if (nums[i] == '-') {
            //         i++;
            //     } else {
            //         char temp = nums[i];
            //         nums[i++] = nums[j];
            //         nums[j--] = temp;
            //     }
            // }
            // try {
            //     result = Integer.parseInt(String.valueOf(nums));
            // } catch (NumberFormatException e) {
            //     return 0;
            // }
            // return result;

            /*
             * (learn from Internet)
             * Solution v3: bit by bit
             */
            int MIN_VALUE = Integer.MIN_VALUE / 10; // -214,748,364
            int sum = 0;
            int negatives = 1;

            // All to negative
            if (x >= 0) {
                negatives--;
                x = -x;
            }

            while (x < 0) {
                // get last bit
                int remainder = x % 10;

                if (sum < MIN_VALUE ||
                    (sum == MIN_VALUE && (negatives == 1 ? remainder < -8 : remainder < -7))) {
                    return 0;
                }

                // put the bit at the end
                sum = sum * 10 + remainder;
                // remove the last bit from x
                x = (x - remainder) / 10;
            }
            return negatives == 1 ? sum : -sum;
        }
    }

}
