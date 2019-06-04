package leetcode.solutions;

import leetcode.structures.ListNode;

public class Q142LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head==null)
        	return null;
        
        //hasCycle or not
        ListNode oneNode = hasCycle(head);
        if (oneNode==null)
        	return null;
        //cnt cycle len
        int cnt = cntCycle(oneNode);
        
        //search for the entry
        ListNode p1 = head, p2 = head;
        for (int i=0;i<cnt;i++)
        	p1 = p1.next;
        while(p1!=p2){
        	p1 = p1.next;
        	p2 = p2.next;
        }
    	
    	return p1;
    }
    
    public ListNode hasCycle(ListNode head){
    	if (head==null)
    		return null;
    	
    	ListNode p1 = head, p2 = head;
    	while(p1!=null){
    		p1 = p1.next;
    		if (p1==null)
    			break;
    		p1 = p1.next;//2 steps
    		p2 = p2.next;//1 step
    		
    		if (p1==p2)
    			return p1;
    	}
    	
    	return null;
    }
    
    public int cntCycle(ListNode oneNode){
    	ListNode p = oneNode;
    	int cnt = 1;
    	p = p.next;
    	while(p!=oneNode){
    		p = p.next;
    		cnt++;
    	}
    	return cnt;
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
