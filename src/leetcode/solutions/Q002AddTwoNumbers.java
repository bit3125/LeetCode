package leetcode.solutions;

public class Q002AddTwoNumbers {

	class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x;}
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1==null||l2==null)
    		return null;
    	
    	ListNode resultHead = new ListNode(-1), resultTail = resultHead;//先使用一个头结点，最后再去掉
    	ListNode sum;
    	ListNode p1 = l1, p2 = l2;
    	int carry = 0;
    	
    	while (p1!=null&&p2!=null){
    		//add
    		sum = new ListNode(-1);
    		carry = addTwoNode(p1, p2, sum, carry);
    		//join
    		resultTail.next = sum;
    		//next
    		resultTail = resultTail.next;
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	
    	//处理两链不等长的情况
    	while(p1!=null){
    		p1.val += carry;
    		carry = p1.val/10;
    		p1.val %= 10;
    		
    		resultTail.next = p1;
    		resultTail = resultTail.next;
    		p1 = p1.next;
    	}
    	while(p2!=null){
    		p2.val += carry;
    		carry = p2.val/10;
    		p2.val %= 10;
    		
    		resultTail.next = p2;
    		resultTail = resultTail.next;
    		p2 = p2.next;
    	}
    	
    	//处理最后的进位
    	if (carry!=0){
    		resultTail.next = new ListNode(carry);
    	}
    	
    	resultHead = resultHead.next;
    	return resultHead;
    }
	
    public int addTwoNode(ListNode l1, ListNode l2, ListNode sum, int carry){

    	sum.val = l1.val+l2.val+carry;
    	carry = sum.val/10;
    	sum.val = sum.val%10;
    	return carry;
    }
    
    public ListNode createLinkedList(int[] array){
    	ListNode head = new ListNode(-1);
    	ListNode tail = head;
    	
    	for (int val:array){
    		 tail.next= new ListNode(val);
    		 tail = tail.next;
    	}
    	
    	head = head.next;
    	return head;
    }
    public void printLinkedList(ListNode l){
    	ListNode p = l;
    	while(p!=null){
    		System.out.print(p.val+",");
    		p = p.next;
    	}
    	System.out.println();
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Q002AddTwoNumbers q = new Q002AddTwoNumbers();
		ListNode l1 = q.createLinkedList(new int[]{1});
		ListNode l2 = q.createLinkedList(new int[]{9,9});
		q.printLinkedList(l1);
		q.printLinkedList(l2);
		
		System.out.println();
		ListNode result = q.addTwoNumbers(l1, l2);
		q.printLinkedList(result);
		
	}
}





