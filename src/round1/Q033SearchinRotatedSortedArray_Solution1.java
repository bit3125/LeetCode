/**�㷨����������˫ָ����Զ�ֱ�ָ�����е������ǰһ�����Ķ��ֲ����ҵ��߽磬
 * Ȼ����ʹ��offset���±�ӳ�䣬��ӳ���϶�target����������
 * 
 * ӳ�乫ʽ���ٶ�����f����ƫ��offsetλ��õ�����f`����ôf���±�i��f`���±�k��ӳ�乫ʽΪ��
 * k = (i+offset)%n
 * i = (k+n-offset)%n
 * 
 * �����������ζ����������ʸ��Ӷ�ΪO(2*logn) = O(logn)
 * 
 * ���ڴ��㷨����������������һ���㷨�������offset֮���ж�target����ǰ��λ����ں����У�
 * Ȼ��ֱ�������������е�һ���в��ң����Ǿ���Ķ��ֲ�����
 * */

package round1;

public class Q033SearchinRotatedSortedArray_Solution1 {

    public int search(int[] nums, int target) {
        if (nums==null||nums.length==0)
        	return -1;
        
        int n = nums.length;
        int front, rear, mid;
        int offset;
        
        //search for boundary
        if (nums[0]<nums[n-1]){
        	offset = 0;
        }else{
        	front = 0; 
        	rear = nums.length-1;
        	//frontָ��ǰ�벿�֣�rearָ���벿��
        	while(rear-front>1){//***bug:rear-front==1
        		mid = (front+rear)/2;
        		if (nums[mid]>nums[front]){
        			front = mid;
        		}else{ //nums[mid]<nums[front]
        			rear = mid;
        		}
        	}
        	offset = front+1;
        }
        
        //search for target
        front = 0;
        rear = n-1;
        while (front<=rear){
        	mid = (front+rear)/2;
        	int midMap = p(mid, offset, n);
        	if (nums[midMap]<target){
        		front = mid+1;
        	}else if (nums[midMap]>target){
        		rear = mid-1;
        	}else{
        		return midMap;
        	}
        }
        
        return -1;
    }
	
    public int p(int i, int offset, int n){
    	return (i+offset)%n;
    }
    
    public int pInv(int k, int offset, int n){
    	return (k+n-offset)%n;
    }
    
	public static void main(String[] args) {
		Q033SearchinRotatedSortedArray_Solution1 q = new Q033SearchinRotatedSortedArray_Solution1();
//		int[] nums = {1,3};
//		int target = 1;
		int[] nums = {3,5,1};
		int target = 5;
		
		
		System.out.println(q.search(nums, target));
		
	}

}
