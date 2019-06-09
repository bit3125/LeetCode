package round1;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q100SameTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private boolean isSame;
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p==null && q==null)//***bug:
			return true;
		else if (p==null || q==null)
			return false;
		
		isSame = true;
		Queue<Integer> queue = new LinkedList<>();
		preOrder(p, queue);
		compare(q, queue);
		
		return isSame;
	}

	public void preOrder(TreeNode root, Queue<Integer> queue) {
		if (root == null){
			queue.add(null);
			return;
		}

		queue.add(root.val);
		preOrder(root.left, queue);
		preOrder(root.right, queue);
	}

	public void compare(TreeNode q, Queue<Integer> queue) {
		if (isSame==false)
			return;
		if (queue.isEmpty()){
			isSame = false;
			return;
		}
		
		Integer e = queue.poll();
		if (q==null){//qΪ��ָ��
			if (e!=null)
				isSame = false;
			return;//***bug
		}else{//q��Ϊ��ָ��
			if (e==null){//eΪ��ָ��
				isSame = false;
				return;
			}else {//e��Ϊ��ָ��
				if (e!=q.val){
					isSame = false;
					return;
				}
			}
		}
		
		compare(q.left, queue);
		compare(q.right, queue);
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	}

}
