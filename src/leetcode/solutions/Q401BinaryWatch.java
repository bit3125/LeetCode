package leetcode.solutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* ���ʾ��Ǹ��������
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
    
	/* �������ܣ���bits����������num��Ϊ1��ʣ�µ�Ϊ0
	 * ��ô������ϵĵ��ƹ���Cmn = f(m,n) = 0��λѡ��&&f(m-1,n-1) || 0��λ��ѡ��&&f(m-1,n)
	 * @param start: bits.length-start �൱��m
	 * @param num: �൱��n
	 * */
    public void readBinaryWatchCore(int num, int start, boolean[] bits){
    	if ( bits.length-start<num){ // �ݹ���ڣ�m<n, �Ƿ������ü�����ȥ
    		return ;
    	}
    	
    	if (num<=0){ //�ݹ���� :n<0
    		String res = bits2String(bits);
    		if (res!=null)
    			results.add(res);
    		return;
    	}
    	
    	bits[start] = true;
    	readBinaryWatchCore(num-1, start+1, bits);
    	bits[start] = false;
    	readBinaryWatchCore(num, start+1, bits);
    	//��Ϊ�������0��ֵ�������ʴ˴�bits���������
    }
    
    /**�����кõ�bits����ת����ʱ���ַ��� 
     * �����bits�ĺϷ���
     * �����Ϸ���return null
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
