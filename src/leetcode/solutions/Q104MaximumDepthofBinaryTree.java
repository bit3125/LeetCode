package leetcode.solutions;

import leetcode.structures.TreeNode;

public class Q104MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root==null)
        	return 0;
        
        return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
