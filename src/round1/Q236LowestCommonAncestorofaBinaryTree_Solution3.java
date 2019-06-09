/**�㷨������return��ֵ������״̬��
 * 1. p || q :��ʾ������������p || q
 * 2. null :��ʾ����������pq
 * 3. {r | r!=p && r!=q} : ��ʾr��pq������������ȣ���Ϊ����
 * 
 * ʡȥ�˼�¼·����Deque�Ŀ������Լ������������popѰ�ҹ����ڵ�Ŀ�������ʱ��ռ䶼������
 * */
package round1;

import java.util.Deque;
import java.util.LinkedList;

import structures.TreeNode;

public class Q236LowestCommonAncestorofaBinaryTree_Solution3 {

	boolean found = false;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
	    if( found || root==null) //�ݹ���� 2.
	    	return null;
	    
	    if (root==p || root==q) // 1. found p||q 
	    	return root;
	    //else
	    //�������
	    TreeNode left = lowestCommonAncestor(root.left, p, q);
	    TreeNode right = lowestCommonAncestor(root.right, p, q);
	    if(left!=null && right!=null){ // 3. found LCA
	        found = true;
	        return root;
	    }else //1. (left||right==p||q) || (left==null&&right==null)
	    	return left!=null?left:right; 
	    			
//	    else if(left!=null) // left==p||q
//	        return left;
//	    else if(right!=null)  //right==p||q
//	        return right;
//	    return null;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
