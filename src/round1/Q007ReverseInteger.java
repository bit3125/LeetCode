package round1;

public class Q007ReverseInteger {

	public int reverse(int x) {
    	boolean positive = x>=0;
    	x = positive?x:-x;
    	StringBuilder str = new StringBuilder(String.valueOf(x));
    	int front = 0, rear = str.length()-1;
    	char tmp;
    	
    	while (front<rear){
    		tmp = str.charAt(front);
    		str.setCharAt(front, str.charAt(rear));
    		str.setCharAt(rear, tmp);
    		
    		front++;
    		rear--;
    	}
    	
    	String maxStr = String.valueOf(Integer.MAX_VALUE);
    	while(str.length()<maxStr.length()){
    		str.insert(0, '0');
    	}
    	if (positive){
    		if (String.valueOf(Integer.MAX_VALUE).compareTo(new String(str))<0)
    			return 0;
    	}else{
    		str.insert(0, '-');
    		if (String.valueOf(Integer.MIN_VALUE).compareTo(new String(str))<0)
    			return 0;
    	}
    	
    	return Integer.valueOf(new String(str));
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Q007ReverseInteger q = new Q007ReverseInteger();
		System.out.println(q.reverse(123456));
		System.out.println(Integer.MAX_VALUE);
	}

}
