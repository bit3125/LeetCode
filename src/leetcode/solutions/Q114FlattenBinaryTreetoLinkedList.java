package leetcode.solutions;

import leetcode.structures.TreeNode;

public class Q114FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
    	flattenCore(root);
    }
   
    public TreeNode flattenCore(TreeNode root){
    	if (root==null)
    		return null;
    	
    	// traverse
    	TreeNode left = flattenCore(root.left);
    	TreeNode right = flattenCore(root.right);
    	//clear
    	root.left = null;
    	root.right = null;
    	
    	return mergeLists(mergeLists(root, left), right); //preOrder
    }
    
    public TreeNode mergeLists(TreeNode l1, TreeNode l2){
    	if (l1==null)
    		return l2;
    	
    	TreeNode curNode = l1;
    	while(curNode.right!=null)
    		curNode = curNode.right;
    	curNode.right = l2;
    	
    	return l1;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
