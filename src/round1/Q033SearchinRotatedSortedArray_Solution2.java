/**算法分析：直接在原数组上进行二分搜索
 * 使用front mid rear划分后，该数组有一个特点：[front,mid] [mid, rear]中至少有一个为有序
 * 会有两种情况：
 * 1.有且仅有一个子列有序；
 * 2.两者都是有序，也即此时[front, rear]数列已经是一个普通有序数列
 * 可利用两个子列中的有序子列对搜索范围进行压缩
 * 具体见下方代码
 * 
 * */

package round1;

public class Q033SearchinRotatedSortedArray_Solution2 {

	public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){//典型的二分搜索while判断条件
            int mid = (start + end) / 2;
            
            if (nums[mid] == target)
                return mid;
            
            //else
            if (nums[start] <= nums[mid]){ //前半段有序
                 if (target < nums[mid] && target >= nums[start])//target在此段中
                    end = mid - 1;//把end压到mid-1上
                 else//target在另一段中
                    start = mid + 1;//把start压到mid+1上
                 
                 //当[front, rear]已为一个普通有序数列，
                 //那么每趟while都退化为只会执行上方的五行代码，下方的else就失效了
            }else{ //(nums[mid] <= nums[end]) //后半段有序
                if (target > nums[mid] && target <= nums[end])//target在此段中
                    start = mid + 1;
                 else
                    end = mid - 1;
            }
        }
        return -1;
    }
	
	
	public static void main(String[] args) {
		Q033SearchinRotatedSortedArray_Solution2 q = new Q033SearchinRotatedSortedArray_Solution2();
//		int[] nums = {1,3};
//		int target = 1;
		int[] nums = {3,5,1};
		int target = 5;
		
		
		System.out.println(q.search(nums, target));
		
	}

}
