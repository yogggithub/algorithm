package princeton.ii.week_1.assign;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;

public final class WordNet {
    private final HashMap<Integer, String> idToWord = new HashMap<>();
    private final HashMap<String, Bag<Integer>> wordToId = new HashMap<>();
    private final SAP sap;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        isValid(synsets, hypernyms);

        In in = new In(synsets);
        String[] readLine;
        while (in.hasNextLine()) {
            readLine = in.readLine().split(",");
            int id = Integer.parseInt(readLine[0]);
            this.idToWord.put(id, readLine[1]);

            for (String word : readLine[1].split(" ")) {
                if (wordToId.get(word) == null) {
                    Bag<Integer> idBag = new Bag<>();
                    idBag.add(id);
                    wordToId.put(word, idBag);
                } else {
                    wordToId.get(word).add(id);
                }
            }
        }

        in = new In(hypernyms);
        Digraph digraph = new Digraph(this.idToWord.size());
        while (in.hasNextLine()) {
            readLine = in.readLine().split(",");
            int v = Integer.parseInt(readLine[0]);
            for (int i = 1; i < readLine.length; i++) {
                digraph.addEdge(v, Integer.parseInt(readLine[i]));
            }
        }
        if (hasCycle(digraph) || !hasRoot(digraph)) {
            throw new IllegalArgumentException();
        }
        this.sap = new SAP(digraph);
    }

    private boolean hasRoot(Digraph graph) {
        int root = 0;
        for (int i = 0; i < graph.V(); i++) {
            if (graph.outdegree(i) == 0) {
                root++;
            }
        }
        return root == 1;
    }

    private boolean hasCycle(Digraph digraph) {
        DirectedCycle directedCycle =
                new DirectedCycle(digraph);
        return directedCycle.hasCycle();
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return this.wordToId.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        isValid(word);
        return this.wordToId.containsKey(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        isValid(nounA, nounB);
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }

        return this.sap.length(
                this.wordToId.get(nounA),
                this.wordToId.get(nounB));
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        isValid(nounA, nounB);
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }
        return this.idToWord.get(
                this.sap.ancestor(
                        this.wordToId.get(nounA),
                        this.wordToId.get(nounB)));
    }

    private void isValid(String... args) {
        for (String arg : args) {
            if (arg == null) {
                throw new IllegalArgumentException();
            }
        }
    }

    // do unit testing of this class
    public static void main(String[] args) {
        WordNet wordNet = new WordNet(
                "princeton/ii/week_1/assign/synsets.txt",
                "princeton/ii/week_1/assign/hypernyms.txt");
        System.out.println(wordNet.isNoun("table"));
        System.out.println(wordNet.idToWord.containsValue("horse"));
    }
}
