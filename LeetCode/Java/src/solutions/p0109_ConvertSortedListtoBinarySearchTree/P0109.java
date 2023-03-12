package solutions.p0109_ConvertSortedListtoBinarySearchTree;

import auxiliary.ListNode;
import auxiliary.TreeNode;

public class P0109 {
    public TreeNode sortedListToBST(ListNode head) {
        /*
         * Solution v1: Two poniters to find middle node
         *
         * Runtime: 0 ms @ (beats) 100%
         * Memory Usage: 43.7 MB @ (beats) 44.80%
         */

        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode tree = new TreeNode(slow.next.val);

        tree.right = this.sortedListToBST(slow.next.next);

        slow.next = null;

        tree.left = this.sortedListToBST(head);

        return tree;
    }
}
