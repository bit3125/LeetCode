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
//    	return numOf5;//2�϶���5��
//    }
    
	
	//���õ�solution
	//ֻҪ����n!��2��5���ӶԵ��ܸ������ǳ˻�ĩβ0�ĸ���
	//��2�϶���5�࣬��ֻҪ����5
    public int trailingZeroes(int n) {
        int res = 0; //5�ĸ���
        while (n>0) {
        	//��1~n��������5�ı���ȡ��һ������5����������/5��ȡ��5���ӣ��´ζ�1~n/5������������
        	//���ӵ��ۼ�����
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
