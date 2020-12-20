package princeton.i.week_2.assign.linked;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);

        RandomizedQueue<String> ranQue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            ranQue.enqueue(StdIn.readString());
        }

        for (String s : ranQue) {
            System.out.println(s);
            if (num == 0) {
                break;
            }
            num--;
        }
    }
}

