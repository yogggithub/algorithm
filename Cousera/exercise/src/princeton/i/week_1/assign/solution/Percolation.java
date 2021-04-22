package princeton.i.week_1.assign.solution;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private final int N;
    private int openSites;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF backWash;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        N = n;
        openSites = 0;
        grid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
        uf = new WeightedQuickUnionUF(n * n + 2);
        backWash = new WeightedQuickUnionUF(n * n + 2);
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        valid(row, col);
        if (!grid[row - 1][col - 1]) {
            grid[row - 1][col - 1] = true;
            openSites++;
            int id = getId(row, col);
            if (row == 1) {
                uf.union(id, 0);
                backWash.union(id, 0);
            }

            if (row > 1 && grid[row - 2][col - 1]) {
                uf.union(id, id - N);
                backWash.union(id, id - N);
            }

            if (row < N && grid[row][col - 1]) {
                uf.union(id, id + N);
                backWash.union(id, id + N);
            }

            if (col > 1 && grid[row - 1][col - 2]) {
                uf.union(id, id - 1);
                backWash.union(id, id - 1);
            }

            if (col < N && grid[row - 1][col]) {
                uf.union(id, id + 1);
                backWash.union(id, id + 1);
            }

            if (row == N) {
                uf.union(id, N * N + 1);
            }
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        valid(row, col);
        return grid[row - 1][col - 1];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        valid(row, col);
        int id = getId(row, col);
        return backWash.find(id) == backWash.find(0);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(N * N + 1) == uf.find(0);
    }

    private void valid(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > N) {
            throw new IllegalArgumentException();
        }
    }

    private int getId(int row, int col) {
        return (row - 1) * N + col;
    }
}
