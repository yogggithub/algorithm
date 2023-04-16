package solutions.p0946_ValidateStackSequences;

import java.util.Stack;

public class P0946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 4 ms @ (beats) 28.38%
         * Memory Usage: 42.3 MB @ (beats) 54.43%
         */
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (int p : pushed) {
            while (!stack.isEmpty() && stack.get(stack.size() - 1) == popped[i]) {
                stack.pop();
                i++;
            }
            stack.add(p);
        }

        while (!stack.isEmpty() && stack.get(stack.size() - 1) == popped[i]) {
            stack.pop();
            i++;
        }

        return stack.isEmpty();
    }
}
