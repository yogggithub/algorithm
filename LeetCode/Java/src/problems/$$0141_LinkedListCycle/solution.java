package problems.$$0141_LinkedListCycle;

public class solution {
    public boolean hasCycle(ListNode head) {

        // Approach 1: Hash Table
        /*
         * We go through each node one by one and record each node's reference
         * (or memory address) in a hash table.
         * If the current node is null, we have reached the end of the list
         * and it must not be cyclic.
         * If current node's reference is in the hash table, then return true.
         *
         * 思路：
         * 如果set表中有，则true，如果没有，则加入
         * 直到所有元素都加入
         * 然后将head清空
         *
         * */

        // Set<ListNode> nodesSeen = new HashSet<>();
        // while (head != null) {
        //     if (nodesSeen.contains(head)) {
        //         return true;
        //     } else {
        //         nodesSeen.add(head);
        //     }
        //     head = head.next;
        // }
        // return false;


        // Approach 2: Two Pointers
        /*
         * Imagine two runners running on a track at different speed.
         * What happens when the track is actually a circle?
         *
         * The space complexity can be reduced to O(1)O(1)
         * by considering two pointers at different speed
         * - a slow pointer and a fast pointer.
         * The slow pointer moves one step at a time
         * while the fast pointer moves two steps at a time.
         *
         * If there is no cycle in the list, the fast pointer will
         * eventually reach the end and we can return false in this case.
         * Now consider a cyclic list and imagine the slow and fast pointers
         * are two runners racing around a circle track.
         * The fast runner will eventually meet the slow runner.
         * Why? Consider this case (we name it case A)
         * - The fast runner is just one step behind the slow runner.
         * In the next iteration, they both increment one and two steps
         * respectively and meet each other.
         *
         * How about other cases?
         * For example, we have not considered cases where the fast runner is
         * two or three steps behind the slow runner yet.
         * This is simple, because in the next or next's next iteration,
         * this case will be reduced to case A mentioned above.
         *
         * 思路：环形 -> 无终点 -> 迭代后终会相等
         * 假设有两个人在环形跑道上运动，一个跑一个走
         * 则，无论谁先谁后&相差多远，总会出现两个人并排的情形。
         *
         * 具体到算法中，开始定义既可以相同，也可以相差一代
         * 但迭代过程中两者一定要有代数的差异，最终判断两者是否出现相等的情形
         *
         * */
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
