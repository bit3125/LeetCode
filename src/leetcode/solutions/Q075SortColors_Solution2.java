/**算法分析：采用了基于数组分为奇偶子列的头尾双指针法，这个算法是跟partition类似的，注意比较
 * 使用三个指针，将数组分为“0”“1”“0”三个子列：front, mid, rear。
 * 三个子列的范围分别为 [0,front), [front,mid), (rear, nums.length)， 然后[mid, rear]则为未搜索区域
 * 该算法的关键一点是，使用“swap”，而非“overwrite”，这也是与partition的区别所在
 * 1.partition算法中，由于提前将nums[0]抽离到了pivot变量中存储起来，所以nums中多了一个空位出来，故
 * 	首或尾指针其中静止的那个指向的就是空位，每次做的是"overwrite"而非"swap"
 * 2.划分奇偶子列的算法中，没有变量去暂存某个数，整个数列是满的，故每次做的是"swap"而非"overwrite"，本题算法同理
 * 
 * 在每次循环中，做swap的时候分为以下情况：
 * 1.nums[mid]==0 rear与mid swap
 * 	直接swap即可，mid边界不变，rear边界--
 * 2.nums[mid]==2 front与mid swap
 * 由于front与mid的相对位置不确定，故要分为以下情况讨论（画图出来看就比较清晰）
 * 	1>.front=k, mid>=k+2.[0,front)为0子列, [front,mid)为1子列，故交换到mid上的是1，故front++ mid++
 * 	2>.front=k, mid=k+1. 两个指针挨在一起。画图可知与1>.情况相同
 * 	3>.front=k, mid=k. 两个指针重合相等。画图可知此时1子列长度为0，若front++ mid也得++
 * 综上所述，2.的所有情况下，指针变化都是front++ mid++
 * 3.nums[mid]==1 不用做swap
 * 1子列增长，mid++
 * 
 * */

package leetcode.solutions;

import java.util.Arrays;

public class Q075SortColors_Solution2 {
	
	public void sortColors(int[] nums) {
        if (nums==null||nums.length==0)
        	return;
        
        int front = 0, rear = nums.length-1, mid = front;
        while(mid<=rear){
        	if (nums[mid]==0){
        		swap(nums, front++, mid++);
        	}else if (nums[mid]==2){
    			swap(nums, rear--, mid);
    		}else{
    			mid++;
    		}
        }
        
    }
	
	public void swap(int[] nums, int idx1, int idx2){
		int tmp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = tmp;
	}
	
	public static void main(String[] args) {
		Q075SortColors_Solution2 q = new Q075SortColors_Solution2();
		int[] nums = new int[]{1,0};
		q.sortColors(nums);
		
		System.out.println(Arrays.toString(nums));
		
	}

}
