package princeton.ii.week_3.lecture.string;

public class KeyIndexedCounting {

    // Goal. Sort an array a[] of N integers between 0 and R - 1.
    public void sort(int[] a, int R) {
        int N = a.length;
        int[] count = new int[R + 1];
        int[] aux = new int[N];

        // Count frequencies of each letter using key as index
        for (int i = 0; i < N; i++) {
            count[a[i] + 1]++;  // offset by 1 [stay tuned]
        }

        // Compute frequency cumulates which specify destinations
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }

        // Access cumulates using key as index to move items
        for (int i = 0; i < N; i++) {
            aux[count[a[i]]++] = a[i];
            /**
             * explain:
             * cumulate number is 6 for d, and 8 for e
             * so d's go in a[6] and a[7]
             */
        }

        // Copy back into original array
        for (int i = 0; i < N; i++) {
            a[i] = aux[i];
        }

    }
}
