package princeton.ii.week_3.lecture.max_flow;

public class FlowEdge {
    private final int v, w; // from and to
    private final double capacity; // capacity
    private double flow; // flow

    public FlowEdge(int v, int w, double capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
    }

    public int V() {
        return v;
    }

    public int W() {
        return w;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double capacity() {
        return capacity;
    }

    public double flow() {
        return flow;
    }

    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        } else {
            throw new RuntimeException("Illegal endpoint");
        }
    }

    public double residualCapacityTo(int vertex) {
        // backward edge
        if (vertex == v) {
            return flow;
            // forward edge
        } else if (vertex == w) {
            return capacity - flow;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addResidualFlowTo(int vertex, double delta) {
        // backward edge
        if (vertex == v) {
            flow -= delta;
        // forward edge
        } else if (vertex == w) {
            flow += delta;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
