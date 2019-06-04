package leetcode.solutions;

/**算法分析：Tn = Ologn, Sn = O1，二分快速幂
 * 三种边界情况要考虑：
 * 1. x==0, n<=0    非法
 * 2. x!=0
 *  2.1 n==0    直接 return 1
 *  2.2 n<0     先求 x^-n ，再求倒数
 *
 * x<0不用单独剥离出来考虑
 *
 * */
public class Q050Pow {

    public double myPow(double x, int n) {
        if (n==0) //n==0
            return 1;

        boolean nPositive = n > 0;
        long N = n; //***bug:overflow
        if (N<0) N = -N;
        double result = 1, base = x;

        while (N > 0) {
            if ( (N&1)==1 )
                result *= base;

            N >>>= 1;
            base *= base;
        }

        return nPositive?result:1/result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
