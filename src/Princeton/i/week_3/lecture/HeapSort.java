package Princeton.i.week_3.lecture;

/**
 * Actually is content of week 4
 * but consider this is a sort algorithm
 * so move to the week 3
 */
public class HeapSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exchange(a, 1, N);
            sink(a, 1, --N);
        }
    }

    private static void sink(Comparable[] a, int i, int N) {
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[j] = a[i];
        a[i] = temp;
    }
}
