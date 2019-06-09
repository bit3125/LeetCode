/**算法分析：分治法。
 * 定义s[i,len]为nums.substring(i, nums.length)  (,]
 * core函数用于得到s[curIdx, len]的next permutation，return 成功与否
 * 而得到s[curIdx, len]又得递归调用core函数去尝试得到s[curIdx+1,len]，若成功即完成，若失败则是如下情形：
 * s[curIdx+1,len]已经是其中所有元素的最大字典序即全逆序排列，而s[0,curIdx+1]则永远是其中所有元素的最小字典序
 * ，故此时要得到下一个全排列要做的就是让s[0,curIdx+1]的字典序增大最小值，即从s[curIdx+1,len]中寻找最小的
 * 满足比nums[curIdx]大的元素进行swap，然后对s[curIdx+1,len]进行升序排列得到其最小字典序序列，这时候就得到
 * 了下一个全排列return true。如果遍历完没有一个元素满足，则说明s[curIdx,len]也已经是最大字典序子串，return false
 * 
 * */

package round1;

import java.util.Arrays;

public class Q031NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums==null || nums.length==0)
        	return;
        
        if (!nextPermutationCore(nums, 0))
        	Arrays.sort(nums);
    }
    
    /**用于得到idx位开始(inclusive)的子串的next全排列
     * 
     * return : 是否成功得到
     * 定义s[i,len]为nums.substring(i, nums.length)  (,]
     * */
    public boolean nextPermutationCore(int[] nums, int curIdx){
    	if(curIdx>=nums.length-1) //递归出口
    		return false;
    	
    	if (nextPermutationCore(nums, curIdx+1)) //s[curIdx+1,len]得到了next permutation
    		return true;
    	else { //s[curIdx+1,len] 已经是子串的最后一个全排列(完全倒序)
    		for (int i=nums.length-1;i>curIdx;i--){ //尝试将s[curIdx+1,len]从后往前遍历
    			//，找寻最小的数（首个比nums[curIdx]大的数）使其满足“与s[0, curIdx+1]的nums[curIdx]交换后让s[0, curIdx+1]的字典序变大最小值（
    			//即要让它变大，但是又尽量要让他变大的小）”
    			if (nums[curIdx]<nums[i]){ //找到满足条件的最小元素，与nums[curIdx] swap
    				swap(nums, curIdx, i); 
    				Arrays.sort(nums, curIdx+1, nums.length);//将交换后的下位子串s[curIdx+1,len]排序成最小字典序子串
    				return true;
    			}
    		}
    		return false; //遍历结束后也找不到满足条件的一个元素， 说明s[curIdx,len]也已经是最大字典序全排列子串
    		//，return false，交给上层去处理
    	}
    }
    
    public void swap(int[] nums, int idx1, int idx2){
    	int tmp = nums[idx1];
    	nums[idx1] = nums[idx2];
    	nums[idx2] = tmp;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
