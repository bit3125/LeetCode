/**算法分析：return的值有三种状态：
 * 1. p || q :表示此子树包含有p || q
 * 2. null :表示此子树不含pq
 * 3. {r | r!=p && r!=q} : 表示r是pq的最近公共祖先，即为所求
 * 
 * 省去了记录路径的Deque的开销，以及对俩链表进行pop寻找公共节点的开销，故时间空间都提升了
 * */
package round1;

import java.util.Deque;
import java.util.LinkedList;

import structures.TreeNode;

public class Q236LowestCommonAncestorofaBinaryTree_Solution3 {

	boolean found = false;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
	    if( found || root==null) //递归出口 2.
	    	return null;
	    
	    if (root==p || root==q) // 1. found p||q 
	    	return root;
	    //else
	    //后序遍历
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
		// TODO 自动生成的方法存根

	}

}
