/**�㷨������
 * ʹ��DP����f[i]Ϊ1~i�Ľڵ��ܹ��ɵ�BST���� 
 * ����˼���discussion
 * 
 * ״̬ת�Ʒ��̣�f[i] = 2*<i/2-1>��<j=0>(f[j]*f[i-1-j]) + (i&1)*(f[i/2])^2 . i/2��ָ����ȡ��
 * ��ʼ������f[0]=1, f[1]=1
 * Լ��������i��[1,n]
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
        	for (int j=0;j<=i/2-1;j++) //***bug:j�ı߽�
        		f[i] += f[j]*f[i-1-j];
        	f[i] *= 2;
    		f[i] += (i&1)*f[i/2]*f[i/2];
        }
        
        return f[n];
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
