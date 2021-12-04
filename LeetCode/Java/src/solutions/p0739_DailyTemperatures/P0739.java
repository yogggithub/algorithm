package solutions.p0739_DailyTemperatures;

import java.util.Stack;

public class P0739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 1144 ms @ (beats) 6.32%
         * Memory Usage: 49.3 MB @ (beats) 58.45%
         */
        // for (int i = 0; i < temperatures.length; i++) {
        //     for (int j = i + 1; j < temperatures.length; j++) {
        //         if (temperatures[j] > temperatures[i]) {
        //             result[i] = j - i;
        //             break;
        //         }
        //     }
        // }

        /*
         * Solution v2: Stack
         *
         * Runtime: ms @ (beats) %
         * Memory Usage: MB @ (beats) %
         */
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];
            while (!stack.isEmpty() && currTemp > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        /*
         * (learn from Internet)
         * Solution v3: Backward method
         */
        // int hottest = temperatures[temperatures.length-1];
        // for(int i = temperatures.length-1; i>=0; i--){
        //     if(hottest <= temperatures[i]){
        //         hottest = temperatures[i];
        //         continue;
        //     }
        //     int days = 1;
        //
        //     // iterate through answers to find the when the next hottest day was found
        //     while(temperatures[i] >= temperatures[i + days]){
        //         days = days + result[i + days];
        //
        //     }
        //     result[i] = days;
        // }


        return result;
    }
}
