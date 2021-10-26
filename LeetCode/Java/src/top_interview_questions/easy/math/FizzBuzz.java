package top_interview_questions.easy.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 9 ms @ (beats) 11.98%
         * Memory Usage: 41 MB @ (beats) 48.88%
         */
        // for (int i = 1; i <= n; i++) {
        //     String str = "";
        //     if (i % 3 == 0) {
        //         str += "Fizz";
        //     }
        //     if (i % 5 == 0) {
        //         str += "Buzz";
        //     }
        //     if (i % 3 != 0 && i % 5 != 0) {
        //         str += i;
        //     }
        //     result.add(str);
        // }

        /*
         * (learn from Internet)
         * Solution v2: Optimized selection
         */
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
