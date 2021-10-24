package top_interview_questions.easy.linkedlist;

import java.util.ArrayList;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] vals1 = {1, 2, 3, 4, 5};
        ListNode head1 = arrayToListNode(vals1);
        print(solution.removeNthFromEnd(head1, 2));
        int[] vals2 = {1};
        ListNode head2 = arrayToListNode(vals2);
        print(solution.removeNthFromEnd(head2, 1));
        int[] vals3 = {1, 2};
        ListNode head3 = arrayToListNode(vals3);
        print(solution.removeNthFromEnd(head3, 1));
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            /*
             * Solution v1.1: Two pointers with delay of n steps
             *
             * Runtime: 11 ms @ (beats) 0%
             * Memory Usage: 39.3 MB @ (beats) 0%
             */
            // // special case: one node list
            // if (head.next == null) {
            //     return null;
            // }
            //
            // // initialized two pointers
            // ListNode fast = head;
            // ListNode slow = head;
            //
            // // move fast to n steps leading
            // for (int i = 0; i < n; i++) {
            //     fast = fast.next;
            // }
            // // special case: two nodes list
            // if (fast == null) {
            //     return head.next;
            // }
            //
            // // move pointers till fast reach the end
            // while (fast.next != null) {
            //     fast = fast.next;
            //     slow = slow.next;
            //     System.out.println(slow.val);
            // }
            //
            // // delete Nth node
            // slow.next = slow.next.next;
            // return head;

            /*
             * (learn from Internet)
             * Solution v1.2: Add a dummy node before the head node
             */
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;

            // n+1 because of the extra dummy node
            for (int i = 0; i < n + 1; i++) {
                fast = fast.next;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;
            return dummy.next;
        }
    }

    private static ListNode arrayToListNode(int[] nodeValues) {
        ListNode dummyRoot = new ListNode(-1);
        ListNode temp = dummyRoot;
        for (int val : nodeValues) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return dummyRoot.next;
    }

    private static void print(ListNode node) {
        ArrayList<Integer> vals = new ArrayList<>();
        if (node != null) {
            while (node.next != null) {
                vals.add(node.val);
                node = node.next;
            }
            // the last node
            vals.add(node.val);
        }
        System.out.println(vals.toString());
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
