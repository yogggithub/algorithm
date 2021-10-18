package problems.$$0206_ReverseLinkedList;

/*
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 *
 * */

public class self {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);

        head3.next = head4;
        head2.next = head3;
        head1.next = head2;

        self self = new self();
        System.out.println(self.reverseList(head1).val);

        }

    public ListNode reverseList(ListNode head) {

        // 看了答案之后写出来的，使用ListNode的思路还需要再细想
        ListNode list = null, temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = list;
            list = temp;
            temp = next;
        }
        return list;

        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
        // Memory Usage: 37.4 MB, less than 98.20% of Java online submissions for Reverse Linked List.
    }
}
