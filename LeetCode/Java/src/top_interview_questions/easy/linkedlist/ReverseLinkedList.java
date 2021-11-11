package top_interview_questions.easy.linkedlist;

import auxiliary.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        // Solution solution = new Solution();
        // int[] vals1 = {1, 2, 3, 4, 5};
        // ListNode head1 = ListNode.arrayToListNode(vals1);
        // ListNode.print(solution.reverseList(head1));
        // int[] vals2 = {};
        // ListNode head2 = ListNode.arrayToListNode(vals2);
        // ListNode.print(solution.reverseList(head2));
        // int[] vals3 = {1, 2};
        // ListNode head3 = ListNode.arrayToListNode(vals3);
        // ListNode.print(solution.reverseList(head3));
    }

    static class Solution {
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
}
