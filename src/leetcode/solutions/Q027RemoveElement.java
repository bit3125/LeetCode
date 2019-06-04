package leetcode.solutions;

public class Q027RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums==null || nums.length==0)
        	return 0;
        
        int front = 0;
        int rear = nums.length-1;
        int tmp;
        while(front<=rear){
        	if (nums[front]==val){
        		nums[front] = nums[rear];
        		rear--;
        	}else{
        		front++;
        	}
        }
    	
        return rear+1;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
