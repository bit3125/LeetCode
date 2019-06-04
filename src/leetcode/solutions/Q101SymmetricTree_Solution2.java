package leetcode.solutions;
/**算法分析：
 * 使用递归定义法，来解决镜像树的问题
 * 
 * 定义一棵树为镜像树：当且仅当其左右子树互为镜像时，其为镜像树
 * 定义两棵树互为镜像：当且仅当
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
		// TODO 自动生成的方法存根

	}

}
