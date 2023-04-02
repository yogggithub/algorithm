package solutions.p0022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class P0022 {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 1 ms @ (beats) 92.80%
         * Memory Usage: 42.4 MB @ (beats) 70.10%
         */
        this.ans = new ArrayList<String>();
        builder(0, 0, n, "");
        return this.ans;
    }

    public void builder(int left, int right, int n, String curr) {
        if (curr.length() == n * 2) {
            this.ans.add(curr);
        }

        if (left < n) {
            this.builder(left + 1, right, n, curr.concat("("));
        }

        if (left > right) {
            this.builder(left, right + 1, n, curr.concat(")"));
        }

    }

}
