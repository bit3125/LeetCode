/**算法分析：剑指offer原题
 * 排序后搜索复杂度为O(nlogn)
 * 复杂度为On的算法：线性遍历数组，将每个数字都放置到其数值对应的下标位上
 * ， 当遇见某位上已有正确的数时，就是重复数，直接return
 * 
 * */

package leetcode.solutions;

public class Q287FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        if (nums==null||nums.length==0)
        	return -1;
        
        int idx = 0;
        while(idx<nums.length){
        	int curNum = nums[idx];//当前待归位数字(1.增强可读性；2.swap时起到tmp的作用)
        	if (idx==curNum){//判断当前待归位数字是否已经在其正确位置上，若是当前数完成归位，i++
        		idx++;
        		continue;
        	}
        	//else
        	if (nums[curNum]==curNum){//搜索待归位数字的正确位置，判断该位上是否已有相等数，若有则return
        		return curNum;
        	}else{
        		//swap->归位
        		nums[idx] = nums[curNum];
        		nums[curNum] = curNum;
        	}
        }
        
    	return -1;//will never be execute
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
