package round1;
import java.util.Arrays;

public class Q434NumberofSegmentsinaString {

    public int countSegments(String s) {
        if (s==null||s.length()==0||s.equals(""))
        	return 0;
        
        s = s.trim();
        if (s.equals(""))
        	return 0;
        
        int cnt = 0;
        int idx = 0;
        while(idx<s.length()){
        	if (s.charAt(idx)==' '){
        		cnt++;
        		while(s.charAt(idx)==' ')
        			idx++;
        		
        	}
        	idx++;
        }
        return cnt+1; 
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Q434NumberofSegmentsinaString q = new Q434NumberofSegmentsinaString();
		String s = "      ";
		System.out.println(q.countSegments(s));;

	}

}
