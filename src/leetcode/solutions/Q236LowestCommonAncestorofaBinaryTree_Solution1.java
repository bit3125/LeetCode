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
        return prevNode; //基于“一定会有公共祖先”的假设，故一定return prevNode
        //***bug:当pq中其中一者为二者的LCA，则会出现因为其中一个queue为空却没有满足p!=q条件的情况，这时候
        //此轮的prevNode应当是即为所求应该return但却没有经过判断，故当因为这种情况挑出循环的时候就让他return prevNode
    }
    
    private boolean hasFound;
    public void storePath(TreeNode root, Deque<TreeNode> q, TreeNode target){
    	q.addLast(root); //***bug: 选择将null递归出口继续放在函数头。由于要做统一的回溯
    		//故即使本次递归是达到出口条件要马上return出去的，也要先add一下，免得回溯去remove之前的递归栈
    		//所以add必须在递归出口之前
    	if (null==root)
    		return ;
    	
    	if (root.val==target.val) //***bug:判断target与否要在前序visit时
    		hasFound = true;
    	
		if (!hasFound){
			storePath(root.left, q, target);//***bug:必须要在进入递归前进行hasFound的判断，否则会有这么一种情况：
			//found之后，removeLast回溯操作被锁定不再执行，而继续递归进入接下来的节点，在函数头递归出口出做hasFound判断return
			//之前就已经把add操作执行了，这次的add由于remove操作被锁定了就会一直留在递归栈里，就出问题了
			//所以对hasFound的判断在进入递归之前做（或者在addLast之前做也可以）
			if (!hasFound)
				q.removeLast(); //***bug:找到目标之后返回上层递归栈的时候也会backtracking，
						//所以要使用hasFound判断来确定是否做backtracing，如果已经found了就把queue锁定不再remove
		}
		
		if (!hasFound){
			storePath(root.right, q, target);
			if (!hasFound) //***bug:不但两条命令都要做hasFound判断，而且两者还要单独做！
					//也即remove嵌套在外层的if之内后还得再做一个hasFound的判断
					//这里的hasFound判断是为了在前面的storePath递归过程中found了target之后进行queue锁定
					//所以要在这里做
				q.removeLast(); //back tracking
		}
		
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
