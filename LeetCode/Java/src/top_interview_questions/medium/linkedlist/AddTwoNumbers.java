package top_interview_questions.medium.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        /*
         * Solution v1.1: Brute Force
         *
         * Runtime: 2 ms @ (beats) 74.02%
         * Memory Usage: 39.7 MB @ (beats) 48.73%
         */
        // int surplus = 0;
        // ListNode temp = result;
        // while (l1 != null || l2 != null) {
        //     int val = 0;
        //     if (l1 != null && l2 != null) {
        //         val = l1.val + l2.val + surplus;
        //
        //         l1 = l1.next;
        //         l2 = l2.next;
        //     } else if (l1 == null) {
        //         val = l2.val + surplus;
        //         l2 = l2.next;
        //     } else {
        //         val = l1.val + surplus;
        //         l1 = l1.next;
        //     }
        //
        //     if (val > 9) {
        //         temp.val = val % 10;
        //     } else {
        //         temp.val = val;
        //     }
        //
        //     surplus = val / 10;
        //     if (l1 != null || l2 != null) {
        //         temp.next = new ListNode();
        //         temp = temp.next;
        //     }
        // }
        //
        // if (surplus != 0) {
        //     temp.next = new ListNode(surplus);
        // }
        // return result;

        /*
         * Solution v2: String
         *
         * Idea is correct but can not deal with super long Node
         */
        // StringBuilder str1 = new StringBuilder();
        // while (l1 != null) {
        //     str1.insert(0, l1.val);
        //     l1 = l1.next;
        // }
        // StringBuilder str2 = new StringBuilder();
        // while (l2 != null) {
        //     str2.insert(0, l2.val);
        //     l2 = l2.next;
        // }
        // System.out.println(str1);
        // System.out.println(str2);
        // String str = String.valueOf(Integer.parseInt(str1.toString())
        //                             + Integer.parseInt(str2.toString()));
        // System.out.println(str);
        // ListNode temp = result;
        // for (int i = str.length() - 1; i > 0; i--) {
        //     temp.val = Integer.parseInt(String.valueOf(str.charAt(i)));
        //     temp.next = new ListNode();
        //     temp = temp.next;
        // }
        //
        // temp.val = Integer.parseInt(String.valueOf(str.charAt(0)));
        // return result;


        /*
         * (learn from Internet)
         * Solution v1.2: Optimized
         */
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
