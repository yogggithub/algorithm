package princeton.ii.week_3.assign;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FordFulkerson;

import java.util.ArrayList;
import java.util.HashMap;

public class BaseballElimination {
    private final int n;
    private final int[] w, l, r;
    private final int[][] g;

    // List will be more convenient than array
    // when justify existence and find index or item
    private final ArrayList<String> teams;

    // the key is team's name, and value is a list contains all elimination teams
    // the value would be null for team that not be eliminated.
    // coe is abbreviation for certificateOfElimination
    private final HashMap<String, ArrayList<String>> coe;

    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename) {
        // read text file
        In in = new In(filename);

        // get the number of teams
        n = in.readInt();

        // initialize all class variables
        w = new int[n];
        l = new int[n];
        r = new int[n];
        g = new int[n][n];
        teams = new ArrayList<>();
        coe = new HashMap<>();

        // an array store remaining opponents, i.e. vertices for FlowNetwork
        int[] opponents = new int[n];

        // best is the current highest win count
        // winner is the team who has the best result
        int best = 0, winner = 0;

        // read data
        for (int i = 0; i < n; i++) {
            // first column is the team's name
            teams.add(in.readString());

            // following columns are wins, losses, remaining
            w[i] = in.readInt();
            l[i] = in.readInt();
            r[i] = in.readInt();

            // get current best result and that team
            if (best < w[i]) {
                best = w[i];
                winner = i;
            }

            // at the end is games left to play against each teams
            for (int j = 0; j < n; j++) {
                g[i][j] = in.readInt();

                // because all matches have two side
                // so only increment for one side
                if (j > i && g[i][j] > 0) {
                    opponents[i]++;
                    opponents[j]++;
                }
            }
        }

        prediction(opponents, best, winner);
    }

    private void prediction(int[] opponents, int best, int winner) {
        // remaining
        int remaining = 0;
        for (int i = 0; i < n; i++) {
            remaining += opponents[i];
        }

        // all matches have two side
        remaining /= 2;

        for (int i = 0; i < n; i++) {

            /*
             * Trivial elimination
             * teams4 is the sample for this scenario
             */

            // ideal case that win all remaining game
            int max = w[i] + r[i];

            if (max < best) {
                // if the list is null, then initialized it
                coe.computeIfAbsent(teams.get(i), k -> new ArrayList<>());

                // then add the winner the coe list
                coe.get(teams.get(i)).add(teams.get(winner));
                continue;
            }

            /*
             * Nontrivial elimination
             * teams5 is the sample for this scenario
             */

            // other team's total matches
            int otherMatches = remaining - opponents[i];

            // create a FlowNetwork, vertices should be remaining matches
            // plus teams number plus 2 (s & t)
            FlowNetwork flowNetwork = new FlowNetwork(otherMatches + n + 2);

            //
            int temp = 1, fullFlow = 0;

            for (int j = 0; j < n; j++) {
                // only need to consider backward teams
                for (int k = j + 1; k < n; k++) {

                    // only count teams another than current team
                    if (j == i || k == i || g[j][k] == 0) {
                        continue;
                    }

                    fullFlow += g[j][k];

                    flowNetwork.addEdge(new FlowEdge(0, temp, g[j][k]));
                    flowNetwork.addEdge(new FlowEdge(temp, otherMatches + j + 1, Integer.MAX_VALUE));
                    flowNetwork.addEdge(new FlowEdge(temp++, otherMatches + k + 1, Integer.MAX_VALUE));
                }
            }

            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                flowNetwork.addEdge(new FlowEdge(otherMatches + j + 1, otherMatches + n + 1, max - w[j]));
            }

            FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, 0, otherMatches + n + 1);

            if ((int) fordFulkerson.value() == fullFlow) {
                continue;
            }

            // if the list is null, then initialized it
            coe.computeIfAbsent(teams.get(i), k -> new ArrayList<>());

            for (int j = 0; j < n; j++) {
                if (fordFulkerson.inCut(otherMatches + j + 1)) {
                    coe.get(teams.get(i)).add(teams.get(j));
                }
            }
        }
    }

    // number of teams
    public int numberOfTeams() {
        return teams.size();
    }

    // all teams
    public Iterable<String> teams() {
        return teams;
    }

    // get the team's position in the array
    // at the same time, justify whether the team is valid
    private int indexOf(String team) {
        int i = teams.indexOf(team);
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        return i;
    }

    // number of wins for given team
    public int wins(String team) {
        return w[indexOf(team)];
    }

    // number of losses for given team
    public int losses(String team) {
        return l[indexOf(team)];
    }

    // number of remaining games for given team
    public int remaining(String team) {
        return r[indexOf(team)];
    }

    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        return g[indexOf(team1)][indexOf(team2)];
    }

    // is given team eliminated?
    public boolean isEliminated(String team) {
        return coe.get(team) != null;
    }

    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team) {
        return coe.get(team);
    }

    // unit testing
    public static void main(String[] args) {
        // teams12 is the comprehensive test case
        BaseballElimination division = new BaseballElimination("princeton/ii/week_3/assign/teams12.txt");
        for (String team : division.teams()) {
            if (division.isEliminated(team)) {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : division.certificateOfElimination(team)) {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            } else {
                StdOut.println(team + " is not eliminated");
            }
        }
    }
}
