package princeton.i.week_2.assign.linked;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node<Item> head, tail;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> node = new Node<>(item);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            int pos = StdRandom.uniform(size);
            Node<Item> old = this.getRandom(pos);
            if (size == 1) {
                tail = node;
                head.next = tail;
                tail.prev = head;
            } else {
                node.next = old.next;
                node.prev = old;
                if (old.next == null) {
                    tail = node;
                } else {
                    old.next.prev = node;
                }
                old.next = node;
            }
        }
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Item item;
        if (size == 1) {
            item = head.item;
            head = null;
            tail = null;
        } else {
            int pos = StdRandom.uniform(size);
            Node<Item> node = this.getRandom(pos);
            item = node.item;
            if (pos == 0) {
                head.next.prev = null;
                head = head.next;
            } else if (pos == size - 1) {
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
        size--;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            return head.item;
        } else {
            int pos = StdRandom.uniform(size);
            return getRandom(pos).item;
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // generate random position, used when CRUD
    private Node<Item> getRandom(int pos) {
        int index;
        Node<Item> random = null;
        RandomizedQueueIterator iterator =
                (RandomizedQueueIterator) this.iterator();
        if (pos >= size / 2) {
            iterator.current = tail;
            index = size - 1;
            while (iterator.hasPrev()) {
                if (index == pos) {
                    random = iterator.current;
                    break;
                } else {
                    iterator.prev();
                    index--;
                }
            }
        } else {
            iterator.current = head;
            index = 0;
            while (iterator.hasNext()) {
                if (index == pos) {
                    random = iterator.current;
                    break;
                } else {
                    iterator.next();
                    index++;
                }
            }
        }
        return random;
    }

    @Override
    public String toString() {
        return "RandomizedQueue{" +
               "head=" + head +
               ", tail=" + tail +
               ", size=" + size +
               '}';
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Object> a = new RandomizedQueue<>();
        for (int i = 0; i < 1000; i++) {
            a.enqueue(i);
            System.out.println("THREAD TWO >>>> " + i + " >> " + a.sample());
        }
        System.out.println(a.tail);

        // test whether generate two random sequence randondeque.
        /*
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    a.enqueue(i);
                    System.out.println("THREAD ONE >>>> " + i + " >> " + a.sample());
                }
                System.out.println(a.tail);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    a.enqueue(i);
                    System.out.println("THREAD TWO >>>> " + i + " >> " + a.sample());
                }
                System.out.println(a.tail);
            }
        }.start();
        */
    }

    private class Node<Item> {
        private Item item;
        private Node<Item> prev, next;

        public Node() {
            this(null);
        }

        public Node(Item item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node{" +
                   "item=" + item +
                   '}';
        }
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Node<Item> current;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public boolean hasPrev() {
            return current != null;
        }

        public Item prev() {
            Item item;
            if (current == null) {
                throw new NoSuchElementException();
            } else {
                item = current.item;
                current = current.prev;
            }
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

