package leetcode.solutions;

import java.util.Deque;
import java.util.LinkedList;

import leetcode.structures.TreeNode;

public class Q236LowestCommonAncestorofaBinaryTree_Solution1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)
        	return null;
    	
        Deque<TreeNode> q1 = new LinkedList<>();
        Deque<TreeNode> q2 = new LinkedList<>();
        this.hasFound = false;
        storePath(root, q1, p);
        this.hasFound = false;
        storePath(root, q2, q);
        
        TreeNode prevNode = null ;
        while(!q1.isEmpty() && !q2.isEmpty()){
        	p = q1.removeFirst();
        	q = q2.removeFirst();
        	if (p!=q)
        		break; 
    		prevNode = p;
        }
        return prevNode; //���ڡ�һ�����й������ȡ��ļ��裬��һ��return prevNode
        //***bug:��pq������һ��Ϊ���ߵ�LCA����������Ϊ����һ��queueΪ��ȴû������p!=q�������������ʱ��
        //���ֵ�prevNodeӦ���Ǽ�Ϊ����Ӧ��return��ȴû�о����жϣ��ʵ���Ϊ�����������ѭ����ʱ�������return prevNode
    }
    
    private boolean hasFound;
    public void storePath(TreeNode root, Deque<TreeNode> q, TreeNode target){
    	q.addLast(root); //***bug: ѡ��null�ݹ���ڼ������ں���ͷ������Ҫ��ͳһ�Ļ���
    		//�ʼ�ʹ���εݹ��Ǵﵽ��������Ҫ����return��ȥ�ģ�ҲҪ��addһ�£���û���ȥremove֮ǰ�ĵݹ�ջ
    		//����add�����ڵݹ����֮ǰ
    	if (null==root)
    		return ;
    	
    	if (root.val==target.val) //***bug:�ж�target���Ҫ��ǰ��visitʱ
    		hasFound = true;
    	
		if (!hasFound){
			storePath(root.left, q, target);//***bug:����Ҫ�ڽ���ݹ�ǰ����hasFound���жϣ����������ôһ�������
			//found֮��removeLast���ݲ�������������ִ�У��������ݹ����������Ľڵ㣬�ں���ͷ�ݹ���ڳ���hasFound�ж�return
			//֮ǰ���Ѿ���add����ִ���ˣ���ε�add����remove�����������˾ͻ�һֱ���ڵݹ�ջ��ͳ�������
			//���Զ�hasFound���ж��ڽ���ݹ�֮ǰ����������addLast֮ǰ��Ҳ���ԣ�
			if (!hasFound)
				q.removeLast(); //***bug:�ҵ�Ŀ��֮�󷵻��ϲ�ݹ�ջ��ʱ��Ҳ��backtracking��
						//����Ҫʹ��hasFound�ж���ȷ���Ƿ���backtracing������Ѿ�found�˾Ͱ�queue��������remove
		}
		
		if (!hasFound){
			storePath(root.right, q, target);
			if (!hasFound) //***bug:�����������Ҫ��hasFound�жϣ��������߻�Ҫ��������
					//Ҳ��removeǶ��������if֮�ں󻹵�����һ��hasFound���ж�
					//�����hasFound�ж���Ϊ����ǰ���storePath�ݹ������found��target֮�����queue����
					//����Ҫ��������
				q.removeLast(); //back tracking
		}
		
    }
    
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
