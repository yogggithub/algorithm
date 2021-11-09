package top_interview_questions.easy.linkedlist;

import auxiliary.ListNode;

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
             * Solution v1: Set donot allow duplicate value
             *
             * Runtime: 12 ms @ (beats) 5.82%
             * Memory Usage: 44.8MB @ (beats) 0%
             */
            // if (head == null) {
            //     return false;
            // }
            //
            // Set<ListNode> set = new HashSet<>();
            //
            // while (head != null) {
            //     if (set.add(head)) {
            //         head = head.next;
            //     } else {
            //         return true;
            //     }
            // }
            // return false;
            /*
             * (learn from Internet)
             * Solution v2: Two pointers
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
             * Solution v2: Optimized
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
