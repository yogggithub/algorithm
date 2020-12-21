package princeton.i.week_4.lecture.simulation;

public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MinPQ() {
    }

    public MinPQ(int size) {
        pq = (Key[]) new Comparable[size + 1];
    }

    public MinPQ(Key[] a) {
        this.pq = a;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMin() {
        Key min = pq[1];
        exchange(1, N--);
        sink(1);

        pq[N + 1] = null;
        return min;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private Key min() {
        return pq[1];
    }

    public int size() {
        return N;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j + 1, j)) {
                j++;
            }
            if (!less(j, k)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
