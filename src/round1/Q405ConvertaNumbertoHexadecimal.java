package round1;
import java.util.Stack;

public class Q405ConvertaNumbertoHexadecimal {

    public String toHex(int num) {
    	if (num==0)
    		return "0";
    	
    	long MIN_VALUE = 4294967296L;
    	long n = num>0?num:MIN_VALUE+num;
    	Stack<Integer> stack = new Stack<>(); 
    	StringBuilder result = new StringBuilder();
    	char[] num2Char = "0123456789abcdef".toCharArray(); 
    	
    	while(n>0){
    		stack.push((int) (n%16));
    		n /= 16;
    	}
    	
    	while(!stack.empty())
    		result.append(num2Char[stack.pop()]);
    	
    	return result.toString();
    }
	
    /* best Solution
     * 用位运算是坠吼滴
     * 
     * */
//    public String toHex(int num) {
//        if(num == 0) return "0";
//        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
//        String result = "";
//        while(num != 0){
//            result = map[(num & 15)] + result; 
//            num = (num >>> 4);
//        }
//        return result;
//    }
    
    
	public static void main(String[] args) {
		Q405ConvertaNumbertoHexadecimal q = new Q405ConvertaNumbertoHexadecimal();
		int num = 0;
		
		System.out.println(q.toHex(num));;
	}

}
