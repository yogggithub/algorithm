package princeton.ii.week_1.assign;

// import edu.princeton.cs.algs4.In;
// import edu.princeton.cs.algs4.StdOut;

public final class Outcast {
    private final WordNet wordnet;

    // constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        String str = "";
        int max = 0;
        for (int i = 0; i < nouns.length; i++) {
            int distance = 0;
            for (int j = 0; j < nouns.length; j++) {
                distance +=
                        this.wordnet.distance(nouns[i], nouns[j]);
            }
            if (distance > max) {
                max = distance;
                str = nouns[i];
            }
        }
        return str;
    }

    // see test client below
    public static void main(String[] args) {
        // WordNet wordnet = new WordNet(
        //         "princeton/ii/week_1/assign/synsets.txt",
        //         "princeton/ii/week_1/assign/hypernyms.txt");
        // Outcast outcast = new Outcast(wordnet);
        // String[] files = {
        //         "princeton/ii/week_1/assign/outcast5.txt"/*,
        //         "princeton/ii/week_1/assign/outcast8.txt",
        //         "princeton/ii/week_1/assign/outcast11.txt"*/};
        // for (int t = 0; t < files.length; t++) {
        //     In in = new In(files[t]);
        //     String[] nouns = in.readAllStrings();
        //     StdOut.println(files[t] + ": " + outcast.outcast(nouns));
        // }
    }
}
