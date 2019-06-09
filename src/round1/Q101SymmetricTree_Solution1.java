package round1;
/**�㷨������
 * ʹ����������ջ��
 * �Ը����ֱ����LR��RL��ǰ�����������ָ�룩��Ȼ��ͨ���Ա��������Ƿ���ͬ����
 * 
 * */

import java.util.ArrayList;
import java.util.List;

import structures.TreeNode;

public class Q101SymmetricTree_Solution1 {

    public boolean isSymmetric(TreeNode root) {
    	if (root==null)
    		return true;
    	
    	List<Integer> listLR = new ArrayList<>();
    	List<Integer> listRL = new ArrayList<>();
    	leftRight(root, listLR);
    	leftRight(root, listRL);
    	
    	for (int i=0;i<listLR.size();i++){
    		if (listLR.get(i)!=listRL.get(i))
    			return false;
    	}
    	
    	return true;
    }
    
    public void leftRight(TreeNode root, List<Integer> list){
    	if (root==null){
    		list.add(null);
    		return;
    	}

    	list.add(root.val);
    	leftRight(root.left, list);
    	leftRight(root.right, list);
    }
    
    public void rightLeft(TreeNode root, List<Integer> list){
    	if (root==null){
    		list.add(null);
    		return;
    	}

    	list.add(root.val);
    	rightLeft(root.right, list);
    	rightLeft(root.left, list);
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
