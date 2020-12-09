package Princeton.i.week_2.assign.linked;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);

        RandomizedQueue<String> ranQue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            ranQue.enqueue(StdIn.readString());
        }

        while (num > 0) {
            ranQue.forEach(StdOut::println);
            num--;
        }

    }
}
