/**算法分析：首先使用递归的方式来分析问题。
 * 每个节点为根的树能达到的最大值分为两种情况讨论：
 * 1.偷取本节点；doStealThisValue
 * 2.不偷取本节点； noStealThisValue
 * 而两种情况的最大值，都取决于左右子树分别的doStealThisValue与noStealThisValue
 * 故很容易形成二叉树的递归
 * 
 * 但是在写出递归解法后会发现，由于对两组dp分别进行计算，于是其中存在着大量的重复解，不可取 ， Time limited
 * 于是想到，使用树形动规，参考Solution2
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
		// TODO 自动生成的方法存根

	}

}
