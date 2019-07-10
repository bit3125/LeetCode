package round2.Q155MinStack;

import java.util.Stack;

class MinStack {

    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    /** initialize your dataStack structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        minStack.push(minStack.isEmpty() ? x : Integer.min(minStack.peek(), x));
    }

    public void pop() {
        if (dataStack.isEmpty())
            return;

        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        if (dataStack.isEmpty())
            return Integer.MIN_VALUE;

        return dataStack.peek();
    }

    public int getMin() {
        if (dataStack.isEmpty())
            return Integer.MIN_VALUE;
        return minStack.peek();
    }
}