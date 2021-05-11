package princeton.ii.week_3.lecture.string;

public class LSD {
    /**
     * @param a
     * @param W fixed-length W strings
     */
    public static void sort(String[] a, int W) {
        int R = 256;    // radix R
        int N = a.length;
        String[] aux = new String[N];

        // do key-indexed counting
        // for each digit from right to left
        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++) {
                // key-indexed counting
                count[a[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
