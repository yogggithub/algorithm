package princeton.i.week_5.assign;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;


public class KdTree {
    private final TreeNode<Point2D, Double> points;

    private static class TreeNode<Key extends Comparable<Key>, Value> {
        Node root;
        private static final boolean VERTICAL = true;
        private static final boolean HORIZONTAL = false;

        public TreeNode() {
        }

        private class Node {
            private final Key key;
            private Value val;
            private Node previous, left, right;
            private boolean direction;
            private int subCount;

            public Node(Key key, Value val) {
                this.key = key;
                this.val = val;
            }

            public Node(Key key, Value val, boolean direction) {
                this.key = key;
                this.val = val;
                this.direction = direction;
            }
        }

        public boolean isEmpty() {
            return root == null;
        }

        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null) {
                return 0;
            }
            return x.subCount;
        }

        public void put(Key key, Value val) {
            root = put(root, key, val);
        }

        private Node put(Node x, Key key, Value value) {
            if (x == null) {
                Node node = new Node(key, value, VERTICAL);
                node.subCount = 1;
                return node;
            }
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x.left = put(x.left, key, value);
                x.left.previous = x;
            } else if (cmp > 0) {
                x.right = put(x.right, key, value);
                x.right.previous = x;
            } else {
                x.val = value;
            }
            if (x.previous != null
                && x.previous.direction == VERTICAL) {
                x.direction = HORIZONTAL;
            }
            x.subCount = 1 + size(x.left) + size(x.right);
            return x;
        }

        public Value get(Key key) {
            Node x = root;
            while (x != null) {
                int cmp = key.compareTo(x.key);
                if (cmp < 0) {
                    x = x.left;
                } else if (cmp > 0) {
                    x = x.right;
                } else {
                    return x.val;
                }
            }
            return null;
        }

        public Iterable<Key> iterator() {
            Queue<Key> q = new Queue<>();
            putIntoQueue(root, q);
            return q;
        }

        private void putIntoQueue(Node x, Queue<Key> q) {
            if (x == null) {
                return;
            }
            putIntoQueue(x.left, q);
            q.enqueue(x.key);
            putIntoQueue(x.right, q);
        }
    }

    // construct an empty set of points
    public KdTree() {
        points = new TreeNode<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return points.isEmpty();
    }

    // number of points in the set
    public int size() {
        return points.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null
            || p.x() < 0 || p.x() > 1
            || p.y() < 0 || p.y() > 1) {
            throw new IllegalArgumentException();
        }
        if (!this.contains(p)) {
            points.put(p, p.y());
        }
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return points.get(p) != null;
    }

    // draw all points to standard draw
    public void draw() {
        for (Point2D p : points.iterator()) {
            p.draw();
        }
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException();
        }
        Queue<Point2D> p = new Queue<>();
        for (Point2D point : points.iterator()) {
            if (rect.contains(point)) {
                p.enqueue(point);
            }
        }
        return p;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty()) {
            return null;
        }
        double min = Double.POSITIVE_INFINITY;
        double distance;
        Point2D nearest = p;
        for (Point2D that : points.iterator()) {
            distance = p.distanceSquaredTo(that);
            if (min > distance) {
                min = distance;
                nearest = that;
            }
        }
        return nearest;
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
        /* unit testing of the methods (optional) */
    }
}
