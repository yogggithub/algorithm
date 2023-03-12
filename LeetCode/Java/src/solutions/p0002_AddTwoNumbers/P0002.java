package solutions.p0002_AddTwoNumbers;

import auxiliary.ListNode;

public class P0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode ans = new ListNode(0, temp);

        int reminder = 0;
        while (l1 != null || l2 != null) {

            if (l1 != null) {
                reminder += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                reminder += l2.val;
                l2 = l2.next;
            }
            temp.val = reminder % 10;
            reminder /= 10;

            if (l1 != null || l2 != null) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        if (reminder > 0) {
            temp.next = new ListNode(reminder);
        }

        return ans.next;
    }
}
