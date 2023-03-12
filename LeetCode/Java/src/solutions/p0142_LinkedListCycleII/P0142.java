package solutions.p0142_LinkedListCycleII;

import auxiliary.ListNode;

public class P0142 {
    public ListNode detectCycle(ListNode head) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 4 ms @ (beats) 13.39%
         * Memory Usage: 44 MB @ (beats) 12.87%
         */
        // Set<ListNode> nodes = new HashSet<>();
        //
        // while (head != null) {
        //     if (nodes.contains(head)) {
        //         return head;
        //     }
        //     nodes.add(head);
        //     head = head.next;
        // }
        //
        // return null;

        /*
         * Solution v2: Two pointers
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 43 MB @ (beats) 36.86%
         */
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
