/**ʹ��Solution1����Ƶ�״̬ת�Ʒ��̣������Ե����ϵĶ�̬�滮
 * 
 * ����һ�������������ʹ��һ��stack���򱣴�ÿһ��
 * Ȼ����һ�������DPNode��ɵ��������ڱ���ÿ���ڵ��Ӧ������dpֵ
 * Ȼ���Ե����Ͻ���dp
 * ���ַ����ǻ���ѭ���ģ���dp�ĳ����ֶ�
 * Ȼ��������ƫ��ʵ�ֽ�Ϊ����
 * 
 * ʵ���ϻ��ڵݹ�Ҳ��д����ͬ���Ӷȵ��㷨��������dpֵ�ϲ���һ�������Ⲣreturn���У�
 * ��returnһ�����飬�ڵݹ���ڴ�return {0,0}����solution1��0������������Solution2��һëһ����
 * �������Ļ�����û���ظ����Ĳ��֣����Ӷ���ѭ����������ȵģ�����ʹ�õ��ǵݹ�Ľṹ����࣬
 * �����㷨��discussion Easy understanding solution with dfs
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
		// TODO �Զ����ɵķ������

	}

}
