package leetcode.solutions;

public class Q112PathSum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private boolean beFound = false;
	private int sum;
	private int accum;
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root==null)
			return false;
		
		this.sum = sum;
		this.accum = 0;
		this.beFound = false;
		
		preOrder(root);
		return beFound;
	}
	
	public void preOrder(TreeNode root){
		if (root==null || beFound)
			return;
		
		//visit
		accum += root.val;
		if (root.left==null && root.right==null){//到叶节点进行判断
			if (accum==sum)
				beFound = true;
		}
		
		//left & right
		preOrder(root.left);
		preOrder(root.right);
		accum -= root.val;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
