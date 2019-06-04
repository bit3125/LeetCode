package leetcode.solutions;
import leetcode.structures.TreeNode;

public class Q111MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
    	if (root==null)//非法输入
    		return 0;
    	
    	return calMinDepth(root);
    }
    
    /* postOrder
     * 在visit之前进行了叶子节点与否的预判，若是则return1 故最终进入递归栈的时候绝不可能是叶子节点。
     * 对null（空节点）情况设置了统一的出口，return maxvalue，就不用分别对左右字数进行预判了
     * */
    public int calMinDepth(TreeNode root) {
    	if (root==null)//exit
    		return Integer.MAX_VALUE;
    	
		if (root.left==null && root.right==null)//叶子节点
			return 1;
		
		//非叶子节点
		int leftMinDepth = 0;
		int rightMinDepth = 0;
		leftMinDepth = calMinDepth(root.left);
		rightMinDepth = calMinDepth(root.right);
    	
    	return Integer.min(leftMinDepth, rightMinDepth)+1;
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
