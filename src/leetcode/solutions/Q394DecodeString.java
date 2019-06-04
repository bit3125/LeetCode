package leetcode.solutions;
/**算法分析：
 * 一个模式串可以递归地划分：一个模式串又若干模式子串构成，
 * 比如"3[a2[c]]ddd"可划分为"3[a2[c]]", "ddd"两个子串，子串有两种类型，分别做处理
 * 设计一个helper函数，其接受一个模式串为参数，return翻译后的字符串结果
 * 那么便可用while循环去将模式串切割为若干子串，然后对每个子串递归地调用helper函数，将每个子串的结果append到result上
 * 有点类似于对一颗多叉树进行遍历。
 * 
 * */

public class Q394DecodeString {
    
    public String decodeString(String s) {
    	if (s==null||s.length()==0)
    		return "";
    	
    	return helper(s, 0, s.length());
    }
    
    /**
     * input :一个原生模式串(以digit||letter开头)
     * output：翻译后的串(只含letter)
     * */
    public String helper(String s, int start, int end){
    	//TODO
    	if (start>=end)
    		return "";
    	
    	StringBuilder result = new StringBuilder();
    	int idx = start;
    	
    	while(idx<end){
    		if(Character.isDigit(s.charAt(idx))){
    			int digitEnd = findDigitBound(s, idx);//exclusive. also the idx of '['
    			int cntOfNut = Integer.valueOf(s.substring(idx,digitEnd));
    			
    			int rightBracket = digitEnd+1; 
    			int cntOfLeftBracket = 1; //bug:
    			while(rightBracket<end && cntOfLeftBracket!=0){
    				if (s.charAt(rightBracket)=='['){
    					cntOfLeftBracket++;//add
    				}
    				else if (s.charAt(rightBracket)==']')
    					cntOfLeftBracket--;
    				rightBracket++;//move up
    			}
    			rightBracket--;//-1
    			
    			String nut = helper(s, digitEnd+1, rightBracket);//递归
    			while(cntOfNut>0){
    				result.append(nut);
    				cntOfNut--;
    			}
    			idx = rightBracket+1;
    		}else{ // is letter
    			int letterEnd = findLetterBound(s, idx);//exclusive
    			result.append(s.substring(idx, letterEnd));
    			idx = letterEnd;
    		}//处理后面子串的部分，本来可以继续用递归：']'后的整个串视为一个子串用helper去得到结果
    		 //同时这样的话就要对长度为1的子串设置一个递归出口。但是这么做效率太低了，故改为对纯字母子串直接进行拼接 
    		
    	}
    	
    	return result.toString();
    }
    
    public int findDigitBound(String s, int start){
    	int end = start+1; //exclusive
    	while(Character.isDigit(s.charAt(end)))//数字必定不是边界故此处无需做越界检测
    		end++;
    	return end;
    }
    
    public int findLetterBound(String s, int start){
    	int end = start+1; //exclusive
    	while(end<s.length() && Character.isLetter(s.charAt(end)))
    		end++;
    	return end;
    }
    
	public static void main(String[] args) {
		Q394DecodeString q = new Q394DecodeString();
//		String s = "3[a]2[bc]";
//		String s = "3[a2[c]]";
//		String s = "";
		String s = "3[a2[c]ww]";
		
		System.out.println(q.decodeString(s));
	}

}

