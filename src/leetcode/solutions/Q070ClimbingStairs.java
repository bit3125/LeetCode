package leetcode.solutions;

public class Q070ClimbingStairs {

    public int climbStairs(int n) {
        if (n<=0)
        	return 0;
        
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        for (int i=2;i<=n;i++)
        	f[i] = f[i-1] + f[i-2];
        
        return f[n];
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
