package top_interview_questions.easy.array;

public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board1 = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] board2 = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(solution.isValidSudoku(board1));
        System.out.println(solution.isValidSudoku(board2));


    }

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            int n = board.length;
            /*
             * Solution v1: Brute Force
             *
             * Runtime: 2 ms @ (beats) 80.77%
             * Memory Usage: 43.2 MB @ (beats) 24.38%
             */

            // build 3 boolean arrays to indicate whether duplicate number or not
            boolean[][] row = new boolean[9][9];
            boolean[][] col = new boolean[9][9];
            boolean[][] cube = new boolean[9][9];

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (board[x][y] != '.') {

                        // convert char value to int index
                        // pay attention that index start from 0
                        int v = board[x][y] - '1';

                        // checking row
                        if (row[x][v]) {
                            return false;
                        } else {
                            row[x][v] = true;
                        }
                        // checking column
                        if (col[y][v]) {
                            return false;
                        } else {
                            col[y][v] = true;
                        }
                        // checking block cube
                        // locate to correct cube
                        int serial = 3 * (x / 3) + y / 3;
                        if (cube[serial][v]) {
                            return false;
                        } else {
                            cube[serial][v] = true;
                        }
                    }
                }
            }
            return true;
        }
    }
}
