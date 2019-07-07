package round1;
/**best Solution
 * 等差数列求和
 * 
 * */
public class Q441ArrangingCoins_Solution2 {

    public int arrangeCoins(int n) {
        return (int) ( Math.sqrt(1+8.0*n)-1 )/2; //***bug:8*n当n趋近于Integer.MAX_VALUE时溢出
    }

    public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
