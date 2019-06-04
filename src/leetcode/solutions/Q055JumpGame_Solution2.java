/**�㷨������Tn = On^2
 * 1.���ݷ�
 * 2.��Ƿ�������������ɸ���� Tn = On^2
 * 3.��Ƿ����Ż��� Tn = On
 * 
 * ��solutionΪ3.��Ƿ����Ż�
 * ��Ȼ��nums���б�����ʹ��һ���������浱ǰ�ܵ������Զ��idx��
 * ÿ�θ���farestIdx�൱�ڶԱ�Ƿ��е�boolean���������һ��O(n)�ı������
 * ���ܰ�Tn�Ż������ԣ�������Ϊʡȥ��ÿ�ζ�boolean����ı������
 * farestIdx��ʾfarestIdx��ǰ������idx���ǿɴ��
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
		// TODO �Զ����ɵķ������

	}

}
