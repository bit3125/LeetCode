package round1;
import java.util.Arrays;

public class Q080RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {
    	if (nums==null || nums.length==0)
    		return 0;
    	
    	int front = 0;
    	int rear = 0;
    	int cnt = 1;
    	while(rear<nums.length){
    		//��������ͬ�Σ�idxָ��ö����һ������
    		while(rear+1<nums.length && nums[rear]==nums[rear+1]){
    			cnt++;
    			rear++;
    		}
    		
    		//������ͬ��
    		cnt = cnt<=2?cnt:2;
    		for (int i=0;i<cnt;i++){
    			nums[front] = nums[rear];
    			front++;
    		}
    		rear++;
    		cnt = 1;
    	}
    	
    	return front;
    }
	
	public static void main(String[] args) {
		Q080RemoveDuplicatesfromSortedArrayII q = new Q080RemoveDuplicatesfromSortedArrayII();
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		System.out.println(q.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

}
