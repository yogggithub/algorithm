package princeton.i.week_4.assign;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private final int[][] grid;
    private final int n;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles == null
            || tiles.length < 2
            || tiles.length > 128) {
            throw new IllegalArgumentException();
        }
        n = tiles.length;
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = Arrays.copyOf(tiles[i], n);
        }
    }

    // string representation of this board
    public String toString() {
        StringBuilder output;
        output = new StringBuilder(n + "\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                output.append(" ")
                      .append(grid[i][j])
                      .append(" ");
            }
            output.append("\n");
        }
        return output.toString();
    }

    // board dimension n
    public int dimension() {
        int dimension = this.n;
        return dimension;
    }

    // number of tiles out of place
    public int hamming() {
        int distance = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] != i * n + j + 1
                    && grid[i][j] != 0) {
                    distance++;
                }
            }
        }
        return distance;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int distance = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] != i * n + j + 1
                    && grid[i][j] != 0) {
                    int row = grid[i][j] / n;
                    // 0 must locate at the end
                    // mean every int should be one pos front
                    int col = grid[i][j] % n - 1;
                    // when col is -1
                    // the element should be at the last of above row
                    if (col < 0) {
                        col += n;
                        row -= 1;
                    }
                    distance += Math.abs(i - row)
                                + Math.abs(j - col);
                }
            }
        }
        return distance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == null) {
            return false;
        }
        if (y == this) {
            return true;
        }
        if (y.getClass() != this.getClass()) {
            return false;
        }

        Board that = (Board) y;
        return Arrays.deepEquals(this.grid, that.grid);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        ArrayList<Board> neighbors = new ArrayList<>();
        int row = 0, col = 0;

        // find initial position, i.e. 0 block
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;
                }
            }
        }
        // up
        if (row > 0) {
            int[][] copy = copyGrid();
            copy[row][col] = copy[row - 1][col];
            copy[row - 1][col] = 0;
            neighbors.add(new Board(copy));
        }

        // down
        if (row < n - 1) {
            int[][] copy = copyGrid();
            copy[row][col] = copy[row + 1][col];
            copy[row + 1][col] = 0;
            neighbors.add(new Board(copy));
        }

        // left
        if (col > 0) {
            int[][] copy = copyGrid();
            copy[row][col] = copy[row][col - 1];
            copy[row][col - 1] = 0;
            neighbors.add(new Board(copy));
        }

        // right
        if (col < n - 1) {
            int[][] copy = copyGrid();
            copy[row][col] = copy[row][col + 1];
            copy[row][col + 1] = 0;
            neighbors.add(new Board(copy));
        }

        return neighbors;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int[][] copy = copyGrid();
        if (grid[0][0] != 0 && grid[0][1] != 0) {
            copy[0][0] = grid[0][1];
            copy[0][1] = grid[0][0];
        } else {
            copy[1][0] = grid[1][1];
            copy[1][1] = grid[1][0];
        }
        return new Board(copy);
    }

    private int[][] copyGrid() {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(this.grid[i], n);
        }
        return copy;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        /* unit testing (not graded) */
    }
}
