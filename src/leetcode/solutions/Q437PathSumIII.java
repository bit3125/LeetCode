package leetcode.solutions;
/**�㷨������
 * ����ֽ�Ϊһ����ȫ·����ÿ��ȫ·������һ�����У��Ը����е�ÿ�ν��б���
 * ��ô������������㷨�����Ӷ�ΪO(n^2)
 * ���ڴ�˼���������㷨�����̶�������������ǰȫ·�����Ե�ǰ�ڵ�Ϊ����path���롰�̶��յ����������ǰȫ·�����Ե�ǰ�ڵ�Ϊ�յ��path����������Ҫһ������list
 * ������� ���Ǻ��ߡ�
 * 
 * discuss����O(N)�Ľⷨ�����������
 * */

import java.util.ArrayList;
import java.util.List;

public class Q437PathSumIII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private List<Integer> sums = new ArrayList<>();

	public int pathSum(TreeNode root, int sum) {
		if (root==null)
			return 0;
		
		sums.add(0);
		return pathSumCore(root, sum);
	}
	
	public int pathSumCore(TreeNode root, int sum) {
		if (root==null)
			return 0;
		
		//visit
		int cnt = 0;
		int sumCur = ( sums.get(sums.size()-1) ) + root.val;
		for (int i=0;i<sums.size();i++){
			
			System.out.println( "current val=" + root.val + "----" + "current size=" + sums.size() + "----" + (sumCur-sums.get(i)));
			
			if (sumCur-sums.get(i)==sum){
				cnt++;
			}
		}
		
		sums.add(sumCur);
		cnt += pathSumCore(root.left, sum) + pathSumCore(root.right, sum);
		//����
		sums.remove(sums.size()-1);//��ȥ��ǰ�ڵ�
		return cnt;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
