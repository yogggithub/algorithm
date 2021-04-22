package $$0002_AddTwoNumbers;

/*
 * Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * */


public class self {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(3);
        head2.next = head3;
        head1.next = head2;

        ListNode head4 = new ListNode(5);
        ListNode head5 = new ListNode(6);
        ListNode head6 = new ListNode(4);
        head5.next = head6;
        head4.next = head5;

        self self = new self();
        ListNode result1 = self.addTwoNumbers(head1, head4);

        ListNode head7 = new ListNode(9);

        ListNode head8 = new ListNode(1);
        ListNode head9 = new ListNode(9);
        ListNode head10 = new ListNode(9);
        head9.next = head10;
        head8.next = head9;

        ListNode result2 = self.addTwoNumbers(head7, head8);
        System.out.println(result2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Approach 1: Brute Force
        // 使用数字类型导致超出取值范围
        // int val1 = convertToInt(l1);
        // int val2 = convertToInt(l2);
        // return convertBackToTree(val1 + val2);

        // Approach 2: 直接在Tree上操作

        return null;
    }



    // Approach 1: 配套方法
    // public int convertToInt(ListNode listNode) {
    //     ListNode temp = listNode;
    //     Stack<Integer> stack = new Stack<>();
    //     while (temp != null) {
    //         stack.push(temp.val);
    //         temp = temp.next;
    //     }
    //     int number = 0;
    //     for (int i = stack.size(); i > 0; i--) {
    //         number += stack.pop() * (int) Math.pow(10, i - 1);
    //     }
    //     return number;
    // }
    //
    // public ListNode convertBackToTree(int number) {
    //     String str = Integer.toString(number);
    //     int[] arr = new int[str.length()];
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[arr.length - 1 - i] = Integer.parseInt(String.valueOf(str.charAt(i)));
    //     }
    //     ListNode temp = null;
    //     for (int i = arr.length - 1; i >= 0; i--) {
    //         ListNode head = new ListNode(arr[i]);
    //         if (temp == null) {
    //             temp = head;
    //         } else {
    //             head.next = temp;
    //             temp = head;
    //         }
    //     }
    //     return temp;
    // }
}
