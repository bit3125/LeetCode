package round1;
/**思路分析：
 * 题意为找出最长的路径。路径的定义：二叉树上的最长连通子图？也就是说只要有边连在一起的路径都满足题意
 * 题中的“路径”概念，分析一条路径的构成：某个顶部节点[+左子树上的最长straight路径][+右子树上的最长straight路径]。
 * 所谓的左子树上的最长straight路径指的是以左子树根节点为端点的最长路径，
 * 故“路径”可被分为两类：1.弯的——包含“左子树上的”+“右子树上的”；2.直的——只包含“左子树上的”“右子树上的”其中一个。
 * 
 * 故对二叉树进行后序遍历，
 * 在每个节点上调用postOrder函数，都会做两件事：
 * 1.1 	分别对左树、右树调用postOrder，得到[左子树上的最长straight路径长度], [右子树上的最长straight路径长度]
 * 1.2 	拼接左右子树与根节点，形成“弯的路径”，与maxLen进行比较，记录。
 * 2. 	判断该节点与上层父节点传进来的sameVal是否相同是否能构成“直的路径”供其在上层递归栈上进行拼接，
 * 若是return这条链上的相同节点个数，若否则return 0（其实也是个数）
 * 
 * 也即，每个递归栈上，比较的是“左右直路径”拼接起来的“弯的路径”，return的却只是“最大的左右直路径”
 * 
 * */

//经对照发现写的跟99.9%解一毛一样，不过不知为何运行时间要多一些。卧槽，原来只是test的次数不够，大力出奇迹，竟然99.9%了
public class Q687LongestUnivaluePath {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int maxLen;
	
    public int longestUnivaluePath(TreeNode root) {
    	if (root==null)
    		return 0;
    	
    	this.maxLen = Integer.MIN_VALUE;
    	longestPath(root, root.val+1);//要保证顶层的sameVal与root不一样
    	//因为我们为了在顶层调用此函数，给root指定了一个虚拟父节点。正因为如此，这里的返回值也是没意义的，不用接。
    	
    	return this.maxLen;
    }
    
    
    /**每个递归栈都做两件事：
     * 检查拼接上左右树最长straight路径的弯的是否是目前最长路径
     * 返回左树与右树中最长的straight路径
     * 
     * 若子树无同值最长路径，则return 0，
     * 否则return 最长straight路径长度（若只有一个节点则为1，两个节点则为2，以此类推，把当前根节点一起算进去了）
     * 其实无论如何，return的都是表示，下方这颗子树的最长straight路径上有多少个节点与上层父节点是same的
     * */
    public int longestPath(TreeNode root, int sameVal){
    	if (root==null){
    		return 0;
    	}
    	
    	int longestLeft = longestPath(root.left, root.val);
    	int longestRight = longestPath(root.right, root.val);
    	int sum = longestLeft + longestRight;
    	if (sum>this.maxLen)
    		this.maxLen = sum;
    	
    	if (root.val==sameVal)//判断是否该节点为起点的straight路径可以与上层父节点进行拼接
    		return Integer.max(longestLeft, longestRight)+1;
    	else //不能拼接，直接免谈
    		return 0;
    				
    }
	
	public static void main(String[] args) {
		Q687LongestUnivaluePath q = new Q687LongestUnivaluePath();
	}

}
