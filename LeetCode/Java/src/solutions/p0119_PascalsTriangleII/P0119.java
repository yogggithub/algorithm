package solutions.p0119_PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class P0119 {
    public List<Integer> getRow(int rowIndex) {
        /*
         * Solution v1: Recursive
         *
         * Runtime: 1 ms @ (beats) 78.21%
         * Memory Usage: 38.8 MB @ (beats) 6.88%
         */
        // List<Integer> ans = new ArrayList<>();
        // ans.add(1); // 1 as 0th element of every row
        // if (rowIndex == 0) {
        //     return ans;
        // }
        //
        // if (rowIndex == 1) {
        //     ans.add(1);
        //     return ans;
        // }
        //
        // List<Integer> prev = getRow(rowIndex - 1);
        // for (int i = 1; i < prev.size(); i++) {
        //     ans.add(prev.get(i - 1) + prev.get(i));
        // }
        // ans.add(1);
        // return ans;

        /*
         * Solution v2: Iterative and Array
         *
         * Runtime: 1 ms @ (beats) 78.21%
         * Memory Usage: 38.5 MB @ (beats) 19.64%
         */
        // have to increment rowIndex by 1, otherwise 0 row will throw exception
        // int[][] row = new int[rowIndex + 1][rowIndex + 1];
        // row[0][0] = 1;
        // for (int i = 1; i <= rowIndex; i++) {
        //     for (int j = 0; j <= rowIndex; j++) {
        //         // the first and last element
        //         if (j == 0 || j == i) {
        //             row[i][j] = 1;
        //         } else {
        //             row[i][j] = row[i - 1][j - 1] + row[i - 1][j];
        //         }
        //     }
        // }
        // List<Integer> ans = new ArrayList<>();
        // for (int num : row[rowIndex]) {
        //     ans.add(num);
        // }
        // return ans;

        /*
         * (learn from Internet)
         * Solution v3: Iterative and List
         */
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int size = ans.size();
            for (int j = 0; j < size - 1; j++) {
                int val = ans.get(j) + ans.get(j + 1);
                ans.set(j, val);
            }
            ans.set(size - 1, 1);
            ans.add(0, 1);
        }
        return ans;
    }
}
