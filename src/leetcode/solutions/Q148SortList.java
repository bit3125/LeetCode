package leetcode.solutions;

import leetcode.structures.ListNode;

public class Q148SortList {

    public ListNode sortList(ListNode head) {
        if (head==null)
        	return head;
    	
    	return mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head){
    	if (head.next==null)//len==1.上游函数的入口检查已保证了len>=1，此处保证len>=2
    		return head;
    	
    	ListNode l1, l2;
    	ListNode[] ls = split(head);
    	
    	l1 = mergeSort(ls[0]);
    	l2 = mergeSort(ls[1]);
    	return merge(l1,l2);
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
    	//由于上游函数的入口检查，能保证输入的l1l2皆不为空,此处无需入口检查
    	
    	ListNode head = new ListNode(-1);
    	ListNode p1 = l1, p2 = l2, p=head;
    	while(p1!=null && p2!=null){
    		if (p1.val<p2.val){
    			p.next = p1;
    			p = p.next;
    			p1 = p1.next;
    		}else{
    			p.next = p2;
    			p = p.next;
    			p2 = p2.next;
    		}
    	}
    	while(p1!=null){
    		p.next = p1;
    		p = p.next;
    		p1 = p1.next;
    	}
    	while(p2!=null){
    		p.next = p2;
    		p = p.next;
    		p2 = p2.next;
    	}
    	
    	return head.next; 
    }
    
    public ListNode[] split(ListNode head){
    	//上游函数的入口检查已经保证了len>=2
    	ListNode p = head;
    	int cnt = 0;
    	while(p!=null){
    		p = p.next;
    		cnt++;
    	}
    	
    	p = head;
    	for (int i=0;i<cnt/2-1;i++)//返回mid前一位
    		p = p.next;
    	
    	ListNode[] rets = new ListNode[2];
    	rets[0] = head;
    	rets[1] = p.next;
    	p.next = null;
    	return rets;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
