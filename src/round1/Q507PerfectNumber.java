package round1;
import java.util.Arrays;

public class Q507PerfectNumber {

	public boolean checkPerfectNumber(int num){
		if (num<=0)
			return false;
		if (num==1)
			return false;
		
		int sqrt = (int)Math.ceil(Math.sqrt(num));
		int sum = 1;
		for (int i=2;i<sqrt;i++){
			int a = num/i;
			if (a*i==num){
				sum += a+i;
			}
		}
		
		return sum==num;
	}

	public static void main(String[] args) {
		Q507PerfectNumber q = new Q507PerfectNumber();
		int num = 28;
		System.out.println(q.checkPerfectNumber(num));
	}

}
