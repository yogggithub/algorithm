package solutions.p0067_AddBinary;

public class P0067 {
    public String addBinary(String a, String b) {
        /*
         * Solution v1: Use Integer class
         *
         * Can not deal large string
         */
        // int a_num = Integer.parseInt(a, 2);
        // int b_num = Integer.parseInt(b, 2);
        // return Integer.toBinaryString(a_num + b_num);

        /*
         * Solution v2.1: Brute Force
         *
         * Runtime: 9 ms @ (beats) 8.85%
         * Memory Usage: 39.7 MB @ (beats) 14.25%
         */
        // StringBuilder ans = new StringBuilder();
        //
        // String[] a_str = a.split("");
        // String[] b_str = b.split("");
        //
        // int i = a_str.length - 1, j = b_str.length - 1;
        // int carry = 0;
        // while (i >= 0 || j >= 0) {
        //     int sum = carry;
        //     if (i >= 0) {
        //         sum += Integer.parseInt(a_str[i]);
        //     }
        //     if (j >= 0) {
        //         sum += Integer.parseInt(b_str[j]);
        //     }
        //     carry = sum / 2;
        //     ans.insert(0, sum % 2);
        //     i--;
        //     j--;
        // }
        // if (carry != 0) {
        //     ans.insert(0, carry);
        // }
        // return ans.toString();

        /*
         * Solution v2.2: Optimize
         *
         * Runtime: 5 ms @ (beats) 25.46%
         * Memory Usage: 39.9 MB @ (beats) 12.28%
         */
        // StringBuilder ans = new StringBuilder();
        //
        // int i = a.length() - 1, j = b.length() - 1;
        // int carry = 0;
        // while (i >= 0 || j >= 0) {
        //     if (i >= 0) {
        //         carry += a.charAt(i--) - '0';
        //     }
        //     if (j >= 0) {
        //         carry += b.charAt(j--) - '0';
        //     }
        //     ans.insert(0, carry % 2);
        //     carry = carry / 2;
        // }
        // if (carry != 0) {
        //     ans.insert(0, carry);
        // }
        // return ans.toString();

        /*
         * Solution v1.3: Optimize
         *
         * Runtime: 1 ms @ (beats) 100%
         * Memory Usage: 39 MB @ (beats) 57.89%
         */
        StringBuilder ans = new StringBuilder();

        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            ans.append(carry % 2);
            carry = carry / 2;
        }
        if (carry != 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }
}
