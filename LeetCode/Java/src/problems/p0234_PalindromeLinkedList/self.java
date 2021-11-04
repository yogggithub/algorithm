package problems.p0234_PalindromeLinkedList;

/*
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * */


public class self {
    public static void main(String[] args) {
        self self = new self();

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(1);

        head3.next = head4;
        head2.next = head3;
        head1.next = head2;

        System.out.println(self.isPalindrome(head1));
    }

    public boolean isPalindrome(ListNode head) {

        // 感觉自己的思路是没问题的，就是将list反转，然后比较每个node是否相等
        // 但遇到了引用类型变更的问题，一旦执行反转，其对list发生永久改变
        // 自己未能想到如何存储list原值的途径
        if (head == null) {
            return true;
        }

        ListNode reverse = reverse(head);

        while (head != null || reverse != null) {
            if (head != null && reverse != null) {
                if (head.val == reverse.val) {
                    head = head.next;
                    reverse = reverse.next;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode list = null, temp = head;
        if (head == null) {
            return null;
        }
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = list;
            list = temp;
            temp = next;
        }
        return list;
    }
}
