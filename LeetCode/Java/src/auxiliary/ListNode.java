package auxiliary;

import java.util.ArrayList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // public static ListNode arrayToListNode(int[] nodeValues) {
    //     ListNode dummyRoot = new ListNode(-1);
    //     ListNode temp = dummyRoot;
    //     for (int val : nodeValues) {
    //         temp.next = new ListNode(val);
    //         temp = temp.next;
    //     }
    //     return dummyRoot.next;
    // }
    //
    // public static void print(ListNode node) {
    //     ArrayList<Integer> vals = new ArrayList<>();
    //     if (node != null) {
    //         while (node.next != null) {
    //             vals.add(node.val);
    //             node = node.next;
    //         }
    //         // the last node
    //         vals.add(node.val);
    //     }
    //     System.out.println(vals.toString());
    // }
}

