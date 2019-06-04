package leetcode.solutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 本质就是个组合问题
 * */

public class Q401BinaryWatch {

	private List<String> results = new ArrayList<>();
	
	public List<String> readBinaryWatch(int num) {
    	if (num<0 || num>10)
    		return results;
    	
    	boolean[] bits = new boolean[10];
    	Arrays.fill(bits, false);
    	
    	readBinaryWatchCore(num, 0, bits);
    	return results;
    }
    
	/* 函数功能：从bits数组中挑出num个为1，剩下的为0
	 * 那么根据组合的递推规则，Cmn = f(m,n) = 0号位选中&&f(m-1,n-1) || 0号位不选中&&f(m-1,n)
	 * @param start: bits.length-start 相当于m
	 * @param num: 相当于n
	 * */
    public void readBinaryWatchCore(int num, int start, boolean[] bits){
    	if ( bits.length-start<num){ // 递归出口：m<n, 非法，不用继续下去
    		return ;
    	}
    	
    	if (num<=0){ //递归出口 :n<0
    		String res = bits2String(bits);
    		if (res!=null)
    			results.add(res);
    		return;
    	}
    	
    	bits[start] = true;
    	readBinaryWatchCore(num-1, start+1, bits);
    	bits[start] = false;
    	readBinaryWatchCore(num, start+1, bits);
    	//因为最后是以0赋值结束，故此处bits无需回溯了
    }
    
    /**将排列好的bits数组转化成时间字符串 
     * 并检查bits的合法性
     * 若不合法则return null
     * */
    public String bits2String(boolean[] bits){
    	int hour = 0, minute = 0;
    	int base = 8;
    	for (int i=0;i<4;i++){
    		hour |= bits[i]?base:0;
    		base >>= 1;
    	}
    	base = 32;
    	for (int i=4;i<bits.length;i++){
    		minute |= bits[i]?base:0;
    		base >>= 1;
    	}
    	
    	if ( !(0<=hour && hour<12 && 0<=minute && minute<60) )
    		return null;
    	
    	String hourStr = String.valueOf(hour);
    	String minuteStr = (minute<10?"0":"") + String.valueOf(minute);
    	return hourStr + ":" + minuteStr;
    }
	
    public void printList(){
    	
    	for (String result : results){
    		System.out.println(result);
    	}
    	
    	return ;
    }
    
	public static void main(String[] args) {
		Q401BinaryWatch q = new Q401BinaryWatch();
		int num = 1;
		
		q.readBinaryWatch(num);
		q.printList();
	}

}
