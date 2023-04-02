package solutions.p0013_RomantoInteger;

public class P0013 {
    public int romanToInt(String s) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 8 ms @ (beats) 18.73%
         * Memory Usage: 43.4 MB @ (beats) 12.70%
         */
        // int ans = 0;
        //
        // Map<String, Integer> val = new HashMap<>();
        // val.put("I", 1);
        // // val.put("IV", 4);
        // val.put("V", 5);
        // // val.put("IX", 9);
        // val.put("X", 10);
        // // val.put("XL", 40);
        // val.put("L", 50);
        // // val.put("XC", 90);
        // val.put("C", 100);
        // // val.put("CD", 400);
        // val.put("D", 500);
        // // val.put("CM", 900);
        // val.put("M", 1000);
        //
        //
        // for (int i = 0; i < s.length() - 1; i++) {
        //     String curr = String.valueOf(s.charAt(i));
        //     String next = String.valueOf(s.charAt(i + 1));
        //
        //     if (val.get(curr) < val.get(next)) {
        //         ans -= val.get(curr);
        //     } else {
        //         ans += val.get(curr);
        //     }
        // }
        // ans += val.get(s.substring(s.length() - 1));
        // return ans;

        /*
         * Solution v1.1: Brute Force
         * Performance Enhance
         *
         * Runtime: 4 ms @ (beats) 87.58%
         * Memory Usage: 42.8 MB @ (beats) 52.88%
         */

        int ans = 0;
        int curr = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            prev = curr;

            switch (s.charAt(i)) {
                case 'I':
                    curr = 1;
                    break;
                case 'V':
                    curr = 5;
                    break;
                case 'X':
                    curr = 10;
                    break;
                case 'L':
                    curr = 50;
                    break;
                case 'C':
                    curr = 100;
                    break;
                case 'D':
                    curr = 500;
                    break;
                case 'M':
                    curr = 1000;
                    break;
            }

            if (curr < prev) {
                ans -= curr;
            } else {
                ans += curr;
            }
        }
        return ans;
    }
}
