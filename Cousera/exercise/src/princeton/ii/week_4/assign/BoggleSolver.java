package princeton.ii.week_4.assign;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.TST;

import java.util.ArrayList;

public class BoggleSolver {
    private final TST<Integer> dictionary;
    private final ArrayList<String> list;
    private Bag<String>[] adj;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        this.dictionary = new TST<>();
        this.list = new ArrayList<String>();

        int value = 0;
        for (String s : dictionary) {
            int length = s.length();
            if (length < 3) {
                continue;
            } else if (length < 5) {
                value = 1;
            } else if (length == 5) {
                value = 2;
            } else if (length == 6) {
                value = 3;
            } else if (length == 7) {
                value = 5;
            } else {
                value = 11;
            }
            this.dictionary.put(s, value);
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {

        this.adj = new Bag[board.cols() * board.rows()];
        
        // an array to indicated whether the cell been visied
        // default value for boolean type is false, so donot need to fill up
        boolean[][] visited = new boolean[board.rows()][board.cols()];

        for (int c = 0; c < board.cols(); c++) {
            for (int r = 0; r < board.rows(); r++)
            // Changing of rows, move only one row each time
            {
                for (int dc = -1; dc <= 1; dc++) {
                    for (int dr = -1; dr <= 1; dr++)
                    // either dr or dc must be changing, otherwise get a duplicate cell
                    {
                        if (dr != 0 || dc != 0) {
                            concatWord(r, c, dr, dc, board);
                        }
                    }
                }
            }
        }
        return this.list;
    }

    private void concatWord(int baseRow, int baseCol,
                            int dRow, int dCol,
                            BoggleBoard board) {
        String concatWord = "";

        concatWord += String.valueOf(board.getLetter(baseRow, baseCol)).toUpperCase();
        for (int i = baseRow + dRow, j = baseCol + dCol;
             i >= 0 && j >= 0 && i < board.rows() && j < board.cols();
             i += dRow, j += dCol) {

            char c = board.getLetter(i, j);

            // deal with Qu case
            if (c == 'Q') {
                concatWord += "QU";
            } else {
                concatWord += String.valueOf(board.getLetter(i, j)).toUpperCase();
            }
            StdOut.println(concatWord);

            if (dictionary.get(concatWord) != null && !list.contains(concatWord)) {
                list.add(concatWord);
            }

        }
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        return this.dictionary.get(word);
    }

    // unit testing
    public static void main(String[] args) {
        String fileName = "princeton/ii/week_4/assign/test_case/dictionary-algs4.txt";
        In in = new In(fileName);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard("princeton/ii/week_4/assign/test_case/board-q.txt");
        int score = 0;
        for (String word : solver.getAllValidWords(board)) {
            // StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);
    }
}
