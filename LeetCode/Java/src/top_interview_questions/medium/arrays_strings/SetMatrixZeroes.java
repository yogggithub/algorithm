package top_interview_questions.medium.arrays_strings;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 1 ms @ (beats) 96.07%
         * Memory Usage: 40.8 MB @ (beats) 54.46%
         */
        // int r = matrix.length;
        // int c = matrix[0].length;
        //
        // boolean[] row = new boolean[r];
        // boolean[] col = new boolean[c];
        //
        //
        // for (int i = 0; i < r; i++) {
        //     for (int j = 0; j < c; j++) {
        //         if (matrix[i][j] == 0) {
        //             row[i] = true;
        //             col[j] = true;
        //         }
        //     }
        // }
        // for (int i = 0; i < r; i++) {
        //     for (int j = 0; j < c; j++) {
        //         if (row[i] || col[j]) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }


        /*
         * (learn from Internet)
         * Solution v2:
         */
        int m = matrix.length, n = matrix[0].length;
        int z = Math.max(m, n);

        // a array has z array-elements
        // each array has 2 cell, 1st->row, 2nd->col
        int[][] check = new int[z][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    check[i][0] = 1;
                    check[j][1] = 1;
                }
            }
        }

        for (int i = 0; i < z; i++) {
            if (check[i][0] == 1) {
                for (int k = 0; k < n; k++) {
                    matrix[i][k] = 0;
                }
            }
            if (check[i][1] == 1) {
                for (int k = 0; k < m; k++) {
                    matrix[k][i] = 0;
                }
            }
        }
    }
}