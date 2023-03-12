package solutions.p0006_ZigzagConversion;

public class P0006 {
    public static void main(String[] args) {
        P0006 solution = new P0006();

        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(solution.convert(s, numRows));   // PAHNAPLSIIGYIR

        s = "PAYPALISHIRING";
        numRows = 4;
        System.out.println(solution.convert(s, numRows));   // PINALSIGYAHRPI

        s = "A";
        numRows = 1;
        System.out.println(solution.convert(s, numRows));   // A


    }

    public String convert(String s, int numRows) {

        /*
         * Solution v1: Z move
         *
         * Runtime: 10 ms @ (beats) 43.37%
         * Memory Usage: 43 MB @ (beats) 39.77%
         */

        // if (numRows == 1) {
        //     return s;
        // }
        //
        // String ans = "";
        //
        // String[] rows = new String[numRows];
        //
        // int r = 0;
        // int d = 1;
        // for (int i = 0; i < s.length(); i++) {
        //     if (rows[r] == null) {
        //         rows[r] = String.valueOf(s.charAt(i));
        //     } else {
        //         rows[r] += String.valueOf(s.charAt(i));
        //     }
        //
        //     if (r == numRows - 1) {
        //         d = -1;
        //     } else if (r == 0) {
        //         d = 1;
        //     }
        //
        //     r += d;
        // }
        //
        // for (String row : rows) {
        //     if (row != null) {
        //         ans += row;
        //     }
        // }
        // return ans;

        int l = s.length();
        if (l <= numRows || numRows == 1) {
            return s;
        }
        char[] chars = new char[l];
        int step = 2 * (numRows - 1);
        int count = 0;
        for (int i = 0; i < numRows; i++) {
            int interval = step - 2 * i;
            for (int j = i; j < l; j += step) {
                chars[count++] = s.charAt(j);
                if (interval < step && interval > 0
                    && j + interval < l && count < l) {
                    chars[count++] = s.charAt(j + interval);
                }

            }
        }
        return new String(chars);
    }
}
