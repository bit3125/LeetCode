package leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Q017LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits==null || digits.length()==0)
        	return results;
        
        String[] map = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
        
        char[] str = new char[digits.length()];
        helper(digits, str, 0, results, map);
        return results;
    }
	
    public void helper(String digits, char[] result, int curIdx, List<String> results, String[] map){
    	if (curIdx==result.length){
    		results.add(new String(result));
    		return ;
    	}
    	
    	String mapStr = map[digits.charAt(curIdx)-'0']; 
    	for (int i=0;i<mapStr.length();i++){
    		result[curIdx] = mapStr.charAt(i);
    		helper(digits, result, curIdx+1, results, map);
    	}
    	
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}

}
