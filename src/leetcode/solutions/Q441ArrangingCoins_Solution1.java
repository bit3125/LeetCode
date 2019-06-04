package leetcode.solutions;


public class Q441ArrangingCoins_Solution1 {

    public int arrangeCoins(int n) {
        int base = 1;
        while(n>0){
        	n -= base;
        	base++;
        }
        if (n<0)
        	base--;
        
        return base-1;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
