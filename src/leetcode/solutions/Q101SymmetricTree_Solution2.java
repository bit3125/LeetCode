package leetcode.solutions;
/**�㷨������
 * ʹ�õݹ鶨�巨�������������������
 * 
 * ����һ����Ϊ�����������ҽ���������������Ϊ����ʱ����Ϊ������
 * ������������Ϊ���񣺵��ҽ���
 * 1.root1.val == root2.val
 * 2.isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left)
 * 
 * */
import java.util.ArrayList;
import java.util.List;

import leetcode.structures.TreeNode;

public class Q101SymmetricTree_Solution2 {

    public boolean isSymmetric(TreeNode root) {
    	if (root==null)
    		return true;
    	
    	return true;
    }
   
    public boolean isSymmetric(TreeNode root1, TreeNode root2){
    	if (root1==null && root2==null)
    		return true;
    	else if (root1==null || root2==null)
    		return false;
    	
    	//else
    	return root1.val==root2.val 
    	&& isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    	
    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
