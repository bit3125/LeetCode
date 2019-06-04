package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q022GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n<=0)
            return result;
        
        char[] str = new char[n*2];
        Arrays.fill(str, '-');
        generateParenthesisCore(result, str, n, 0, 0);
        
        return result;
    }
    
    public void generateParenthesisCore(List<String> result, char[] str, int leftLeft, int leftBracketStack, int curIdx){
        if (curIdx==str.length){
            result.add(new String(str));
            return;
        }
        
        // 都是递归前可行性判断
        if (leftLeft>0){ //add '('
            str[curIdx] = '(';
            generateParenthesisCore(result, str, leftLeft-1, leftBracketStack+1, curIdx+1);
        }
        if (leftBracketStack>0){ //add ')'
            str[curIdx] = ')';
            generateParenthesisCore(result, str, leftLeft, leftBracketStack-1, curIdx+1);
        }
        
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
