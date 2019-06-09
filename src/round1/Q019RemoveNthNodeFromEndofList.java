package round1;

import structures.ListNode;

public class Q019RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null||n<1)
        	return null;
        
        ListNode p = head, targetPrev = head;
    	
        int len=0;
        while(p!=null){
        	p = p.next;
        	len++;
        }
        if (n==len)
        	return head.next;
        for (int i=0;i<len-n-1;i++)
        	targetPrev = targetPrev.next;
        
    	//remove
    	ListNode target = targetPrev.next;
    	targetPrev.next = target.next;
    	target.next = null;//delete
    	
    	return head;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
