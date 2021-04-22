package princeton.i.week_4.lecture.priorityQ;


public class UnorderedMaxPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public UnorderedMaxPriorityQueue(int size) {
        pq = (Key[]) new Comparable[size];
    }

    public void insert(Key key) {
        pq[N++] = key;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (less(max, i)) {
                max = i;
            }
            exchange(max, N - 1);
        }
        return pq[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void exchange(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    private boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }
}

