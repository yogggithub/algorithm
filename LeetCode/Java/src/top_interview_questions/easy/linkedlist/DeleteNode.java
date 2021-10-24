package top_interview_questions.easy.linkedlist;

public class DeleteNode {
    public static void main(String[] args) {
        Solution solution = new Solution();
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

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

