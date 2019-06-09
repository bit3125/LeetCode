package round1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q438FindAllAnagramsinaString {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length())
			return result;

		int[] cnts = new int[26];
		Arrays.fill(cnts, 0);
		for (int i = 0; i < p.length(); i++)
			cnts[p.charAt(i) - 'a']++;
		for (int i = 0; i < p.length(); i++)
			cnts[s.charAt(i) - 'a']--;

		if (isSatisfied(cnts))
			result.add(0);
		for (int i = p.length(); i < s.length(); i++) { // i表示的是当前要判断的子串的end（含）
			cnts[s.charAt(i - p.length()) - 'a']++;
			cnts[s.charAt(i) - 'a']--;
			if (isSatisfied(cnts))
				result.add(i - p.length() + 1); // ***bug: result.add(i);
		}

		return result;
	}

	public boolean isSatisfied(int[] cnts) {
		for (int j = 0; j < 26; j++)
			if (cnts[j] != 0) {
				return false;
			}

		return true;
	}

	public static void main(String[] args) {
		Q438FindAllAnagramsinaString q = new Q438FindAllAnagramsinaString();
		String s = "cbaebabacd";
		String p = "abc";
		// String s = "adsfasf";
		// String p = "";

		System.out.println(Arrays.toString(q.findAnagrams(s, p).toArray()));
		;
	}

}
