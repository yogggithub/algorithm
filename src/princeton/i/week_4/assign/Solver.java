package princeton.i.week_4.assign;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private int moves;
    private boolean solvable = false;
    private final Stack<Board> solution;

    /**
     * following introduction, create an inner class
     * to represent every node in the priority queue
     * which can store related info, including moves so far, priority,
     * and the link to previous node
     */
    private static class Node implements Comparable<Node> {
        private final Board board;
        private final int moves;
        private final Node previous;
        private final int priority;
        private final boolean isTwin;

        public Node(Board board, int moves, Node previous, boolean isTwin) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
            this.isTwin = isTwin;
            // submission only require Manhattan priority
            priority = board.manhattan() + moves;
        }

        @Override
        public int compareTo(Node that) {
            if (this.board.equals(that.board)) {
                return 0;
            }
            if (this.priority < that.priority) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "\nMoves:" + moves
                   + "\nManhattan:" + board.manhattan()
                   + "\nPriority:" + priority
                   + "\nBoard:" + board;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null
            || initial.dimension() < 2
            || initial.dimension() > 128) {
            throw new IllegalArgumentException();
        }

        Node init = new Node(initial, 0, null, false);
        Node initTwin = new Node(initial.twin(), 0, null, true);

        MinPQ<Node> gameTree = new MinPQ<>();
        gameTree.insert(init);
        gameTree.insert(initTwin);

        this.solution = new Stack<>();

        // A* algorithm
        while (!gameTree.isEmpty()) {
            Node node = gameTree.delMin();
            if (node.board.isGoal()) {
                // based on introduction,
                // when twin grid is solvable, original grid is non-solvable
                if (node.isTwin) {
                    this.moves = -1;
                    this.solvable = false;
                } else {
                    this.moves = node.moves;
                    this.solvable = true;
                    this.solution.push(node.board);
                    while (node.previous != null) {
                        node = node.previous;
                        this.solution.push(node.board);
                    }
                }
                break;
            } else {
                for (Board neighbor : node.board.neighbors()) {
                    Node neighNode = new Node(neighbor, node.moves + 1, node, node.isTwin);
                    if (node.previous == null
                        // critical optimization that avoid duplicates from prev
                        || !neighNode.board.equals(node.previous.board)) {
                        gameTree.insert(neighNode);
                    }
                }
            }
        }
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        boolean b = this.solvable;
        return b;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (isSolvable()) {
            int m = this.moves;
            return m;
        } else {
            return -1;
        }
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (isSolvable()) {
            Stack<Board> s = this.solution;
            return s;
        } else {
            return null;
        }
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In("princeton/i/week_4/assign/4.txt");
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable()) {
            StdOut.println("No solution possible");
        } else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution()) {
                StdOut.println(board);
            }
        }
    }
}
