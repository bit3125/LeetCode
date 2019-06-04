package leetcode.solutions;

public class Q190ReverseBits {

    public int reverseBits(int n) {
    	int result = 0;
    	
    	int left = Integer.MAX_VALUE+1, right = 1;
    	while (left!=0){
    		if ((n&right)!=0)//***bug:(n&right)==1
    			result += left;
    		
    		left = left>>>1;
    		right = right<<1;
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		Q190ReverseBits q = new Q190ReverseBits();
//		int n = 43261596;
		int n = 2147483647+1;
		
		System.out.println(q.reverseBits(n));
	}

}
