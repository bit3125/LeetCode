package round1;
/**best Solution
 * �Ȳ��������
 * 
 * */
public class Q441ArrangingCoins_Solution2 {

    public int arrangeCoins(int n) {
        return (int) ( Math.sqrt(1+8.0*n)-1 )/2; //***bug:8*n��n������Integer.MAX_VALUEʱ���
    }

    public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
