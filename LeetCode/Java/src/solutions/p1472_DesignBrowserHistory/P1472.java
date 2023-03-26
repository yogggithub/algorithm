package solutions.p1472_DesignBrowserHistory;

import java.util.ArrayList;
import java.util.List;

public class P1472 {
    class BrowserHistory {

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 59 ms @ (beats) 54.85%
         * Memory Usage: 50.5 MB @ (beats) 53.18%
         */

        List<String> history;
        int curr;

        public BrowserHistory(String homepage) {
            this.history = new ArrayList<>();
            this.history.add(homepage);
            this.curr = 1;
        }

        public void visit(String url) {
            while (this.curr < this.history.size()) {
                this.history.remove(this.history.size() - 1);
            }
            this.history.add(url);
            this.curr = this.history.size();
        }

        public String back(int steps) {
            if (this.curr - steps < 0) {
                this.curr = 1;
            } else {
                this.curr -= steps;
            }
            return this.history.get(this.curr - 1);
        }

        public String forward(int steps) {
            if (this.curr + steps >= this.history.size()) {
                this.curr = this.history.size();
            } else {
                this.curr += steps;
            }
            return this.history.get(this.curr - 1);
        }
    }
}
