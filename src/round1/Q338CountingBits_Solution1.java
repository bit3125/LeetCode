/** Tn=On^2
 * 
 * */

package round1;

public class Q338CountingBits_Solution1 {

    public int[] countBits(int num) {
    	if (num<0)
        	return null;
    	
    	int[] results = new int[num+1];
        for (int i=0;i<=num;i++)
        	results[i] = countBitsPerNum(i);
        
        return results;
    }
    
    public int countBitsPerNum(int num){
    	int cnt = 0;
    	while(num!=0){
    		num &= num-1;
    		cnt++;
    	}
    	return cnt;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
