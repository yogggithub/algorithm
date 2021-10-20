package top_interview_questions.easy.array;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] matrix3 = {{1}};

        solution.rotate(matrix1);
        solution.rotate(matrix2);
        solution.rotate(matrix3);
        for (int[] ints : matrix1) {
            System.out.print(Arrays.toString(ints));

        }
        System.out.println();
        for (int[] ints : matrix2) {
            System.out.print(Arrays.toString(ints));

        }
        System.out.println();
        for (int[] ints : matrix3) {
            System.out.print(Arrays.toString(ints));

        }
        System.out.println();
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            // rhythm: A[x][y] => A[y][n-1-x]

            int n = matrix.length;
            /*
             * Solution v1: Auxiliary array
             *
             * Runtime: 0 ms @ (beats) 0%
             * Memory Usage: 39.1 MB @ (beats) 61.24%
             */

            // int[] temp = new int[n * n];
            // if (n != 1) {
            //     for (int x = 0; x < n; x++) {
            //         for (int y = 0; y < n; y++) {
            //             temp[x * n + y] = matrix[x][y];
            //         }
            //     }
            //     for (int x = 0; x < n; x++) {
            //         for (int y = 0; y < n; y++) {
            //             matrix[y][n - 1 - x] = temp[x * n + y];
            //         }
            //     }
            // }


            /*
             * (learn from Internet)
             * Solution v2: Two exchange
             *
             */

            if (n != 1) {
                // 1st: rotate row to col
                for (int x = 0; x < n; x++) {
                    for (int y = x; y < n; y++) {
                        int temp = matrix[x][y];
                        matrix[x][y] = matrix[y][x];
                        matrix[y][x] = temp;
                    }
                }
                // 2nd: exchange y-axis
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n / 2; y++) {
                        int temp = matrix[x][y];
                        matrix[x][y] = matrix[x][n - 1 - y];
                        matrix[x][n - 1 - y] = temp;
                    }
                }
            }

        }
    }
}
