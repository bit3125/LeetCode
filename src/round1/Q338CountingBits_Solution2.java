/**使用DP，Tn=On
 * 
 * */

package round1;

public class Q338CountingBits_Solution2 {

    public int[] countBits(int num) {
    	if (num<0)
        	return null;
    	
    	int[] results = new int[num+1];
    	results[0] = 0;
        for (int i=1;i<=num;i++)
        	results[i] = results[i&(i-1)]+1;
        
        return results;
    }
    
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
