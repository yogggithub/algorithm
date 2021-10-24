package top_interview_questions.easy.linkedlist;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        DeleteNode.Solution solution = new DeleteNode.Solution();
    }

    static class Solution {
        public void deleteNode(ListNode node) {
            /*
             * Solution v1: replace this node with next node
             *
             * Runtime: 0 ms @ (beats) ??%
             * Memory Usage: 40.6 MB @ (beats) 39.18%
             */
            node.val = node.next.val;
            node.next = node.next.next;

        }
    }
}
