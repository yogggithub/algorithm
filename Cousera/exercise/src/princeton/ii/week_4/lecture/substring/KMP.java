package princeton.ii.week_4.lecture.substring;

import edu.princeton.cs.algs4.In;

public class KMP {
    private final int M;
    private final int[][] dfa;

    public KMP(String pat) {
        int R = 256;
        M = pat.length();
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;

        // Constructing the DFA
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) {
                // copy mismatch cases
                dfa[c][j] = dfa[c][X];
            }

            // set match case
            dfa[pat.charAt(j)][j] = j + 1;

            // update restart state
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        int i, j, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) {
            return i - M;
        } else {
            return N;
        }
    }

    public int search(In in) {
        int i, j;
        for (i = 0, j = 0; !in.isEmpty() && j < M; i++) {
            j = dfa[in.readChar()][j];
        }
        if (j == M) {
            return i - M;
        } else {
            return -1;
        }
    }
}
