package top_interview_questions.easy.other;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        /*
         * Solution v1: Recursive
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 37.2 MB @ (beats) 49.57%
         */
        List<List<Integer>> result = new ArrayList<>();
        // base case: first row
        List<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);
        if (numRows == 1) {
            return result;
        } else if (numRows == 2) {
            // 2nd row is {1, 1}
            List<Integer> row2 = new ArrayList<>();
            row2.add(1);
            row2.add(1);
            result.add(row2);
        } else if (numRows == 3) {
            result = generate(numRows - 1);
            // 3rd row is {1, 2, 1}
            List<Integer> row3 = new ArrayList<>();
            row3.add(1);
            row3.add(2);
            row3.add(1);
            result.add(row3);
        } else {
            // generate triangle with n-1 rows
            result = generate(numRows - 1);

            // add new row
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);  // 1st element for any row is 1
            for (int i = 1; i < numRows - 1; i++) {
                newRow.add(result.get(numRows - 1 - 1).get(i - 1)
                           + result.get(numRows - 1 - 1).get(i));
            }
            newRow.add(1);  // last element for any row is 1
            result.add(newRow);
        }

        return result;
    }
}
