package princeton.ii.week_3.lecture.string;

public class ThreeWays {
    private static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        // 3-way partitioning (using dth character)
        if (hi <= lo) {
            return;
        }
        int lt = lo, gt = hi;

        // to handle variable-length strings
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            // to handle variable-length strings
            int t = charAt(a[i], d);
            if (t < v) {
                exch(a, lt++, i++);
            } else if (t > v) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }

        sort(a, lo, lt - 1, d);

        // sort 3 subarrays recursively
        if (v >= 0) {
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, hi, d);
    }

    // Treat strings as if they had an extra char at end (smaller than any char)
    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
