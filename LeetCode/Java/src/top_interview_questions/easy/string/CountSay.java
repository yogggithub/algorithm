package top_interview_questions.easy.string;

public class CountSay {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n1 = 1;
        int n2 = 10;

        System.out.println(solution.countAndSay(n1));
        System.out.println(solution.countAndSay(n2));
        System.out.println(solution.countAndSay(n2).equals("13211311123113112211"));

    }

    static class Solution {
        public String countAndSay(int n) {

            // Base case: n = 1
            if (n == 1) {
                return "1";
            } else if (n == 2) {
                // additional base case
                // to reduce judgment in the loop
                return "11";
            } else {
                // get previous string
                String prev = countAndSay(n - 1);
                int length = prev.length();
                StringBuilder result = new StringBuilder();

                /*
                 * Solution v1: Two layers loop
                 *
                 * Runtime: 2 ms @ (beats) 84.18%
                 * Memory Usage: 36.2 MB @ (beats) 98.66%
                 */
                // for (int i = 0; i < length; ) {
                //     int n_i = prev.charAt(i) - '0';
                //     int count = 0;
                //     for (int j = i; j < length; j++) {
                //         int n_j = prev.charAt(j) - '0';
                //         if (n_j != n_i) {
                //             result.append(count).append(n_i);
                //             i = j;
                //             break;
                //         }
                //         count++;
                //         if (j >= length - 1) {
                //             result.append(count).append(n_i);
                //             return result.toString();
                //         }
                //     }

                /*
                 * (learn from Internet)
                 * Solution v1: Optimize IF
                 * just move one pointer, get accumulated by minus.
                 */
                int i = 0;

                while (i < length) {

                    char c = prev.charAt(i);
                    int j = i + 1;

                    // just move the poiner
                    while (j < prev.length() && prev.charAt(j) == c) {
                        j++;
                    }

                    result.append(j - i);   //
                    result.append(c);
                    i = j;
                }

                return result.toString();
            }
        }
    }
}
