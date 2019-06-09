/**算法解析：
 * 使用DP，设f[i]为1~i的节点能构成的BST总数 
 * 具体思想见discussion
 * 
 * 状态转移方程：f[i] = 2*<i/2-1>∑<j=0>(f[j]*f[i-1-j]) + (i&1)*(f[i/2])^2 . i/2皆指向下取整
 * 初始条件：f[0]=1, f[1]=1
 * 约束条件：i∈[1,n]
 * 
 * */

package round1;

public class Q096UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n<=0)
        	return -0;
        
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;

        for (int i=2;i<=n;i++){
        	for (int j=0;j<=i/2-1;j++) //***bug:j的边界
        		f[i] += f[j]*f[i-1-j];
        	f[i] *= 2;
    		f[i] += (i&1)*f[i/2]*f[i/2];
        }
        
        return f[n];
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
