package top_interview_questions.easy.string;

public class StringToInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "  42";
        String str2 = "-91283472332";
        String str3 = "4193 with words";
        String str4 = "-+12";
        String str5 = "+1";
        String str6 = "+-12";

        System.out.println(solution.myAtoi(str1));
        System.out.println(solution.myAtoi(str2));
        System.out.println(solution.myAtoi(str3));
        System.out.println(solution.myAtoi(str4));
        System.out.println(solution.myAtoi(str5));
        System.out.println(solution.myAtoi(str6));

    }

    static class Solution {
        public int myAtoi(String s) {
            /*
             * Solution v1: Multiple IF
             *
             * Runtime: 5 ms @ (beats) 25.99%
             * Memory Usage: 39.8 MB @ (beats) 24.62%
             */
            // int result = 0;
            // StringBuilder nums = new StringBuilder();
            // s = s.trim();
            // if (s.length() == 0) {
            //     return 0;
            // }
            // boolean positive = s.charAt(0) == '-';
            // for (int i = 0; i < s.length(); i++) {
            //     char c = s.charAt(i);
            //     if (i == 0) {
            //         if (!Character.isDigit(c)) {
            //             if (c != '-' && c != '+') {
            //                 return 0;
            //             }
            //         }
            //     } else if (!Character.isDigit(c)) {
            //         break;
            //     }
            //     nums.append(c);
            // }
            //
            // if (nums.length() == 1 &&
            //     (nums.charAt(0) == '-' || nums.charAt(0) == '+')) {
            //     return 0;
            // } else {
            //     try {
            //         result = Integer.parseInt(nums.toString());
            //     } catch (Exception e) {
            //         if (positive) {
            //             return Integer.MIN_VALUE;
            //         } else {
            //             return Integer.MAX_VALUE;
            //         }
            //     }
            // }
            // return result;

            /*
             * (learn from Internet)
             * Solution v2: Cascade
             *
             */
            int i = 0;  // an index using throughout
            int length = s.length();
            long result = 0;    // use a bigger datatype to simple boundary

            if (length == 0) {
                return 0;
            }

            //ignore beginning spaces
            while (i < length && s.charAt(i) == ' ') {
                i++;
            }
            // drop when empty string
            if (i >= length) {
                return 0;
            }
            //check string has + or - sign
            boolean isPositive = true;

            if (s.charAt(i) == '-') {
                isPositive = false;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }

            //igonring front zeros
            while (i < length && s.charAt(i) - '0' == 0) {
                i++;
            }

            if (i >= length) {
                return 0;
            }

            //substring the number
            int start = i;
            int end = i;

            while (i < length) {
                int num = s.charAt(i) - '0';
                if (num >= 0 && num <= 9) {
                    end = i + 1;
                    i++;
                    continue;
                }
                break;
            }

            if (end == start) {
                return 0;
            }

            if (end - start > 10) {
                return (isPositive) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = Long.parseLong(s.substring(start, end));

            if (isPositive) {
                return result >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
            } else {
                result *= -1;
                return result <= Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) result;
            }
        }
    }
}
