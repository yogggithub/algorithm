package problems.$$0002_AddTwoNumbers;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString(){
        String string = "";
        ListNode temp = this;
        while (temp != null) {
            string += temp.val + ", ";
            temp = temp.next;
        }
        return string;
    }
}
