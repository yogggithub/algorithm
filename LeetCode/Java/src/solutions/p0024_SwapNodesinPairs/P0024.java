package solutions.p0024_SwapNodesinPairs;

import auxiliary.ListNode;

public class P0024 {
    public ListNode swapPairs(ListNode head) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 40.1 MB @ (beats) 54.44%
         */
        ListNode ans = new ListNode(0, head);
        head = ans;

        while (head.next != null && head.next.next != null){
            ListNode second = head.next;
            ListNode third = head.next.next;

            second.next = third.next;
            third.next = second;
            head.next = third;
            head = second;

        }

        return ans.next;
    }
}
