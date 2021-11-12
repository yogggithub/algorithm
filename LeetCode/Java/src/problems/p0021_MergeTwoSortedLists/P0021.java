package problems.p0021_MergeTwoSortedLists;

import auxiliary.ListNode;

public class P0021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
        // Memory Usage: 39.5 MB, less than 16.84% of Java online submissions for Merge Two Sorted Lists.

    }
}
