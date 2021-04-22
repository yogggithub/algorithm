package $0155_MinStack;

public class solution {
    public static void main(String[] args) {
        solution minStack = new solution();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


    // Approach 1: 存储次小值，pop两位。

    /*
     * Core Idea: 理解此方法的重要提示，否则理解起来很费劲
     * 1.Minimum value is always followed by the second minimum value
     * (duplicate value of the second minimum value,
     * to ensure that when pop function removes the 2nd min,
     * it does not disrupt the stack order).
     *
     * 2.And while popping you pop min and 2nd min so that,
     * you get the correct min value for the remaining stack
     * and the remaining stack top also points to the right place.
     *
     * */

    // int min = Integer.MAX_VALUE;
    // Stack<Integer> stack = new Stack<Integer>();
    //
    // public void push(int x) {
    //     // only push the old minimum value when the current
    //     // minimum value changes after pushing the new value x
    //     if (x <= min) {
    //         stack.push(min);
    //         min = x;
    //     }
    //     stack.push(x);
    //
    //     /*
    //      * 判断后，在顶端存了两个特定值：
    //      *      最顶点：传入数值，这是为了保证stack的次序正确
    //      *      次顶点：前最小值（次小值）
    //      * 在传入值大于min时，直接传入在顶点
    //      * 在传入只小于min时，刷新min，并顺序存储min（当前次小值）、传入值
    //      *
    //      * stack中最多是存储了5个：
    //      * MAX_VALUE, -2, 0, -2, -3
    //      *
    //      * */
    // }
    //
    // public void pop() {
    //     // if pop operation could result in the changing
    //     // of the current minimum value,
    //     // pop twice and change the current minimum value
    //     // to the last minimum value.
    //     if (stack.pop() == min) {
    //         min = stack.pop();
    //     }
    //     /*
    //      * 理解：
    //      * 每一个pop()都会踢掉顶点：判断一次，赋值一次
    //      * true时，会踢掉顶两位，并将min改变为次小值
    //      * false时，会踢掉顶点
    //      *
    //      * */
    // }
    //
    // public int top() {
    //     return stack.peek();
    // }
    //
    // public int getMin() {
    //     return min;
    // }


    // Approach 2: 存储gap

    /*
     * 思路：源自问题的hint
     * 在存储的过程中判断min，然后存储的并不是原始值，
     * 而是原始值与当时min的差值
     * 在输出top时，根据min和差值反推原始值
     * 在踢掉顶点时，要改变min以反应剩余的min
     *
     * */
    // long min;
    // Stack<Long> stack;
    //
    // public solution() {
    //     stack = new Stack<>();
    // }
    //
    // public void push(int x) {
    //     if (stack.isEmpty()) {
    //         stack.push(0L);
    //         min = x;
    //     } else {
    //         stack.push(x - min);
    //         //Could be negative if min value needs to change
    //         if (x < min){
    //             min = x;
    //         }
    //     }
    //     // stack中实际存储：0, 2, -1
    // }
    //
    // public void pop() {
    //     if (stack.isEmpty()){
    //         return;
    //     }
    //
    //     long pop = stack.pop();
    //
    //     if (pop < 0) {
    //         min = min - pop;
    //         //If negative, increase the min value
    //     }
    // }
    //
    // public int top() {
    //     long top = stack.peek();
    //     if (top > 0) {
    //         return (int) (top + min);
    //     } else {
    //         return (int) min;
    //     }
    // }
    //
    // public int getMin() {
    //     return (int) min;
    // }


    // Approach 3: Node法

    /*
     * 思路：实际是一种迭代的思路，更加虚化
     * 建立一个对象类
     * 以传入值、当时最小值（需判断）、前一代作为该类的属性
     * 则pop则推至前一代，top直接输出节点，min直接输出属性即可
     *
     * */

    private Node head;

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
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

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
