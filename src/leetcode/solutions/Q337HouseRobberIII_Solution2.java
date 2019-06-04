/**使用Solution1中设计的状态转移方程，进行自底向上的动态规划
 * 
 * 先做一个层序遍历，并使用一个stack逆序保存每一层
 * 然后做一个镜像的DPNode组成的树，用于保存每个节点对应的两组dp值
 * 然后自底向上进行dp
 * 这种方法是基于循环的，是dp的常规手段
 * 然而代码量偏大，实现较为复杂
 * 
 * 实际上基于递归也能写出相同复杂度的算法，将两组dp值合并在一起进行求解并return就行，
 * （return一个数组，在递归出口处return {0,0}而非solution1的0），本质上与Solution2是一毛一样的
 * ，这样的话由于没有重复求解的部分，复杂度与循环方法是相等的，而且使用的是递归的结构更简洁，
 * 这种算法见discussion Easy understanding solution with dfs
 * 
 * */

package leetcode.solutions;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

import leetcode.structures.TreeNode;

public class Q337HouseRobberIII_Solution2 {

	private static class DPNode{
    	
		TreeNode treeNode;
		int doStealThisValue;
    	int noStealThisValue;
    	
    	public DPNode(TreeNode treeNode){
    		this.treeNode = treeNode;
    	}
    	
    	public int getDoStealThisValue(DPNode node){
    		return node==null?0:node.doStealThisValue;
    	}
    	
    	public int getNoStealThisValue(DPNode node){
    		return node==null?0:node.noStealThisValue;
    	}
    	
    	public void calValues(Map<TreeNode, DPNode> map){
    		DPNode left = map.get(treeNode.left);
    		DPNode right = map.get(treeNode.right);
    		this.doStealThisValue = getNoStealThisValue(left) + getNoStealThisValue(right) + treeNode.val;
    		this.noStealThisValue = Integer.max(
    				Integer.max(
    						Integer.max(getNoStealThisValue(left) + getDoStealThisValue(right) , getDoStealThisValue(left) + getNoStealThisValue(right) )
    						, getDoStealThisValue(left) + getDoStealThisValue(right) )
    				, getNoStealThisValue(left) + getNoStealThisValue(right));
    	}
	}
	
    public int rob(TreeNode root) {
        if (root==null)
        	return 0;
    	
        // layer order traverse
        Stack<List<TreeNode>> layers = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int curCnt = 0, curSize = 1;
        List<TreeNode> layer = new ArrayList<>();
        TreeNode curNode;
        while(!q.isEmpty()){
        	curNode = q.poll();
        	layer.add(curNode);
        	curCnt++;
        	
        	if (curNode.left!=null)
        		q.offer(curNode.left);
        	if (curNode.right!=null)
        		q.offer(curNode.right);
        	
        	if (curCnt==curSize){
        		curCnt = 0;
        		curSize = q.size();
        		layers.push(layer);
        		layer = new ArrayList<>();
        	}
        }
        
        // tree dp
        Map<TreeNode, DPNode> map = new HashMap<>();
        DPNode curDPNode;
        while(!layers.isEmpty()){ //per layer
        	layer = layers.pop();
        	for (TreeNode curTreeNode : layer){ //per treenode
        		curDPNode = new DPNode(curTreeNode);
        		map.put(curTreeNode, curDPNode);
        		curDPNode.calValues(map);
        	}
        }
        
    	return Integer.max(map.get(root).doStealThisValue, map.get(root).noStealThisValue);
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
