package princeton.i.week_4.lecture.priorityQ;


/**
 * This is a complete binary tree
 * <p>
 * Complete tree means tree is perfectly balanced, except for bottom level
 * i.e. except the very bottom level, every node has two non null children
 * <p>
 * Property:
 * 1. Height of complete tree with N nodes is lg N
 * 2. Height only increases when N is a power of 2.
 */
public class BinaryHeap<Key extends Comparable<Key>> {
    private Key[] node;
    private int n;

    public BinaryHeap(Key[] node) {
        this.node = node;
        n = node.length;
    }

    public void insert(Key key) {
        node[++n] = key;
        swim(n);
    }

    /**
     * maximum node is at the top
     * the process of delete the top node:
     * 1. exchange the very end node and the top node, decrement the size
     * 2. sink the new top node to a reasonable position
     * 3. assign null to the maximum node whose index is at n+i, prevent loitering
     *
     * @return
     */
    public Key delMax() {
        Key max = node[1];
        exchange(1, n--);
        sink(1);

        node[n + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    private void exchange(int i, int j) {
        Key temp = node[i];
        node[i] = node[j];
        node[j] = temp;
    }

    private boolean less(int i, int j) {
        return node[i].compareTo(node[j]) < 0;
    }
}
