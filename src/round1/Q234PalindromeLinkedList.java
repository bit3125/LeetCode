package round1;

import java.util.Stack;

import structures.ListNode;

public class Q234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head==null)
        	return true;
        
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while(p!=null){
        	stack.push(p.val);
        	p = p.next;
        }
        
        p = head;
        while(p!=null){
        	int n = stack.pop();
        	if (n!=p.val)
        		return false;
        	p = p.next;
        }
    	
    	return true;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
