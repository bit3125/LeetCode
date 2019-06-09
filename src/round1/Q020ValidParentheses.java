package round1;
import java.util.Stack;

public class Q020ValidParentheses {

    public boolean isValid(String s) {
    	if (s==null)
    		return false;
    	else if (s.length()==0)
    		return true;
    	
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
        	char c = s.charAt(i);
        	if (c=='(' || c=='[' || c=='{'){
        		stack.push(c);
        	}else{ // ')' || ']' || '}'
        		if (stack.empty())
        			return false;
        		else if ( 	   (c==')' && stack.peek()=='(') 
        				|| (c=='}' && stack.peek()=='{') 
        				|| (c==']' && stack.peek()=='[') ){
        			stack.pop();
        		}else{
        			return false;
        		}
        	}
        }
        
    	return stack.empty();
    }
	
	public static void main(String[] args) {
		Q020ValidParentheses q = new Q020ValidParentheses();
		String s = "()[]{}";
		
		System.out.println(q.isValid(s));
	}

}
