package leetcode.solutions;
/**�㷨������
 * һ��ģʽ�����Եݹ�ػ��֣�һ��ģʽ��������ģʽ�Ӵ����ɣ�
 * ����"3[a2[c]]ddd"�ɻ���Ϊ"3[a2[c]]", "ddd"�����Ӵ����Ӵ����������ͣ��ֱ�������
 * ���һ��helper�����������һ��ģʽ��Ϊ������return�������ַ������
 * ��ô�����whileѭ��ȥ��ģʽ���и�Ϊ�����Ӵ���Ȼ���ÿ���Ӵ��ݹ�ص���helper��������ÿ���Ӵ��Ľ��append��result��
 * �е������ڶ�һ�Ŷ�������б�����
 * 
 * */

public class Q394DecodeString {
    
    public String decodeString(String s) {
    	if (s==null||s.length()==0)
    		return "";
    	
    	return helper(s, 0, s.length());
    }
    
    /**
     * input :һ��ԭ��ģʽ��(��digit||letter��ͷ)
     * output�������Ĵ�(ֻ��letter)
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
    			
    			String nut = helper(s, digitEnd+1, rightBracket);//�ݹ�
    			while(cntOfNut>0){
    				result.append(nut);
    				cntOfNut--;
    			}
    			idx = rightBracket+1;
    		}else{ // is letter
    			int letterEnd = findLetterBound(s, idx);//exclusive
    			result.append(s.substring(idx, letterEnd));
    			idx = letterEnd;
    		}//��������Ӵ��Ĳ��֣��������Լ����õݹ飺']'�����������Ϊһ���Ӵ���helperȥ�õ����
    		 //ͬʱ�����Ļ���Ҫ�Գ���Ϊ1���Ӵ�����һ���ݹ���ڡ�������ô��Ч��̫���ˣ��ʸ�Ϊ�Դ���ĸ�Ӵ�ֱ�ӽ���ƴ�� 
    		
    	}
    	
    	return result.toString();
    }
    
    public int findDigitBound(String s, int start){
    	int end = start+1; //exclusive
    	while(Character.isDigit(s.charAt(end)))//���ֱض����Ǳ߽�ʴ˴�������Խ����
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

