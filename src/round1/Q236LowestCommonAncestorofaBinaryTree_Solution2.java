/**�㷨������solution1֮���Ը����ô��������Ϊ��Ҫ��q�е�·����¼���л���
 * �����ҵ�target֮��Ҫ����ʱ���path�ش�������������������ճ����ݵĻ��ͻ��Ŀǰ��q�е�·�����ƻ���
 * ������������ҵ�target֮���ܰ�path��copyһ��ֱ�ӻش��������Ϳ��Բ��ù�tmpq�е�·���Ľ������Ļ��ݹ���
 * ������Ҳ����д�Ĳ���ô������
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
		// TODO �Զ����ɵķ������

	}

}
