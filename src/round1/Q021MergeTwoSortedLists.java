/**算法分析：本质是归并排序
 * 
 * */

package round1;

import structures.ListNode;

public class Q021MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null)
        	return null;
    	
        ListNode newHead, p1, p2, p3;
        newHead = new ListNode(-1);
        p1 = l1;
        p2 = l2;
        p3 = newHead;
        while(p1!=null&&p2!=null){
        	if (p1.val<p2.val){
        		p3.next = p1;
        		p1 = p1.next;
        	}else{
        		p3.next = p2;
        		p2 = p2.next;
        	}
        	p3 = p3.next;
    		p3.next = null;
        }
        if (p1!=null)
        	p3.next = p1;
        if (p2!=null)
        	p3.next = p2;
        
        return newHead.next;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
