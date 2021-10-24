package top_interview_questions.easy.linkedlist;

public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] l1 = {3, 2, 0, -4};
        ListNode head1 = ListNode.arrayToListNode(l1);
        System.out.println(solution.hasCycle(head1));

        int[] l2 = {1, 2};
        ListNode head2 = ListNode.arrayToListNode(l2);
        System.out.println(solution.hasCycle(head2));

        // int[] l3 = {};
        // ListNode head3 = ListNode.arrayToListNode(l3);
        // System.out.println(solution.isPalindrome(head3));
    }

    static class Solution {
        public boolean hasCycle(ListNode head) {

            /*
             * (learn from Internet)
             * Solution v1: Two pointers
             */

            // Idea:
            // Traverse the LinkedList with two pointers that has different speed
            // If LinkedList has cycle pointer, two pointers would meet each other eventually.

            // ListNode fast = head, slow = head;
            //
            // while (fast != null && fast.next != null) {
            //     fast = fast.next.next;
            //     slow = slow.next;
            //     if (fast == slow) {
            //         return true;
            //     }
            // }
            // return false;

            /*
             * (learn from Internet)
             * Solution v1: Optimized
             */
            if (head == null) {
                return false;
            }

            ListNode fast = head.next;
            ListNode slow = head;

            while (fast != slow) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
            return true;
        }
    }
}
