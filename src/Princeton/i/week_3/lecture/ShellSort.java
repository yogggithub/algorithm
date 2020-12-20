package princeton.i.week_3.lecture;


public class ShellSort {
    public void sort(Comparable[] a) {
        int length = a.length;
        int h = 1;
        // generate a set of h
        // there is no perfect h series
        while (h < length / 3) {
            h = 3 * h + 1;  // 1, 4, 13 ....
        }
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
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
