package problems.p0043_MultiplyStrings;

public class P0043 {
    public String multiply(String num1, String num2) {
        /*
         * Solution v1: Vertical multiplication
         *
         * Runtime: 3 ms @ (beats) 93.24%
         * Memory Usage: 39.3 MB @ (beats) 48.38%
         */
        // idea:
        // take 56*78 as example:
        //      56
        //  *   78
        // ---------
        //      48
        //     40
        //     42
        //    35
        // ---------
        //    4368
        // calculate multiply by multiple every bit, start from right side
        // the position would appear at i+j, i+j+1 (start from 0 as normal)
        // the length of result can not exceed m+n (99*99 < 100*99 = 9900

        StringBuilder result = new StringBuilder();
        int m = num1.length(), n = num2.length();

        // an array to store every bit of multiple result
        int[] multiple = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            // convert single string number to int
            int x = (int) (num1.charAt(i) - '0');
            for (int j = n - 1; j >= 0; j--) {
                int y = (int) (num2.charAt(j) - '0');

                // pay attention to the position
                // i+j is leading bit than i+j+1

                // need to consider number already in array
                int sum = x * y + multiple[i + j + 1];
                multiple[i + j + 1] = sum % 10;
                // cause start from right
                // i+j must be first time to use
                multiple[i + j] += sum / 10;
            }
        }

        // skip any leading 0
        for (int num : multiple) {
            if (result.length() != 0 || num != 0) {
                result.append(num);
            }
        }
        // corner case
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }
}
