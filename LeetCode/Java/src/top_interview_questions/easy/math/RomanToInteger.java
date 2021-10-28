package top_interview_questions.easy.math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    /*
     * Solution v2: Use a map to store the values
     */
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public int romanToInt(String s) {

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 14 ms @ (beats) 17.60%
         * Memory Usage: 39.8 MB @ (beats) 54.64%
         */
        // int result = 0;
        // if (s.length() == 1) {
        //     return getValue(s);
        // }
        // while (s.length() >= 1) {
        //     int l = 0;
        //     String c1 = String.valueOf(s.charAt(l));
        //
        //     if (c1.equals("I") ||
        //         c1.equals("X") ||
        //         c1.equals("C")) {
        //
        //         if(s.length() > 1){
        //             String c2 = String.valueOf(s.charAt(l + 1));
        //             if ((c1 + c2).equals("IV") ||
        //                 (c1 + c2).equals("IX") ||
        //                 (c1 + c2).equals("XL") ||
        //                 (c1 + c2).equals("XC") ||
        //                 (c1 + c2).equals("CD") ||
        //                 (c1 + c2).equals("CM")) {
        //                 c1 += c2;
        //                 System.out.println(c1);
        //                 l++;
        //             }
        //         }
        //     }
        //     // System.out.println(c1);
        //     result += getValue(c1);
        //
        //     s = s.substring(l + 1, s.length());
        // }
        // return result;

        /*
         * (learn from Internet)
         * Solution v2: fetch a char once but compare with next char
         */
        // int sum = 0;
        // int i = 0;
        // while (i < s.length()) {
        //     String current = s.substring(i, i + 1);
        //     int currentVal = values.get(current);
        //     int nextVal = 0;
        //     if (i + 1 < s.length()) {
        //         String next = s.substring(i + 1, i + 2);
        //         nextVal = values.get(next);
        //     }
        //     // when next value is larger than current
        //     // the two chars should be dealt together
        //     if (currentVal < nextVal) {
        //         sum += (nextVal - currentVal);
        //         i += 2;
        //     } else {
        //         sum += currentVal;
        //         i += 1;
        //     }
        // }
        // return sum;

        /*
         * (learn from Internet)
         * Solution v3: backward
         */
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'D' || c == 'M') {
                result += (c == 'M' ? 1000 : 500);
                if (isNext(s, i - 1, 'C')) {
                    result -= 100;
                    i--;
                }
            }
            if (c == 'L' || c == 'C') {
                result += (c == 'C' ? 100 : 50);
                if (isNext(s, i - 1, 'X')) {
                    result -= 10;
                    i--;
                }
            }

            if (c == 'V' || c == 'X') {
                result += (c == 'X' ? 10 : 5);
                if (isNext(s, i - 1, 'I')) {
                    result--;
                    i--;
                }
            }
            if (c == 'I') {
                result++;
            }
        }
        return result;
    }

    private boolean isNext(String s, int index, char c) {
        if (index == s.length() || index == -1) {
            return false;
        }
        return s.charAt(index) == c;
    }

    /*
     * Solution v1: Brute Force
     */
    private int getValue(String s) {
        int result = 0;
        switch (s) {
            case "I":
                result = 1;
                break;
            case "V":
                result = 5;
                break;
            case "X":
                result = 10;
                break;
            case "IV":
                result = 4;
                break;
            case "IX":
                result = 9;
                break;
            case "L":
                result = 50;
                break;
            case "C":
                result = 100;
                break;
            case "XL":
                result = 40;
                break;
            case "XC":
                result = 90;
                break;
            case "D":
                result = 500;
                break;
            case "M":
                result = 1000;
                break;
            case "CD":
                result = 400;
                break;
            case "CM":
                result = 900;
                break;

        }
        return result;
    }
}
