package princeton.ii.week_1.lecture;

import edu.princeton.cs.algs4.Bag;

import java.util.Arrays;

public class Graph {
    private final int V;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int getV() {
        return V;
    }

    public Bag<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(Bag<Integer>[] adj) {
        this.adj = adj;
    }

    @Override
    public String toString() {
        return "Graph{" +
               "V=" + V +
               ", adj=" + Arrays.toString(adj) +
               '}';
    }
}
