package round1;
import java.util.Arrays;

public class Q006ZigZagConversion {

//    public String convert(String s, int numRows) {
//    	if (s==null)
//    		return null;
//    	else if (numRows<=0)
//    		return null;
//    	else if (numRows==1) //***bug:numRows==1ʱ��������淽���Ļ�����T==0�������
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
//    	for (int r = 0;r<numRows;r++){//�����ַ�����ÿ�б���
//    		for (int i=0;i<s.length();i++){//��ԭʼ�ַ�����һ�α���
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
    	else if (numRows==1) //***bug:numRows==1ʱ��������淽���Ļ�����T==0�������
    		return s;
    	
    	int T = 2*numRows-2;
    	char[] charSeq = new char[s.length()];  
		Arrays.fill(charSeq, ' ');
    	StringBuilder retS = new StringBuilder(new String(charSeq));
    	
    	//�����´���ÿ�е��ۼ��ַ�����
    	int NUM_T = (s.length()-1)/T; // ǰ�澭���������� //***bug:���㱾λi֮ǰ������������������i����������Ҫ-1
    	int LEFT = s.length()%T;
    	if (LEFT==0) LEFT = T;
    	int step; //from 1 on
    	int[] rowSizesCumSum = new int[numRows];
    	rowSizesCumSum[0] = NUM_T+(LEFT>0?1:0); //***bug:��Ŀ��������ʽҪ�����š�����
    	for (int r=1;r<numRows-1;r++){//�����м���
    		step = numRows+(numRows-(r+1));//from 1 on ��ǰλ�� 
    		//���㵱ǰ������
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
//    		if (LEFT<r+1); //***bug����ʣ������û�ﵽ����
//    		else if (LEFT<=numRows) //***bug:�Ⱥŷ�����
//    			rowSizesCumSum[r]++;
//    		else if (numRows<LEFT && step<=LEFT) //***bug:else if (numRows<LEFT) 
//    			rowSizesCumSum[r] += 2;
    		//���㵱ǰ���ۼ�ֵ
    		rowSizesCumSum[r] += rowSizesCumSum[r-1];
    	}
    	rowSizesCumSum[numRows-1] = NUM_T+(LEFT>=numRows?1:0) + rowSizesCumSum[numRows-2]; //***bug:��Ŀ��������ʽҪ������ 

    	for (int i=0;i<rowSizesCumSum.length;i++){
    		System.out.println(rowSizesCumSum[i]);
    	}
    	
    	//TODO  Ҫ����step�Ŀ��� �������ˣ�����������
		//����ÿ���ַ���newIdx��insert�´�
    	for (int i=0;i<s.length();i++){
    		//������ַ����´��е��к�
    		int t = (i+1-1)/T; // ǰ�澭���������� //***bug:���㱾λi֮ǰ������������������i����������Ҫ-1
    		int left = (i+1)%T; //�������е�����
    		if (left==0) left = T; //***bug
    		int rowNum;  // from 0 on
    		if (left<numRows)
    			rowNum = left-1;
    		else//
    			rowNum = 2*numRows-left-1;
   
    		int idxAtNewS = rowNum==0?-1:(rowSizesCumSum[rowNum-1]-1);
    		if (rowNum == 0||rowNum == numRows-1)
    			idxAtNewS += t+1; //���ϸ�rowǰ����� �Լ��Լ�����
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
		// TODO �Զ����ɵķ������
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
