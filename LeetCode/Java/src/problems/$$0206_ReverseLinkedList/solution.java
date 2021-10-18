package problems.$$0206_ReverseLinkedList;

public class solution {
    public ListNode reverseList(ListNode head) {

        // Approach 1: Iterative

        /*
         * 思路：逐一提取并倒序。
         * 1. 取出原list中的所有next，先存放，下一个循环要用
         * 2. 替换原list中的next，将其变成已倒序的部分
         *    通过逐个提取元素并拼接已倒序的方法，逐步完成倒序
         * 3. 将先拼接的倒序清单赋值给结果
         * 4. 取回存放的原list剩余next，进入下一个循环
         *
         * 以[1, 2, 3, 4]为例：重点理解一下循环中的过程
         * 第一步循环
         * 1. 新建对象nextTemp，来存curr.next = [2, 3, 4]
         * 2. 修改后续curr后续节点，让后续变成空（此时，curr = [1]）
         * 3. 将当前curr赋值给 prev = [1]
         * 4. 将curr变成curr.next = [2, 3, 4]（通过nextTemp）
         *
         * 第二步循环
         * 1. 新建对象nextTemp，来存curr.next = [3, 4]
         * 2. 修改后续curr后续节点，让后续变成 [1]（此时，curr = [2, 1]）
         * 3. 将当前curr赋值给 prev = [2, 1]
         * 4. 将curr变成curr.next = [3, 4]（通过nextTemp）
         *
         * 后续递推即可
         *
         * */

        // ListNode prev = null;
        // ListNode curr = head;
        // while (curr != null) {
        //     ListNode nextTemp = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = nextTemp;
        // }
        // return prev;


        // Approach 3: Other Iterative (has explanation)

        /*
         * The trick is to think of the first element
         * as the new last item in the list.
         * After reversing, this must be true.
         * Then, we just move the element that pivot.next points
         * to (the initial head of the list)
         * and we move it to become the new head.
         *
         * This essentially grows the list backwards
         * until the initial pivot no longer has anything to move.
         *
         * For example; if we have a list [1, 2, 3, 4],
         * the algorithm will do the following:
         * 1. Set curr to 1, set prev to 2, keep head at 1
         * 2. We see that curr still has items after it,
         *    so set curr.next to .next.next,
         *    and move the curr to be set to the current head
         * 3. Now move the head back to point to the new head,
         *    which is the prev node we just set
         * 4. Now reset prev to curr.next and repeat.
         *
         * So with each iteration of the loop the list becomes:
         * [1, 2, 3, 4]
         * [2, 1, 3, 4]
         * [3, 2, 1, 4]
         * [4, 3, 2, 1]
         *
         * */

        // ListNode curr = head;
        // ListNode prev = null;
        // while (curr != null && curr.next != null) {
        //     prev = curr.next;
        //     curr.next = curr.next.next;
        //     prev.next = head;
        //     head = prev;
        // }


        // Approach 2: Recursive

        /*
         * The recursive version is slightly trickier
         * and the key is to work backwards.
         *
         * 思路：
         * 假设原list已经有一部分已经改好了，i.e. k之后的节点顺序已经调整了
         * 那怎么改动k节点？k的下一个是k+1，而要变成k+1的下一个是k
         * 于是：k.next.next = k，理解这个核心
         *
         * 注意：1号节点的下一个是null，If you forget about this,
         * your linked list has a cycle in it.
         * This bug could be caught if you test your code
         * with a linked list of size 2.
         *
         * */

        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode p = reverseList(head.next);
        // head.next.next = head;
        // head.next = null;   // 这步还是没看懂，为什么不是加判断？
        // return p;


        // Approach 4: Other Iterative

        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null){
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

}
