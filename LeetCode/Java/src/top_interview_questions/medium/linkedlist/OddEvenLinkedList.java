package top_interview_questions.medium.linkedlist;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        /*
         * Solution v1: Brute Force
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 39.1 MB @ (beats) 45.05%
         */
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode temp = head;
        ListNode x = odd;
        ListNode y = even;
        int i = 1;
        while (temp != null) {
            if (i % 2 == 0) {
                y.next = new ListNode();
                y = y.next;
                y.val = temp.val;
            } else {
                x.next = new ListNode();
                x = x.next;
                x.val = temp.val;
            }
            i++;
            temp = temp.next;
        }

        x.next = even.next;
        return odd.next;
    }
}
