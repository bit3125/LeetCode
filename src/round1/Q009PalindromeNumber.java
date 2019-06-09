package round1;

public class Q009PalindromeNumber {

	// public boolean isPalindrome(int x) {
	// if (x<0)
	// return false;
	// int maxbase = 1, minbase = 10;
	// int tmp = x;
	// int high, low;
	// while(tmp>=10){
	// tmp /= 10;
	// maxbase *= 10;
	// }
	// System.out.println(maxbase);
	// while(minbase<=maxbase){
	// high = x/maxbase%10;
	// low = x%minbase/(minbase/10);
	// if (high!=low)
	// return false;

	// maxbase /= 10;
	// minbase *= 10;
	// }

	// return true;
	// }
	public boolean isPalindrome(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int remainder = x;
		int newX = 0;
		while (remainder > 0) {
			newX = newX * 10 + remainder % 10;
			remainder /= 10;
		}

		return newX == x;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
