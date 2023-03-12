package solutions.p0382_LinkedListRandomNode;

import auxiliary.ListNode;

import java.util.ArrayList;
import java.util.List;

public class P0382 {

    List nodes = new ArrayList<Integer>();

    public void Solution(ListNode head) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 12 ms @ (beats) 48.76%
         * Memory Usage: 45 MB @ (beats) 14.89%
         */
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }

    }

    public int getRandom() {
        int n = (int) (Math.random() * this.nodes.size());
        return (int) this.nodes.get(n);
    }
}
