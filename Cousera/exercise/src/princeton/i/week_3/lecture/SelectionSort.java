package princeton.i.week_3.lecture;

/**
 * This is including in week 2
 */
public class SelectionSort {
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[i], a[min])) {
                    min = i;
                }
                exchange(a, i, min);
            }
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
