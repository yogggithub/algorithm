package $0155_MinStack;

/*
 * Design a stack that supports push, pop, top, and retrieving
 * the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * */

import java.util.Stack;

public class self {

    public static void main(String[] args) {
        self minStack = new self();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    /**
     * initialize your data structure here.
     */

    Stack<Integer> elementData = new Stack<>();;

    public self() {
        // elementData = new Stack<>();
    }

    public void push(int x) {
        elementData.push(x);
    }

    public void pop() {
        elementData.pop();
    }

    public int top() {
        return elementData.peek();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int num : elementData) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Runtime: 980 ms, faster than 5.01% of Java online submissions for Min Stack.
    // Memory Usage: 56.4 MB, less than 5.08% of Java online submissions for Min Stack.
}
