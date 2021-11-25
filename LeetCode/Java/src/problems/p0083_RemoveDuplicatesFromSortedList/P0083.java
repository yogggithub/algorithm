package problems.p0083_RemoveDuplicatesFromSortedList;

import auxiliary.ListNode;

public class P0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 38.8 MB @ (beats) 32.71%
         */
        ListNode temp = head;
        while (temp != null) {
            if (temp.next == null) {
                break;
            } else if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}
