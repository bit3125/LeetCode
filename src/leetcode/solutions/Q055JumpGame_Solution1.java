/**�㷨������
 * 1.���ݷ�
 * 2.��Ƿ�������������ɸ����Tn = On^2
 * 3.��Ƿ����Ż�
 * 
 * ��solutionΪ2.��Ƿ�
 * */

package leetcode.solutions;

import java.util.Arrays;

public class Q055JumpGame_Solution1 {

    public boolean canJump(int[] nums) {
    	if (nums==null||nums.length==0)
    		return false;
    	
    	boolean[] reachable = new boolean[nums.length];
    	Arrays.fill(reachable, false);
    	reachable[0] = true;
    	
    	for (int i=0;i<reachable.length;i++){
    		if (reachable[i]==false)
    			continue;
			for (int j=1;i+j<nums.length&&j<=nums[i];j++)
				reachable[i+j] = true;
			if (reachable[reachable.length-1]==true)
				return true;
    	}
    	
    	return reachable[reachable.length-1];
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
