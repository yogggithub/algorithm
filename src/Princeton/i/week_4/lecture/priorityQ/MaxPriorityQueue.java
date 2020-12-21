package Princeton.i.week_4.lecture.priorityQ;


public class MaxPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MaxPriorityQueue(int size) {
        pq = (Key[]) new Comparable[size + 1];
    }

    public MaxPriorityQueue(Key[] a) {

    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exchange(1, N--);
        sink(1);

        pq[N + 1] = null;
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private Key max() {
        return pq[1];
    }

    public int size() {
        return N;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
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

