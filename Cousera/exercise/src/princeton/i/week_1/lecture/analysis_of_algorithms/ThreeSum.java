package princeton.i.week_1.lecture.analysis_of_algorithms;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{30, -40, -20, -10, 40, 0, 5};
        ThreeSum threeSum = new ThreeSum();
        Stopwatch sw = new Stopwatch();
        System.out.println(threeSum.bruteForce(arr) + "" + sw.elapsedTime());
        sw = new Stopwatch();
        System.out.println(threeSum.sortingBased(arr) + "" + sw.elapsedTime());
    }

    String bruteForce(int[] arr) {
        int count = 0;
        for (int i : arr) {
            for (int j : arr) {
                for (int k : arr) {
                    if (i + j + k == 0) {
                        count++;
                    }
                }
            }
        }
        return "count = " + count + " >>> ";
    }

    String sortingBased(int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        for (int i : arr) {
            for (int j : arr) {
                int k = -(i + j);
                if (Arrays.binarySearch(arr, k) != -1) {
                    count++;
                }
            }
        }
        return "count = " + count + " >>> ";
    }
}


