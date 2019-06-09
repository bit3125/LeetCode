/**算法分析：先用双指针永远分别指向子列的最后、最前一个数的二分查找找到边界，
 * 然后再使用offset的下标映射，在映射上对target做二分搜索
 * 
 * 映射公式：假定数列f向右偏移offset位后得到数列f`，那么f上下标i到f`上下标k的映射公式为：
 * k = (i+offset)%n
 * i = (k+n-offset)%n
 * 
 * 由于用了两次二分搜索，故复杂度为O(2*logn) = O(logn)
 * 
 * 基于此算法还可以再衍生出另一个算法：在求出offset之后，判断target是在前半段还是在后半段中，
 * 然后直接在两段有序中的一段中查找，就是经典的二分查找了
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
        	//front指向前半部分，rear指向后半部分
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
