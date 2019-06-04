package leetcode.solutions;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class Q013RomantoInteger_Solution2 {

    public int romanToInt(String s) {
    	if (s==null||s.length()==0)
    		return 0;
    	
    	Map<Character, Integer> roman2Value = new HashMap<Character, Integer>();
    	Stack<Integer> stack = new Stack<>();
    	String romans = "IVXLCDM";
    	int[] values = {1,5,10,50,100,500,1000};
    	int sum = 0;
    	for (int i=0;i<7;i++){
    		roman2Value.put(romans.charAt(i), values[i]);
    	}
    	
    	int value = roman2Value.get(s.charAt(0));
    	int stackPeek;
    	stack.push(value);
    	for (int i=1;i<s.length();i++){
    		value = roman2Value.get(s.charAt(i));
    		stackPeek = stack.peek();
    		if (stackPeek==value)
    			stack.push(value);
    		else if (stackPeek>value){
    			while(!stack.empty()){
    				sum += stack.pop();
    			}
    			stack.push(value);
    		}else if (stackPeek<value){
    			while(!stack.empty()){
    				sum -= stack.pop();
    			}
    			stack.push(value);
    		}
    	}
    	while (!stack.empty()){
    		sum += stack.pop();
    	}
    	return sum;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Q013RomantoInteger_Solution2 q = new Q013RomantoInteger_Solution2();
		String s = "MIIX";
		
		System.out.println(q.romanToInt(s));
		
	}

}
