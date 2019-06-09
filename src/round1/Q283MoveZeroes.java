package round1;

public class Q283MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums==null||nums.length==0)
        	return ;
        
        int front = 0, rear = 0;
        while(rear<nums.length){
        	if (nums[rear]!=0){
        		if (front<rear)
        			nums[front] = nums[rear];
        		front++;
        	}
        	rear++;
        }
        while(front<nums.length){
        	nums[front++] = 0;
        }
        
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
