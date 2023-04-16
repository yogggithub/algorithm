package solutions.p0071_SimplifyPath;

import java.util.Stack;

public class P0071 {
    public String simplifyPath(String path) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 4 ms @ (beats) 85.61%
         * Memory Usage: 42.8 MB @ (beats) 32.17%
         */
        Stack<String> stack = new Stack<>();

        String[] chars = path.split("/");

        for (String s : chars) {
            switch (s) {
                case ".":
                case "":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.add(s);
            }
        }
        StringBuilder ans = new StringBuilder();

        for (String s : stack) {
            ans.append("/");
            ans.append(s);
        }

        return ans.length() == 0 ? "/" : ans.toString();
    }
}
