/**算法分析：solution1之所以搞的这么纠结是因为，要对q中的路径记录进行回溯
 * ，在找到target之后要把这时候的path回传给根函数，但是如果照常回溯的话就会把目前的q中的路径给破坏掉
 * ，所以如果在找到target之后能把path给copy一份直接回传出来，就可以不用管tmpq中的路径的接下来的回溯过程
 * ，代码也可以写的不这么纠结了
 * */

package round1;

import java.util.Deque;
import java.util.LinkedList;

import structures.TreeNode;

public class Q236LowestCommonAncestorofaBinaryTree_Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)
        	return null;
    	
        Deque<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        Deque<TreeNode> tmpq = new LinkedList<>();
        this.hasFound = false;
        tmpq.clear();
        storePath(root, p, tmpq, q1);
        this.hasFound = false;
        tmpq.clear();
        storePath(root, q, tmpq, q2);
        
        TreeNode prevNode = null ;
        while(!q1.isEmpty() && !q2.isEmpty()){
        	p = q1.removeFirst();
        	q = q2.removeFirst();
        	if (p!=q)
        		break; 
    		prevNode = p;
        }
        return prevNode; 
    }
    
    private boolean hasFound;
    public void storePath(TreeNode root, TreeNode target, Deque<TreeNode> q, Deque<TreeNode> result){
    	if (null==root || hasFound)
    		return ;
    	
    	q.addLast(root); 
    	if (root.val==target.val){
    		result.addAll(q); //copy the tmp path q to result
    	}
		storePath(root.left, target, q, result);
		storePath(root.right, target, q, result);
		q.removeLast(); 
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
