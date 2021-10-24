package top_interview_questions.easy.linkedlist;

import java.util.ArrayList;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] l1 = {1, 2, 4};
        int[] l2 = {1, 3, 4};
        ListNode head1 = arrayToListNode(l1);
        ListNode head2 = arrayToListNode(l2);
        print(solution.mergeTwoLists(head1, head2));

        int[] l3 = {};
        int[] l4 = {};
        ListNode head3 = arrayToListNode(l3);
        ListNode head4 = arrayToListNode(l4);
        print(solution.mergeTwoLists(head3, head4));

        int[] l5 = {};
        int[] l6 = {0};
        ListNode head5 = arrayToListNode(l5);
        ListNode head6 = arrayToListNode(l6);
        print(solution.mergeTwoLists(head5, head6));
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
