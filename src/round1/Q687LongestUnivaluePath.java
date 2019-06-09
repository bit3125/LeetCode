package round1;
/**˼·������
 * ����Ϊ�ҳ����·����·���Ķ��壺�������ϵ����ͨ��ͼ��Ҳ����˵ֻҪ�б�����һ���·������������
 * ���еġ�·�����������һ��·���Ĺ��ɣ�ĳ�������ڵ�[+�������ϵ��straight·��][+�������ϵ��straight·��]��
 * ��ν���������ϵ��straight·��ָ���������������ڵ�Ϊ�˵���·����
 * �ʡ�·�����ɱ���Ϊ���ࣺ1.��ġ����������������ϵġ�+���������ϵġ���2.ֱ�ġ���ֻ�������������ϵġ����������ϵġ�����һ����
 * 
 * �ʶԶ��������к��������
 * ��ÿ���ڵ��ϵ���postOrder�����������������£�
 * 1.1 	�ֱ����������������postOrder���õ�[�������ϵ��straight·������], [�������ϵ��straight·������]
 * 1.2 	ƴ��������������ڵ㣬�γɡ����·��������maxLen���бȽϣ���¼��
 * 2. 	�жϸýڵ����ϲ㸸�ڵ㴫������sameVal�Ƿ���ͬ�Ƿ��ܹ��ɡ�ֱ��·�����������ϲ�ݹ�ջ�Ͻ���ƴ�ӣ�
 * ����return�������ϵ���ͬ�ڵ������������return 0����ʵҲ�Ǹ�����
 * 
 * Ҳ����ÿ���ݹ�ջ�ϣ��Ƚϵ��ǡ�����ֱ·����ƴ�������ġ����·������return��ȴֻ�ǡ���������ֱ·����
 * 
 * */

//�����շ���д�ĸ�99.9%��һëһ����������֪Ϊ������ʱ��Ҫ��һЩ���Բۣ�ԭ��ֻ��test�Ĵ����������������漣����Ȼ99.9%��
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
    	longestPath(root, root.val+1);//Ҫ��֤�����sameVal��root��һ��
    	//��Ϊ����Ϊ���ڶ�����ô˺�������rootָ����һ�����⸸�ڵ㡣����Ϊ��ˣ�����ķ���ֵҲ��û����ģ����ýӡ�
    	
    	return this.maxLen;
    }
    
    
    /**ÿ���ݹ�ջ���������£�
     * ���ƴ�����������straight·��������Ƿ���Ŀǰ�·��
     * �������������������straight·��
     * 
     * ��������ֵͬ�·������return 0��
     * ����return �straight·�����ȣ���ֻ��һ���ڵ���Ϊ1�������ڵ���Ϊ2���Դ����ƣ��ѵ�ǰ���ڵ�һ�����ȥ�ˣ�
     * ��ʵ������Σ�return�Ķ��Ǳ�ʾ���·�����������straight·�����ж��ٸ��ڵ����ϲ㸸�ڵ���same��
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
    	
    	if (root.val==sameVal)//�ж��Ƿ�ýڵ�Ϊ����straight·���������ϲ㸸�ڵ����ƴ��
    		return Integer.max(longestLeft, longestRight)+1;
    	else //����ƴ�ӣ�ֱ����̸
    		return 0;
    				
    }
	
	public static void main(String[] args) {
		Q687LongestUnivaluePath q = new Q687LongestUnivaluePath();
	}

}
