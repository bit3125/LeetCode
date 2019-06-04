package leetcode.solutions;
/**算法分析：
 * 如果分解为一条条全路径，每条全路径当做一个数列，对该数列的每段进行遍历
 * 那么这是最基本的算法，复杂度为O(n^2)
 * 基于此思想有两种算法：“固定起点遍历”（当前全路径上以当前节点为起点的path）与“固定终点遍历”（当前全路径上以当前节点为终点的path），后者需要一个辅助list
 * 这里采用 的是后者。
 * 
 * discuss里有O(N)的解法，懒得理解了
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
		//回溯
		sums.remove(sums.size()-1);//移去当前节点
		return cnt;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
