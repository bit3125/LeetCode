package round1;
/**非递归实现
 * 
 * */
import java.util.ArrayList;
import java.util.List;

import structures.TreeNode;

public class Q145BinaryTreePostorderTraversal_Solution2 {

    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	
    	postOrder(root, result);
    	return result;
    }
    
    public void postOrder(TreeNode root, List<Integer> result){
    	if (root==null)
    		return;
    	
    	postOrder(root.left, result);
    	postOrder(root.right, result);
    	result.add(root.val);
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
