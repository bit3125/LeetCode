package round1;

public class Q141LinkedListCycle {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public boolean hasCycle(ListNode head) {
    	if (head==null)
    		return false;
    	
    	ListNode p1 = head.next, p2 = head;
    	
    	while (p1!=null){
    		if (p1==p2)
    			return true;
    		
    		p1 = p1.next;
    		if (p1==null)
    			break;
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	
    	return false;
    }
    
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
