/**算法分析：基于普通二分搜索，把target判断条件加以修改
 * 
 * */

package round1;

public class Q034FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
//        if (nums==null||nums.length==0)
        int[] bounds = new int[2];
        
        bounds[0] = findBoundary(nums, target, 'l');
        bounds[1] = findBoundary(nums, target, 'r');
        return bounds;
    } 
	
    public int findBoundary(int[] nums, int target, char lor){
//    	if (nums==null||nums.length==0)
//    		return -1;
    		
    	int front = 0;
        int rear = nums.length-1;
        int mid;
        while(front<=rear){
        	mid = (front+rear)/2;
        	if (target>nums[mid]){
        		front = mid+1;
        	}else if(target<nums[mid]){
        		rear = mid-1;
        	}else{//target==nums[mid]
        		if (lor=='l'){//left
        			if (mid==0||nums[mid-1]!=target){//left boundary
            			return mid;
            		}else
            			rear = mid-1;
        		}else if (lor=='r'){//right
        			if (mid==nums.length-1||nums[mid+1]!=target){//left boundary
            			return mid;
            		}else
            			front = mid+1;
        		}
        	}
        	
        }
        
        return -1;
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
