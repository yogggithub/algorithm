package solutions.p0141_LinkedListCycle;

import auxiliary.ListNode;

public class P0141 {
    public boolean hasCycle(ListNode head) {

        /*
         * Solution v1: Set donot allow duplicate value
         *
         * Runtime: 12 ms @ (beats) 5.82%
         * Memory Usage: 44.8MB @ (beats) 0%
         */
        // if (head == null) {
        //     return false;
        // }
        //
        // Set<ListNode> set = new HashSet<>();
        //
        // while (head != null) {
        //     if (set.add(head)) {
        //         head = head.next;
        //     } else {
        //         return true;
        //     }
        // }
        // return false;
        /*
         * (learn from Internet)
         * Solution v2: Two pointers
         */

        // Idea:
        // Traverse the LinkedList with two pointers that has different speed
        // If LinkedList has cycle pointer, two pointers would meet each other eventually.

        // ListNode fast = head, slow = head;
        //
        // while (fast != null && fast.next != null) {
        //     fast = fast.next.next;
        //     slow = slow.next;
        //     if (fast == slow) {
        //         return true;
        //     }
        // }
        // return false;

        /*
         * (learn from Internet)
         * Solution v2: Optimized
         */
        if (head == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
