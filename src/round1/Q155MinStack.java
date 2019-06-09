package round1;

import java.util.Stack;

public class Q155MinStack {

	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;
	
    /** initialize your data structure here. */
    public Q155MinStack() {
    	dataStack = new Stack<>();
    	minStack = new Stack<>();
    }
    
    public void push(int x) {
        dataStack.push(x);
        minStack.push(Math.max(minStack.isEmpty()?Integer.MAX_VALUE:minStack.peek(), x));
    }
    
    public void pop() {
    	if (!dataStack.empty()){
    		dataStack.pop();
    		minStack.pop();
    	}
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
