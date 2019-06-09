/**�㷨����������ʹ�õݹ�ķ�ʽ���������⡣
 * ÿ���ڵ�Ϊ�������ܴﵽ�����ֵ��Ϊ����������ۣ�
 * 1.͵ȡ���ڵ㣻doStealThisValue
 * 2.��͵ȡ���ڵ㣻 noStealThisValue
 * ��������������ֵ����ȡ�������������ֱ��doStealThisValue��noStealThisValue
 * �ʺ������γɶ������ĵݹ�
 * 
 * ������д���ݹ�ⷨ��ᷢ�֣����ڶ�����dp�ֱ���м��㣬�������д����Ŵ������ظ��⣬����ȡ �� Time limited
 * �����뵽��ʹ�����ζ��棬�ο�Solution2
 * */

package round1;

import structures.TreeNode;

public class Q337HouseRobberIII {

    public int rob(TreeNode root) {
        if (root==null)
        	return 0;
    	
    	return Integer.max(robCore(root, true), robCore(root, false));
    }
    
    public int robCore(TreeNode root, boolean stealThis){
    	if (root==null)
    		return 0;
    	
    	int noStealLeftValue = robCore(root.left, false);
    	int doStealLeftValue = robCore(root.left, true);
    	int noStealRightValue = robCore(root.right, false);
    	int doStealRightValue = robCore(root.right, true);
    	
    	if (stealThis)
    		return noStealLeftValue + noStealRightValue + root.val;
    	else //do not steal this
    		return Integer.max(
    				Integer.max(
    						Integer.max(noStealLeftValue + doStealRightValue, doStealLeftValue + noStealRightValue)
    						, doStealLeftValue + doStealRightValue)
    				, noStealLeftValue + noStealRightValue);
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
