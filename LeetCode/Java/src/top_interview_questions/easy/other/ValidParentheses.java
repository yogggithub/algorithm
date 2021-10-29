package top_interview_questions.easy.other;

public class ValidParentheses {
    public boolean isValid(String s) {

        // odd length string must be invalid
        if (s.length() % 2 != 0) {
            return false;
        }

        /*
         * Solution v1: Stack
         *
         * Runtime: ms @ (beats) %
         * Memory Usage: MB @ (beats) %
         */
        // Stack<Character> stack = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //
        //     // if char is left side of parentheses
        //     // add right side into stack
        //     if (c == '(') {
        //         stack.push(')');
        //     } else if (c == '[') {
        //         stack.push(']');
        //     } else if (c == '{') {
        //         stack.push('}');
        //         // if char is right side
        //         // it must match the first parentheses in stack
        //         // stack may be empty, it is also a failure
        //     } else if (stack.size() == 0 || c != stack.pop()) {
        //         return false;
        //     }
        // }
        // // after transversal, if stack is not empty
        // // means there is some parentheses not closed
        // if (stack.size() != 0) {
        //     return false;
        // }
        // return true;

        /*
         * (learn from Internet)
         * Solution v2: Use array instead of Stack to speed up
         */
        char[] stack = new char[s.length() + 1];
        int top = 1;    // assign as 1 to avoid first element is right side
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if char is left side, put it into array
            // move pointer to right
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
                // if char is right side, check its type
                // pointer must move left back because it is one step forward
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }

        // pointer must be original value
        // otherwise there still un-closing parentheses
        return top == 1;
    }
}
