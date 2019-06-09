package round1;

public class Q172FactorialTrailingZeroes {

//    public int trailingZeroes(int n) {
//    	if (n<=0)
//    		return 0;
//    	
//    	int numOf2 = 0, numOf5 = 0;
//    	long base;
//    	
////    	base = 2;
////    	while (base<=n){
////    		numOf2 += n/base;
////    		base *= 2;
////    	}
//    	base = 5;
//    	while (base<=n){
//    		numOf5 += n/base;
//    		base *= 5;
//    	}
//    	
////    	return Math.min(numOf2, numOf5);
//    	return numOf5;//2肯定比5多
//    }
    
	
	//更好的solution
	//只要计算n!中2、5因子对的总个数就是乘积末尾0的个数
	//又2肯定比5多，故只要计算5
    public int trailingZeroes(int n) {
        int res = 0; //5的个数
        while (n>0) {
        	//对1~n数列所有5的倍数取出一个因子5（所有数都/5，取出5因子，下次对1~n/5数列做操作）
        	//并加到累加器上
            n = n/5;
            res+= n;
        }
        return res;
    }
	
	public static void main(String[] args) {
		Q172FactorialTrailingZeroes q = new Q172FactorialTrailingZeroes();
		int n = 30;
		System.out.println(q.trailingZeroes(n));
		System.out.println(Integer.MAX_VALUE);
	}

}
