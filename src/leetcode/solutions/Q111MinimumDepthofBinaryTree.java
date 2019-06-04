package leetcode.solutions;
import leetcode.structures.TreeNode;

public class Q111MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
    	if (root==null)//�Ƿ�����
    		return 0;
    	
    	return calMinDepth(root);
    }
    
    /* postOrder
     * ��visit֮ǰ������Ҷ�ӽڵ�����Ԥ�У�������return1 �����ս���ݹ�ջ��ʱ�����������Ҷ�ӽڵ㡣
     * ��null���սڵ㣩���������ͳһ�ĳ��ڣ�return maxvalue���Ͳ��÷ֱ��������������Ԥ����
     * */
    public int calMinDepth(TreeNode root) {
    	if (root==null)//exit
    		return Integer.MAX_VALUE;
    	
		if (root.left==null && root.right==null)//Ҷ�ӽڵ�
			return 1;
		
		//��Ҷ�ӽڵ�
		int leftMinDepth = 0;
		int rightMinDepth = 0;
		leftMinDepth = calMinDepth(root.left);
		rightMinDepth = calMinDepth(root.right);
    	
    	return Integer.min(leftMinDepth, rightMinDepth)+1;
    }
    
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
