package round1;

public class Q231PowerofTwo {

	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;

		while (n > 1) {
			if ((n & 1) != 0)
				return false;
			n >>= 1;
		}

		return true;
	}

	public static void main(String[] args) {
		Q231PowerofTwo q = new Q231PowerofTwo();
		int n = 1;

		System.out.println(q.isPowerOfTwo(n));

	}

}
