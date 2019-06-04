package leetcode.solutions;

import leetcode.structures.ListNode;

public class Q160IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA==null||headB==null)
    		return null;
    	
    	int nA = 0, nB = 0;
    	ListNode p1, p2;
    	p1 = headA;
    	while(p1!=null){
    		p1 = p1.next;
    		nA++;
    	}
		p2 = headB;
    	while(p2!=null){
    		p2 = p2.next;
    		nB++;
    	}

    	//change A to the short one
    	p1 = nA<nB?headA:headB;
    	headB = nA<nB?headB:headA;
    	headA = p1;
    	
    	//steps forward dif steps
    	int dif = Math.abs(nB-nA);
    	p2 = headB;
    	for (int i=0;i<dif;i++)
    		p2 = p2.next;
    	//step together
    	p1 = headA;
    	while(p1!=null){ //&& p2!=null
    		if (p1==p2)
    			return p1;
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	
    	return null;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
