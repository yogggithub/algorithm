package solutions.p0234_PalindromeLinkedList;

public class solution {
    public static void main(String[] args) {
        solution self = new solution();

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(1);

        head3.next = head4;
        head2.next = head3;
        head1.next = head2;

        System.out.println(self.isPalindrome(head1));
    }

    public ListNode root; // Approach 2: Recursive 配套变量

    public boolean isPalindrome(ListNode head) {

        // Approach 1: reverse half
        /*
         * 总体思路和我是一样的
         * 但通过引入两个指针，将list对半拆开
         * 这样在反转的时候，即使都原list发生变化，也可以进行比较
         *
         * 当然，这种方法，都破坏了原list，不能算是很好的方法
         *
         * */

        // ListNode fast = head, slow = head;
        // // 这里为什么要判断fast.next？
        // while (fast != null && fast.next != null) {
        //     fast = fast.next.next;
        //     slow = slow.next;
        // }
        // // fast不是null的话，上面的循环能结束？
        // // 有comments说可以删除
        // // if (fast != null) { // odd nodes: let right half smaller
        // //     slow = slow.next;
        // // }
        // slow = reverse(slow);
        // fast = head;
        //
        // while (slow != null/*建议加上后半*/ && fast != null ) {
        //     if (fast.val != slow.val) {
        //         return false;
        //     }
        //     fast = fast.next;
        //     slow = slow.next;
        // }
        // return true;
        //


        // Approach 2: Recursive
        /*
         * 通过迭代思路，让head从后向前，另有缓存从前向后
         * 从而达到判断是否回文
         *
         * 严格而言，这个思路，每个点相当于比较了2次
         * 因为，指针从前向后遍历，但其实回文只需要比较一半就可确定
         *
         * */

        root = head;
        // 每个点比较了几次？
        return (head == null) ? true : _isPalindrome(head);


    }

    // Approach 1: reverse half 配套方法，用来反转
    // 这里和我做的一样
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // Approach 2: Recursive 配套方法，用来判断
    public boolean _isPalindrome(ListNode head) {
        boolean flag = true;
        if (head.next != null) {
            // 直接将head迭代到末尾，意味着指针从后向前
            // 因为要存储每一步的结果，从能逐步返回最终结果，其内存是O(n)
            flag = _isPalindrome(head.next);
        }
        if (flag && root.val == head.val) {
            // root指针从前向后
            root = root.next;
            return true;
        }
        return false;
    }
}
