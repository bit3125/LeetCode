package round1;
import java.util.Arrays;

public class Q006ZigZagConversion {

//    public String convert(String s, int numRows) {
//    	if (s==null)
//    		return null;
//    	else if (numRows<=0)
//    		return null;
//    	else if (numRows==1) //***bug:numRows==1时如果用下面方法的话计算T==0，会出错
//    		return s;
//    	
//    	int T = 2*numRows-2;
//    	int[] rowNums = new int[s.length()];
//    	int rowNum = 0;
//    	StringBuilder retS = new StringBuilder(s.length());
//    	
//    	for (int i=0;i<s.length();i++){
//    		rowNum = i%T;
//    		rowNum = rowNum<numRows?rowNum:2*numRows-rowNum-2; //numRows-1-(rownum-numRows+1);
//    		rowNums[i] = rowNum;
//    	}
//    	
//    	int insertIdx = 0;
//    	for (int r = 0;r<numRows;r++){//对新字符串的每行遍历
//    		for (int i=0;i<s.length();i++){//对原始字符串做一次遍历
//    			if (rowNums[i]==r){
//    				retS.append(s.charAt(i));
//    				insertIdx++;
//    			}
//    		}
//    	}
//    	
//    	return retS.toString();
//    }
    
	public String convert(String s, int numRows) {
    	if (s==null)
    		return null;
    	else if (numRows<=0)
    		return null;
    	else if (numRows==1) //***bug:numRows==1时如果用下面方法的话计算T==0，会出错
    		return s;
    	
    	int T = 2*numRows-2;
    	char[] charSeq = new char[s.length()];  
		Arrays.fill(charSeq, ' ');
    	StringBuilder retS = new StringBuilder(new String(charSeq));
    	
    	//计算新串中每行的累计字符总数
    	int NUM_T = (s.length()-1)/T; // 前面经过的周期数 //***bug:计算本位i之前经历过的周期数，故i不能算在内要-1
    	int LEFT = s.length()%T;
    	if (LEFT==0) LEFT = T;
    	int step; //from 1 on
    	int[] rowSizesCumSum = new int[numRows];
    	rowSizesCumSum[0] = NUM_T+(LEFT>0?1:0); //***bug:三目运算符表达式要加括号。。。
    	for (int r=1;r<numRows-1;r++){//计算中间行
    		step = numRows+(numRows-(r+1));//from 1 on 当前位置 
    		//计算当前行总数
    		rowSizesCumSum[r] = NUM_T*2;
    		if (step<=numRows){
    			if (step<=LEFT)
    				rowSizesCumSum[r] += 1;
    			else;
    		}
    		else{ //numRows<step
    			if (step<=LEFT)
    				rowSizesCumSum[r] += 2;
    			else
    				rowSizesCumSum[r] += 1;
    		}
//    		if (LEFT<r+1); //***bug：当剩余数字没达到此行
//    		else if (LEFT<=numRows) //***bug:等号放这里
//    			rowSizesCumSum[r]++;
//    		else if (numRows<LEFT && step<=LEFT) //***bug:else if (numRows<LEFT) 
//    			rowSizesCumSum[r] += 2;
    		//计算当前行累计值
    		rowSizesCumSum[r] += rowSizesCumSum[r-1];
    	}
    	rowSizesCumSum[numRows-1] = NUM_T+(LEFT>=numRows?1:0) + rowSizesCumSum[numRows-2]; //***bug:三目运算符表达式要加括号 

    	for (int i=0;i<rowSizesCumSum.length;i++){
    		System.out.println(rowSizesCumSum[i]);
    	}
    	
    	//TODO  要加入step的考量 不想做了！！！！！！
		//计算每个字符的newIdx并insert新串
    	for (int i=0;i<s.length();i++){
    		//计算该字符在新串中的行号
    		int t = (i+1-1)/T; // 前面经过的周期数 //***bug:计算本位i之前经历过的周期数，故i不能算在内要-1
    		int left = (i+1)%T; //本周期中的余数
    		if (left==0) left = T; //***bug
    		int rowNum;  // from 0 on
    		if (left<numRows)
    			rowNum = left-1;
    		else//
    			rowNum = 2*numRows-left-1;
   
    		int idxAtNewS = rowNum==0?-1:(rowSizesCumSum[rowNum-1]-1);
    		if (rowNum == 0||rowNum == numRows-1)
    			idxAtNewS += t+1; //加上该row前面的数 以及自己本身
    		else{
    			idxAtNewS += 2*t;
    			if (left<rowNum+1);
    			if (left<=numRows)
    				idxAtNewS++;
    			else if (numRows<left)
    				idxAtNewS+=2;
    		}
    		retS.setCharAt(idxAtNewS, s.charAt(i));
    	}
    	
    	return retS.toString();
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		String s = "PAYPALISHIRING";
//		int numRows = 3;
//		String s = "PAYPALISHIRING";
//		int numRows = 4;
//		String s = "abcdefg";
//		int numRows = 2;
//		String s = "PAYPALISHIRING";
//		int numRows = 6;
		String s = "abcdE";
		int numRows = 4;
		
//		String s = "ABC";
//		int numRows = 3;
		
		
		Q006ZigZagConversion q = new Q006ZigZagConversion();
		System.out.println(q.convert(s, numRows));
	}

}
