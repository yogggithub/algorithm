package problems.p0009_PalindromeNumber;

public class P0009 {
    public boolean isPalindrome(int x) {
        /*
         * Solution v1: Convert to String
         *
         * Runtime: 7 ms @ (beats) 75.35%
         * Memory Usage: 38.4 MB @ (beats) 66.08%
         */
        // String str = String.valueOf(x);
        // int left = 0, right = str.length() - 1;
        // while (left < right) {
        //     if (str.charAt(left) != str.charAt(right)) {
        //         return false;
        //     }
        //     left++;
        //     right--;
        // }
        // return true;

        /*
         * Solution v2: Donot convert
         *
         * Runtime: 6 ms @ (beats) 99.98%
         * Memory Usage: 38.4 MB @ (beats) 76.21%
         */
        if (x < 0) {
            return false;
        }
        int p = 0, c = x;
        while (c > 0) {
            p = p * 10 + c % 10;
            c /= 10;
        }
        return p == x;
    }
}
