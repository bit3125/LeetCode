package round1;
/**�����˼·��
 * ʹ�� �������ĩβ��������������ж��Ƿ�д��ı�׼�������Ϳ��Զ�ÿһλ�����ã�����Ҫ��Ƕѭ��
 * Q080ͬ��Ҳ������ôд��
 * 
 * */

import java.util.Arrays;

public class Q026RemoveDuplicatesfromSortedArray_Solution2 {

    public int removeDuplicates(int[] nums) {
    	if (nums==null || nums.length==0)
    		return 0;
    	
    	int front = 1;
    	int rear = 1;
    	while(rear<nums.length){
    		//��ÿ����ͬ�εĵ�һ������д��
    		if (nums[rear]!=nums[front-1]){
    			nums[front] = nums[rear];
    			front++;
    		}
			rear++;
    	}
    	
    	return front;
    }
	
	public static void main(String[] args) {
		Q026RemoveDuplicatesfromSortedArray_Solution2 q = new Q026RemoveDuplicatesfromSortedArray_Solution2();
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		System.out.println(q.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

}
