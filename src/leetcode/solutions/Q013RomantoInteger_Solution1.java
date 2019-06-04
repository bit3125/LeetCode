package leetcode.solutions;
import java.util.Map;
import java.util.HashMap;

public class Q013RomantoInteger_Solution1 {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return 0;

		Map<Character, Integer> roman2Value = new HashMap<Character, Integer>();
		String romans = "IVXLCDM";
		int[] values = { 1, 5, 10, 50, 100, 500, 1000 };
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			roman2Value.put(romans.charAt(i), values[i]);
		}

		int valuePrev = roman2Value.get(s.charAt(0));
		;
		for (int i = 1; i < s.length(); i++) {
			int value = roman2Value.get(s.charAt(i));
			sum += valuePrev >= value ? valuePrev : -valuePrev;
			valuePrev = value;
		}
		sum += valuePrev;

		return sum;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Q013RomantoInteger_Solution1 q = new Q013RomantoInteger_Solution1();
		String s = "IIV";
		
		System.out.println(q.romanToInt(s));
		
	}

}
