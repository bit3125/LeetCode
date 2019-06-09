package round1;

public class Q342PowerofFour {

    public boolean isPowerOfFour(int num) {
    	if (num<=0)
    		return false;
    	
    	while(num>1){
    		int res = (num & 3);
    		if (res!=0)
    			return false;
    		
    		num >>= 2;
    	}
    	
    	return true;
    } 
	
	public static void main(String[] args) {
		Q342PowerofFour q = new Q342PowerofFour();
		int num = 16;
		
		System.out.println(q.isPowerOfFour(num));
			
	}

}
