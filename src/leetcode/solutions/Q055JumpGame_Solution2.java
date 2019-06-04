/**算法分析：Tn = On^2
 * 1.回溯法
 * 2.标记法，类似于素数筛法， Tn = On^2
 * 3.标记法的优化， Tn = On
 * 
 * 本solution为3.标记法的优化
 * 依然对nums进行遍历，使用一个变量保存当前能到达的最远的idx，
 * 每次更新farestIdx相当于对标记法中的boolean数组进行了一次O(n)的遍历标记
 * 故能把Tn优化到线性，就是因为省去了每次对boolean数组的遍历标记
 * farestIdx表示farestIdx往前的所有idx都是可达的
 * */

package leetcode.solutions;

import java.util.Arrays;

public class Q055JumpGame_Solution2 {

    public boolean canJump(int[] nums) {
    	if (nums==null||nums.length==0)
    		return false;
    	
    	int farestIdx = 0;
    	for (int i=0;i<nums.length;i++){
    		if (farestIdx<i)
    			return false;
    		int newIdx = i+nums[i];
    		if (newIdx>farestIdx)
    			farestIdx = newIdx;
    		if (farestIdx>=nums.length-1)
    			return true;
    	}
    	
    	return false;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
