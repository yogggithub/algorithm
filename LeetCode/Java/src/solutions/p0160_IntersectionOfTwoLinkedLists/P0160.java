package solutions.p0160_IntersectionOfTwoLinkedLists;

import auxiliary.ListNode;

public class P0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        /*
         * Solution v1: HashSet to judge duplicate Node
         *
         * Runtime: 7 ms @ (beats) 25.35%
         * Memory Usage: 42.7 MB @ (beats) 50.58%
         */
        // Set<ListNode> nodes = new HashSet<>();
        // ListNode currA = headA;
        // ListNode currB = headB;
        //
        // while (currA != null) {
        //     nodes.add(currA);
        //     currA = currA.next;
        // }
        //
        // while (currB != null) {
        //     if (nodes.contains(currB)) {
        //         return currB;
        //     }
        //     currB = currB.next;
        // }
        // return null;

        /*
         * (learn from Internet)
         * Solution v2: Find depth and align the two
         *
         */
        // int lenA = 0, lenB = 0;
        // ListNode currA = headA;
        // ListNode currB = headB;
        // while (currA != null) {
        //     lenA++;
        //     currA = currA.next;
        // }
        // while (currB != null) {
        //     lenB++;
        //     currB = currB.next;
        // }
        //
        // if (lenA > lenB) {
        //     for (int i = 0; i < lenA - lenB; ++i) {
        //         headA = headA.next;
        //     }
        // } else {
        //     for (int i = 0; i < lenB - lenA; ++i) {
        //         headB = headB.next;
        //     }
        // }
        // while (headA != null && headB != null && headA != headB) {
        //     headA = headA.next;
        //     headB = headB.next;
        // }
        // return (headA != null && headB != null) ? headA : null;

        /*
         * (learn from Internet)
         * Solution v3: Ring
         *
         */
        // idea:
        // transversal the two
        // when reach the end of one, link to the other's head
        // eventually the two will met each other at the intersection
        // if there is no intersection, the two will met at a Null node
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }
}
