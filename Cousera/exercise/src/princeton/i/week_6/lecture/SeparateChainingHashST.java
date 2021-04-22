package princeton.i.week_6.lecture;

import org.w3c.dom.Node;

public class SeparateChainingHashST<Key, Value> {
    private int M; // number of chains
    private Node[] st; // array of chains
    private int N;

    public SeparateChainingHashST() {
        M = 97;
        st = new Node[M];
        N = 0;
    }

    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return (Value) x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (N == M) {
            resize(st.length * 2);
        }
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        st[i] = new Node(key, val, st[i]);
        N++;
    }

    /**
     * doubling the array size
     *
     * @param capacity
     */
    private void resize(int capacity) {
        Node[] copy = new Node[capacity];
        for (int i = 0; i < M; i++) {
            copy[i] = st[i];
        }
        st = copy;
    }

}
