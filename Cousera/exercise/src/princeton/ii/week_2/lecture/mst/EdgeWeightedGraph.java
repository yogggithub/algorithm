package princeton.ii.week_2.lecture.mst;

import edu.princeton.cs.algs4.Bag;

import java.util.ArrayList;

public class EdgeWeightedGraph {
    private final int V;
    private final Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }
    public int V() {
        return V;
    }
    public int G(){
        ArrayList edges = (ArrayList) this.edges();
        return edges.size();
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        ArrayList edges = new ArrayList();
        for (Bag<Edge> bag : adj) {
            for (Edge e : bag) {
                edges.add(e);
            }
        }
        return edges;
    }
}
