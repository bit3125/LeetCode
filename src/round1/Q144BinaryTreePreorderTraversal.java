package round1;
import java.util.ArrayList;
import java.util.List;

public class Q144BinaryTreePreorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		preOrder(root, result);
		return result;
	}

	public void preOrder(TreeNode root, List<Integer> result) {
		if (root == null)
			return;

		result.add(root.val);
		preOrder(root.left, result);
		preOrder(root.right, result);
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
