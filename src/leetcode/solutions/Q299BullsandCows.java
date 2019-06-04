package leetcode.solutions;
import java.util.Arrays;

public class Q299BullsandCows {

	public String getHint(String secret, String guess) {
		if (secret==null||guess==null||secret.length()==0)
			return "0A0B";
		
		int bulls = 0;
		int cows = 0;
		int[] cntsS = new int[10];
		Arrays.fill(cntsS, 0);
		int[] cntsG = Arrays.copyOf(cntsS, cntsS.length);
		
		for (int i=0;i<secret.length();i++){
			if (secret.charAt(i)==guess.charAt(i)){
				bulls++;
			}else{
				cntsS[Integer.valueOf(secret.charAt(i))-'0']++;
				cntsG[Integer.valueOf(guess.charAt(i))-'0']++;
			}
		}
		
		for (int i=0;i<cntsS.length;i++){
			cows += Integer.min(cntsG[i], cntsS[i]);
		}
		
		return bulls + "A" + cows + "B";
	}

	public static void main(String[] args) {
		Q299BullsandCows q = new Q299BullsandCows();
//		String secret = "1123";
//		String guess = "0111";
		String secret = "1807";
		String guess = "7810";
		
		
		System.out.println(q.getHint(secret, guess));
		
	}

}
