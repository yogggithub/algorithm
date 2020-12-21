package princeton.i.week_3.lecture;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    // threshold for tiny array
    private static final int CUTOFF = 7;

    private int partition(Comparable[] a, int low, int high) {
        int i = low, j = high + 1;
        while (true) {
            while (less(a[++i], a[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(a[low], a[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, low, j);
        return j;
    }

    private void sort(Comparable[] a, int low, int high) {
        // for tiny array, stop recursive and use insertion sort
        if (high <= low + CUTOFF - 1) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (less(a[j], a[j - 1])) {
                        Comparable swap = a[j];
                        a[j] = a[j - 1];
                        a[j - 1] = swap;
                    } else {
                        break;
                    }
                }
            }
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public void threeWaySort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }

        int lt = low, gt = high;
        Comparable v = a[low];
        int i = low;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                // when smaller, exchange partition pointer
                // and small pointer, the increment both the pointers
                exchange(a, lt++, i++);
            } else if (cmp > 0) {
                // when greater, exchange small pointer
                // and large pointer, then only decrement large pointer
                // cause the small pointer element need to be compared
                exchange(a, i, gt--);
            } else {
                // when equal, only increment small pointer
                i++;
            }
        }
        sort(a, low, lt - 1);
        sort(a, gt + 1, high);
    }

    public Comparable selection(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int low = 0, high = a.length - 1;
        while (low < high) {
            int j = partition(a, low, high);
            if (j < k) {
                low = j + 1;
            } else if (j > k) {
                high = j - 1;
            } else {
                return a[k];
            }
        }
        return a[k];
    }

    private boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    private void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
