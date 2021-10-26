package top_interview_questions.easy.design;

public class MinStack {

    /*
     * Solution v1: Brute Force
     *
     * Runtime: 130 ms @ (beats) 6.84%
     * Memory Usage: 43.1 MB @ (beats) 53.37%
     */
    // private Stack<Integer> stack;
    // private int min;
    // private ArrayList<Integer> list;
    //
    // public MinStack() {
    //     stack = new Stack<>();
    //     min = Integer.MAX_VALUE;
    //     list = new ArrayList<>();
    // }
    //
    // public void push(int val) {
    //     stack.push(val);
    //     list.add(val);
    //     Collections.sort(list);
    //     this.min = list.get(0);
    // }
    //
    // public void pop() {
    //     list.remove(stack.pop());
    //     if (list.size() == 0) {
    //         this.min = Integer.MIN_VALUE;
    //     } else {
    //         Collections.sort(list);
    //         this.min = list.get(0);
    //     }
    // }
    //
    // public int top() {
    //     return stack.peek();
    // }
    //
    // public int getMin() {
    //     return this.min;
    // }

    /*
     * (learn from Internet)
     * Solution v2.1: Assign current min to every node
     * Solution v2.2: Use an Stack instead of Node, put int[2] into Stack to keep val and min
     */
    private Node head;

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

