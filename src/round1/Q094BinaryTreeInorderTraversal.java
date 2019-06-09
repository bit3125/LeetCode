package round1;
import java.util.ArrayList;
import java.util.List;

import structures.TreeNode;

public class Q094BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	inOrder(root, result);
    	
    	return result;
    }
    
    public void inOrder(TreeNode root, List<Integer> result){
    	if (root==null)
    		return ;
    	
    	inOrder(root.left, result);
    	result.add(root.val);
    	inOrder(root.right, result);
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
