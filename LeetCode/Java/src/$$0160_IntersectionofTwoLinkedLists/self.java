package $$0160_IntersectionofTwoLinkedLists;

/*
 * Write a program to find the node at which the intersection of
 * two singly linked lists begins.
 *
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5],
 * skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 *
 * Input Explanation:
 * The intersected node's value is 8
 * (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5].
 * From the head of B, it reads as [5,0,1,8,4,5].
 * There are 2 nodes before the intersected node in A;
 * There are 3 nodes before the intersected node in B.
 *
 *
 * Example 2:
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4],
 * skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 *
 * Input Explanation:
 * The intersected node's value is 2
 * (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [0,9,1,2,4].
 * From the head of B, it reads as [3,2,4].
 * There are 3 nodes before the intersected node in A;
 * There are 1 node before the intersected node in B.
 *
 *
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * */

public class self {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 没做出来
        ListNode a = headA;
        ListNode b = headB;

        if (headA == null && headB == null) {
            return null;
        }

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;

        // Runtime: 1 ms, faster than 99.13% of Java online submissions for Intersection of Two Linked Lists.
        // Memory Usage: 38.9 MB, less than 36.43% of Java online submissions for Intersection of Two Linked Lists.
    }
}
