package princeton.i.week_3.lecture;

public class MergerSort {
    private Comparable[] aux;

    // threshold for tiny array
    private static final int CUTOFF = 7;

    public void merge(Comparable[] a, Comparable[] aux,
                      int low, int mid, int high) {
        // assert isSorted(a, low, mid);
        // assert isSorted(a, mid + 1, high);

        // copy a to aux
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        // pointer: i indicate first half, j indicate second half
        int i = low, j = mid + 1;
        for (int k = 0; k <= high; k++) {
            if (i > mid) {  // first half is exhausted
                // put all rest element in second half
                a[k] = aux[j++];
            } else if (j > high) {  // second half is exhausted
                // put all rest element in first half
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                // if element in second half is less than first half
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

        // assert isSorted(a, low, high);
    }

    private void sort(Comparable[] a, Comparable[] aux, int low, int high) {
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
        int mid = low + (high - low) / 2;
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);

        // when the first element of second half is larger
        // than the last element of first half,
        // directly concat two half
        if (!less(a[mid + 1], a[mid])) {
            return;
        }

        merge(a, aux, low, mid, high);
    }

    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    /**
     * bottom up version of merger sort
     * no recursive
     *
     * @param a
     */
    public void sortBU(Comparable[] a) {
        aux = new Comparable[a.length];
        int length = a.length;
        for (int size = 1; size < length; size += size) {
            for (int low = 0; low < length - size; low += size + size) {
                merge(a, aux, low, low + size - 1,
                      Math.min(low + size + size - 1, length - 1));
            }
        }
    }

    private boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }
}
