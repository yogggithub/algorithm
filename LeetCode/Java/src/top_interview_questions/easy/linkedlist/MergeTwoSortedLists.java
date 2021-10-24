package top_interview_questions.easy.linkedlist;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] l1 = {1, 2, 4};
        int[] l2 = {1, 3, 4};
        ListNode head1 = ListNode.arrayToListNode(l1);
        ListNode head2 = ListNode.arrayToListNode(l2);
        ListNode.print(solution.mergeTwoLists(head1, head2));

        int[] l3 = {};
        int[] l4 = {};
        ListNode head3 = ListNode.arrayToListNode(l3);
        ListNode head4 = ListNode.arrayToListNode(l4);
        ListNode.print(solution.mergeTwoLists(head3, head4));

        int[] l5 = {};
        int[] l6 = {0};
        ListNode head5 = ListNode.arrayToListNode(l5);
        ListNode head6 = ListNode.arrayToListNode(l6);
        ListNode.print(solution.mergeTwoLists(head5, head6));
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            /*
             * Solution v1: Iteratively
             *
             * Runtime: 1 ms @ (beats) %
             * Memory Usage: 39.6 MB @ (beats) 34.77%
             */
            ListNode result = new ListNode(-1);
            ListNode temp = result;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    temp.next = new ListNode(l2.val);
                    temp = temp.next;
                    l2 = l2.next;
                    continue;
                } else if (l2 == null) {
                    temp.next = new ListNode(l1.val);
                    temp = temp.next;
                    l1 = l1.next;
                    continue;
                }
                if (l1.val <= l2.val) {
                    temp.next = new ListNode(l1.val);
                    temp = temp.next;
                    l1 = l1.next;
                } else {
                    temp.next = new ListNode(l2.val);
                    temp = temp.next;
                    l2 = l2.next;
                }
            }
            return result.next;
            /*
             * Solution v2: Recursively
             *
             * Runtime: 0 ms @ (beats) 100%
             * Memory Usage: 38 MB @ (beats) 95.83%
             */
            // // base cases: empty list
            // if (l1 == null) {
            //     return l2;
            // } else if (l2 == null) {
            //     return l1;
            // }
            //
            // ListNode result = new ListNode();
            // if (l1.val <= l2.val) {
            //     result.val = l1.val;
            //     result.next = mergeTwoLists(l1.next, l2);
            // } else {
            //     result.val = l2.val;
            //     result.next = mergeTwoLists(l1, l2.next);
            // }
            // return result;
        }
    }
}
