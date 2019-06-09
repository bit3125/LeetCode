package structures;


public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	public TreeNode createTree(int[] nodes, int idx){
		
		TreeNode root = new TreeNode(nodes[idx]);
		root.left = createTree(nodes, idx);
		return null;
	}
	
	
}
