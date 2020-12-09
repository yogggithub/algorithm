package Princeton.i.week_1.assign;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    // the grid, use boolean to represent the status
    private final boolean[][] grid;
    private final int val;
    private int openSites;
    private final WeightedQuickUnionUF uf, backWash;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        openSites = 0;
        if (n < 0) {
            throw new IllegalArgumentException();
        } else {
            val = n;
            // requirement simpled the grid from [1,1] to [n,n]
            // i.e. the row 0 and the column 0 are not used in this assignment
            grid = new boolean[val + 1][val + 1];

            // boolean array default filled by false, so no need to assign value
            // for (boolean[] booleans : grid) {
            //     for (boolean b : booleans) {
            //         b = false;
            //     }
            // }

            // initialized the UnionFind with total id = N * N + 2
            // there are virtual beginning and end point, respectively 0 and N * N + 1
            uf = new WeightedQuickUnionUF(val * val + 2);
            backWash = new WeightedQuickUnionUF(val * val + 2);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        // in uf array, actual row is one less
        int id = (row - 1) * val + col;
        if (!grid[row][col]) {
            grid[row][col] = true;
            openSites++;
            // link row 1 to the beginning point
            // means connected to outside
            if (row == 1) {
                uf.union(id, 0);
                backWash.union(id, 0);
            }
            // link row N to the end point
            // means connected to outside
            if (row == val) {
                uf.union(id, val * val + 1);
                backWash.union(id, val * val + 1);
            }
            // link to surround OPEN sites
            if (row > 1 && grid[row - 1][col]) {  // UP site
                uf.union(id, id - val);
                backWash.union(id, id - val);
            }
            if (row < val && grid[row + 1][col]) {  // DOWN site
                uf.union(id, id + val);
                backWash.union(id, id + val);
            }
            if (col > 1 && grid[row][col - 1]) {  // LEFT site
                uf.union(id, id - 1);
                backWash.union(id, id - 1);
            }
            if (col < val && grid[row][col + 1]) {  // RIGHT site
                uf.union(id, id + 1);
                backWash.union(id, id + 1);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        return grid[row][col] &&
               backWash.find((row - 1) * val + col) == backWash.find(0);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        // if beginning & end pointing connect to each other
        // the grid is percolated
        return uf.find(val * val + 1) == uf.find(0);
    }

    // validate that position (row, col) is a valid site
    private void validate(int row, int col) {
        if (row < 1 || row > (val + 1) || col < 1 || col > (val + 1)) {
            throw new IllegalArgumentException("position (" + row + ", " + col + ") is out of grid");
        }
    }

    // test client (optional)
    public static void main(String[] args) {
        // no need to test
    }
}
