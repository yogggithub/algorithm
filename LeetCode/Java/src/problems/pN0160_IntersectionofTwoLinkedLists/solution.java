package problems.pN0160_IntersectionofTwoLinkedLists;

import auxiliary.ListNode;

public class solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Approach 1: 交换list

        /*
         * 思路：
         * 基本思路和我设想的大体相同
         * 但注意在判断的时候，只要比较两个对象即可，无需关心其具体的属性及迭代
         *
         * 难点一：list长度不同导致的迭代步进差异
         * 这个思路巧妙在通过交换list的方式，解决了不同长度list的迭代进度的问题
         * 图示解释参见：https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
         * 简单总结一下：
         * 在不同长度的情况下，两个list正常迭代
         * 假设A长B短，则A先走完，此时将B赋值给A，A变成了长list
         * 待B走完，将A赋值给B，B变成了短list
         * 在这期间，A仍然在迭代
         * 通过交换list，将迭代步数差异抹平
         *
         * 难点二：没有相同部分要返回null
         * 这个思路在最终判断时，对于迭代殆尽的返回null
         * 结合code中交换list的代码，以及上面对迭代进度的解释
         * 两个list最终同时迭代到末尾，还没有相同部分的话，两个list都变成null
         * 此时，两list相等，while判定为false，跳出，返回null
         *
         * */

        // //boundary check
        // if (headA == null || headB == null) {
        //     return null;
        // }
        //
        // // 为什么需要新建两个对象来承接传入的参数呢？
        // // 我的理解是为了后面交换list
        // ListNode a = headA;
        // ListNode b = headB;
        //
        // // if a & b have different len,
        // // then we will stop the loop after second iteration
        //     // 这句注释没看懂是什么意思，不同的长度第二次迭代后停止？为什么？
        // while (a != b) {
        //     // for the end of first iteration,
        //     // we just reset the pointer to the head of another linkedlist
        //     a = (a == null) ? headB : a.next;
        //     b = (b == null) ? headA : b.next;
        // }
        //
        // return a;


        // Approach 2: 从同样长度开始迭代

        /*
         * 思路：
         * 通过新建方法求list的长度
         * 然后分两种情况，分别判断、调整两个list的开始位置
         * 整体而言，这个思路比法一更直白，也就显得没那么巧妙
         *
         * */

        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            // 从这里看，list应是直接判断是否相等，而不用去判断具体属性
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }


    // Approach 2 的附属方法，求list的长度，要理解并运用
    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
