package problems.p0206_ReverseLinkedList;

import auxiliary.ListNode;

/*
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 */

public class P0206 {
    public ListNode reverseList(ListNode head) {
        // base cases: empty list or only one node list
        if (head == null || head.next == null) {
            return head;
        } else {
            /*
             * Solution v1: Iteratively
             *
             * Runtime: 1 ms @ (beats) %
             * Memory Usage: 39.6 MB @ (beats) 34.77%
             */
            //     ListNode dummy = new ListNode(-1);
            //     ListNode temp = head;
            // while (temp != null) {
            //     ListNode current = new ListNode(temp.val);
            //     current.next = dummy.next;
            //     dummy.next = current;
            //     temp = temp.next;
            // }

            /*
             * Solution v2: Recursively
             *
             * Runtime: ms @ (beats) %
             * Memory Usage: MB @ (beats) %
             */
            // ListNode dummy = new ListNode(-1);
            ListNode current = reverseList(head.next);
            // change the next node's next to itself
            // thus, build the next->current connection
            head.next.next = head;
            // cut circular refer
            head.next = null;
            return current;
        }
    }
}
