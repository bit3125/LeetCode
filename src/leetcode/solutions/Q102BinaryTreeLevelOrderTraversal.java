package leetcode.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.structures.TreeNode;

public class Q102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if (root==null)
        	return results;
    	
    	Queue<TreeNode> q = new LinkedList<>();
    	TreeNode curNode ;
    	q.offer(root);
    	int curCnt = 0, curSize = 1;
    	List<Integer> result = new ArrayList<>();
    	while(!q.isEmpty()){
    		curNode = q.poll();
    		curCnt++;
    		result.add(curNode.val);
    		
    		if (curNode.left!=null)
    			q.offer(curNode.left);
    		if (curNode.right!=null)
    			q.offer(curNode.right);
    		
    		if (curCnt==curSize){
    			results.add(result);
    			curCnt = 0;
    			curSize = q.size();
    			result = new ArrayList<>();
    		}
    	}
    	
    	return results;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
