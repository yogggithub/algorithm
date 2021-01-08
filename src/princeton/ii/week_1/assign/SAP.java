package princeton.ii.week_1.assign;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

public final class SAP {
    private final Digraph digraph;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        if (G == null) {
            throw new IllegalArgumentException();
        }
        // immutable
        this.digraph = new Digraph(G);
    }

    private int[] findPath(int v, int w) {
        isValid(v);
        isValid(w);
        if (v > this.digraph.V() || w > this.digraph.V()) {
            throw new IllegalArgumentException();
        }
        BreadthFirstDirectedPaths vPath =
                new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths wPath =
                new BreadthFirstDirectedPaths(digraph, w);
        return compute(vPath, wPath);

    }

    private int[] findPath(Iterable<Integer> v, Iterable<Integer> w) {
        deepValid(v);
        deepValid(w);

        BreadthFirstDirectedPaths vPath =
                new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths wPath =
                new BreadthFirstDirectedPaths(digraph, w);
        return compute(vPath, wPath);
    }

    private int[] compute(BreadthFirstDirectedPaths v,
                          BreadthFirstDirectedPaths w) {
        int length = Integer.MAX_VALUE;
        int ancestor = -1;

        for (int i = 0; i < this.digraph.V(); i++) {
            if (v.hasPathTo(i)
                && w.hasPathTo(i)) {
                int distance = v.distTo(i) + w.distTo(i);
                if (distance < length) {
                    length = distance;
                    ancestor = i;
                }
            }
        }
        length = length == Integer.MAX_VALUE ? -1 : length;
        return new int[]{length, ancestor};
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        return findPath(v, w)[0];
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        return findPath(v, w)[1];
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        return findPath(v, w)[0];
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        return findPath(v, w)[1];
    }

    private void isValid(int num) {
        if (num >= this.digraph.V()
            || num < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void deepValid(Iterable<Integer> v) {
        if (v == null) {
            throw new IllegalArgumentException();
        }
        for (Integer integer : v) {
            if (integer == null) {
                throw new IllegalArgumentException();
            }
            isValid(integer);
        }
    }

    // do unit testing of this class
    public static void main(String[] args) {
        In in = new In("princeton/ii/week_1/assign/digraph25.txt");
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        //
        // // int length = sap.length(13, 16);
        // // int ancestor = sap.ancestor(13, 16);
        // Stack<Integer> v = new Stack<>();
        // v.push(13);
        // v.push(23);
        // v.push(24);
        // Stack<Integer> w = new Stack<>();
        // w.push(6);
        // w.push(16);
        // w.push(16);
        // int length = sap.length(v, w);
        // int ancestor = sap.ancestor(v, w);
        // StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        ArrayList<Integer> v = new ArrayList<>();
        ArrayList<Integer> w = new ArrayList<>();
        // System.out.println(v.size());
        sap.ancestor(v, w);
    }
}
