package top_interview_questions.easy.linkedlist;

import auxiliary.ListNode;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // int[] l1 = {1, 2, 2, 1};
        // ListNode head1 = ListNode.arrayToListNode(l1);
        // System.out.println(solution.isPalindrome(head1));
        //
        // int[] l2 = {1, 2};
        // ListNode head2 = ListNode.arrayToListNode(l2);
        // System.out.println(solution.isPalindrome(head2));

        // int[] l3 = {};
        // ListNode head3 = ListNode.arrayToListNode(l3);
        // System.out.println(solution.isPalindrome(head3));
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {

            // base case; one element
            if (head.next == null) {
                return true;
            }
            /*
             * Solution v1: get all node values and then compare
             *
             * Runtime: 62 ms @ (beats) 0%
             * Memory Usage: 160.6 MB @ (beats) 0%
             */
            // int n = 0;
            // Map<Integer, Integer> map = new HashMap<>();
            // while (head != null) {
            //     map.put(n++, head.val);
            //     head = head.next;
            // }
            // for (int i = 0; i < n; i++) {
            //     if (!map.get(i).equals(map.get(n - i - 1))) {
            //         return false;
            //     }
            // }

            /*
             * (learn from Internet)
             * Solution v2: find middle point, reverse back half, then compare
             *
             * Runtime: 0 ms @ (beats) 100%
             * Memory Usage: 38 MB @ (beats) 95.83%
             */
            // find middle point

            ListNode fast = head;
            ListNode slow = head;

            // fast move two steps once while slow move only one
            // when fast reach the end, slow would be the middle point
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            // reverse rare half
            ListNode rare = slow;
            while (slow.next != null) {
                ListNode temp = slow.next;
                slow.next = slow.next.next;
                temp.next = rare;
                rare = temp;
            }

            // compare
            while (rare != null) {
                if (rare.val != head.val) {
                    return false;
                }
                rare = rare.next;
                head = head.next;
            }


            return true;
        }
    }
}
