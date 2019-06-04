package leetcode.solutions;

import leetcode.structures.TreeNode;

public class Q105ConstructBinaryTreefromPreorderandInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder==null || inorder==null || preorder.length==0 || inorder.length==0)
			return null;
		
		return buildTreeCore(preorder, inorder, 0, preorder.length, 0, inorder.length);
	}

	public TreeNode buildTreeCore(int[] pre, int[] in, 
			int preStart, int preEnd, int inStart, int inEnd) {
		if (preStart>=preEnd || inStart>=inEnd) //TODO
			return null;
		
		TreeNode root = new TreeNode(pre[preStart]);
		int rootIdxAtIn= findIdx(in, inStart, inEnd, pre[preStart]);
	 	int leftTreeCnt = rootIdxAtIn-inStart; //***bug:在in中统计左子树节点个数，而非去在pre中寻找左子树边界
	 	root.left = buildTreeCore(pre, in, preStart+1, preStart+1+leftTreeCnt, inStart, rootIdxAtIn);
	 	root.right = buildTreeCore(pre, in, preStart+1+leftTreeCnt, preEnd, rootIdxAtIn+1, inEnd);
	 	
		return root;
	}
	
	public int findIdx(int[] data, int start, int end, int target){
		for (int i=start;i<end;i++)
			if (data[i]==target)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		int[] pre = {3,2,1,4};
		int[] in = {1,2,3,4};
		
		Q105ConstructBinaryTreefromPreorderandInorderTraversal q = new Q105ConstructBinaryTreefromPreorderandInorderTraversal();
		q.buildTree(pre, in);
		
	}

}
