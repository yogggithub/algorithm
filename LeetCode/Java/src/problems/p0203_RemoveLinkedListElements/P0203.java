package problems.p0203_RemoveLinkedListElements;

import auxiliary.ListNode;

public class P0203 {
    public ListNode removeElements(ListNode head, int val) {
        /*
         * Solution v1: Brute Force
         *
         * Runtime: 1 ms @ (beats) 79.34%
         * Memory Usage: 39.9 MB @ (beats) 72.92%
         */
        // ListNode dummyHead = new ListNode();
        //
        // // skip invalid node at beginning
        // while (head != null && head.val == val) {
        //     head = head.next;
        // }
        // dummyHead.next = head;
        //
        // while (head != null) {
        //     ListNode temp = head.next;
        //     while (temp != null && temp.val == val) {
        //         temp = temp.next;
        //     }
        //     head.next = temp;
        //     head = head.next;
        // }
        // return dummyHead.next;

        /*
         * (learn from Internet)
         * Solution v2: Two pointers
         */
        // if (head == null) {
        //     return head;
        // }
        // ListNode temp = new ListNode(-1, head);
        // ListNode prev = temp, curr = head;
        // while (prev != null && curr != null) {
        //     if (curr.val == val) {
        //         curr = curr.next;
        //         prev.next = curr;
        //     } else {
        //         prev = prev.next;
        //         curr = curr.next;
        //     }
        // }
        //
        // return temp.next;

        /*
         * (learn from Internet)
         * Solution v3: Recursive
         */
        if (head == null) {
            return head;
        }

        ListNode node = removeElements(head.next, val);
        if (head.val == val) {
            return node;
        }
        head.next = node;
        return head;
    }
}
