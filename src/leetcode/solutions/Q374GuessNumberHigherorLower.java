package leetcode.solutions;

public class Q374GuessNumberHigherorLower {

	private int pick;
	
    public int guessNumber(int n) {
        if (n<1)
        	return -1;
    	
    	int front, rear, mid = 0;
        
    	front = 1;
    	rear = n;
    	while(front<=rear){
    		mid = front + (rear-front)/2; //***bug:ÓÃ+ / »áÒç³ö
    		if (guess(mid)<0)
    			rear = mid-1;
    		else if (guess(mid)>0)
    			front = mid+1;
    		else //guess(mid)==0
    			return mid;
    	}

    	return mid;
    }
	
    public int guess(int num){
    	int ret;
    	if (pick<num)
    		ret = -1;
    	else if (num<pick)
    		ret = 1;
    	else
    		ret = 0;
    	
    	return ret;
    }
    
    public void setPick(int pick){
    	this.pick = pick;
    }
    
	public static void main(String[] args) {
		Q374GuessNumberHigherorLower q = new Q374GuessNumberHigherorLower();
		int n = 2126753390;
		int pick = 1702766719;
		
		q.setPick(pick);
		System.out.println(q.guessNumber(n));
		
	}

}
