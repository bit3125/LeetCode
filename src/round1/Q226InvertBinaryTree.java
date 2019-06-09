package round1;

import structures.TreeNode;

public class Q226InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
    	if (root==null)
    		return null;
    	
    	TreeNode tmp;
    	tmp = invertTree(root.right);
    	root.right = invertTree(root.left);
    	root.left = tmp;
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
