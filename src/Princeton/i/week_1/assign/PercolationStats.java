package Princeton.i.week_1.assign;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double mean;
    private final double stdDev;
    private final double halfInterval;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        validate(n, trials);
        double[] result = new double[trials];
        int row, col;
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                row = StdRandom.uniform(1, n + 1);
                col = StdRandom.uniform(1, n + 1);
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                }
            }
            result[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
        mean = StdStats.mean(result);
        stdDev = StdStats.stddev(result);
        halfInterval = 1.96 * stdDev / Math.sqrt(trials);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stdDev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - halfInterval;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + halfInterval;
    }

    // validate that n & T is a valid input
    private void validate(int n, int trials) {
        if (n < 0 || trials < 0) {
            throw new IllegalArgumentException("invalid argument");
        }
    }

    private void display() {
        StdOut.printf("mean%20s= %f\n", " ", mean());
        StdOut.printf("stddev%18s= %f\n", " ", stddev());
        StdOut.printf("95%% confidence interval = [%f, %f]", confidenceLo(), confidenceHi());
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, trials);
        // PercolationStats ps = new PercolationStats(300, 100);
        ps.display();
    }
}
