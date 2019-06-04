package leetcode.solutions;
import java.util.Arrays;

public class Q443StringCompression {
	
	public int compress(char[] chars) {
    	if (chars==null || chars.length==0)
    		return 0;
    	
    	char curChar = chars[0];
    	int cnt = 0;
    	int newLen = 0;
    	for (int i=0;i<chars.length;i++){
    		if (chars[i]==curChar){
    			cnt++;
    		}else{
    			newLen = writeCnt(chars, curChar, cnt, newLen);
    			curChar = chars[i];
    			cnt = 1;
    		}
    	}
    	
    	newLen = writeCnt(chars, curChar, cnt, newLen);
    	return newLen;
    }
	
	public int writeCnt(char[] chars, char curChar, int cnt, int newLen){
		chars[newLen++] = curChar;
		if (cnt!=1){
			char[] cntStr = String.valueOf(cnt).toCharArray();
			System.arraycopy(cntStr, 0, chars, newLen, cntStr.length);
			newLen += cntStr.length;
		}
		
		return newLen;
	}
	
	public static void main(String[] args) {
		Q443StringCompression q = new Q443StringCompression();
		char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		int newLen = q.compress(chars);
		
		System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, newLen)));
		
		
	}

}
