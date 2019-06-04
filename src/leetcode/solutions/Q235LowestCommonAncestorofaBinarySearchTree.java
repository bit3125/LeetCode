package leetcode.solutions;
import java.util.LinkedList;
import java.util.Queue;

public class Q235LowestCommonAncestorofaBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root==null || p==null || q==null)
			return null;
		
		TreeNode pNode1 = root, pNode2 = root;
		TreeNode pAncestor = root;
		while(pNode1==pNode2){
			pAncestor = pNode1;
			
			if (p.val<pNode1.val)
				pNode1 = pNode1.left;
			else if (pNode1.val<p.val)
				pNode1 = pNode1.right;
			
			if (q.val<pNode2.val)
				pNode2 = pNode2.left;
			else if (pNode2.val<q.val)
				pNode2 = pNode2.right;
		}
		
		return pAncestor;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println();
	}

}
