package round1;
/**�㷨˼·��solution1�ĸ��ӶȻ���̫�ߣ��ٴγ���ʹ�ö�̬�滮����ά��
 * ��f[i][j]��ʾs.substr(i,j+1)�Ƿ��ǻ����Ӵ�
 * ��״̬ת�Ʒ������£�
 * f[i][j] = (i==j){����Ϊ1} || (j-i==1 && s[j]==s[i]){����Ϊ2} || ( j-i>1 && f[i+1][j-1]==true && s[j]==s[i])
 * 
 * ���������������i>j�Ĳ��ֶ�����������ȥ�ģ���ֻ�а��f��������Ч��
 * ��Ҫע��ת�Ʒ��̵�������ϵ��ȷ������ķ��򣬲�ȡi�ݼ���j������j����
 * 
 * �������Ӷ���Ȼ��O(n^2)?����runtime��������
 * */

import java.util.Arrays;

public class Q005LongestPalindromicSubstring_Solution2 {

	public static int MAXSIZE =1000;
    public String longestPalindrome(String s) {
    	if (s==null || s.length()==0)
    		return "";
    	
        boolean[][] f = new boolean[MAXSIZE][MAXSIZE];
        for (int i=0;i<s.length();i++){
        	Arrays.fill(f[i], false);
        }
        
        int maxLen=-1;
        int targetI = -1, targetJ = -1;
        for (int i=s.length()-1;i>=0;i--){
        	for (int j=i;j<s.length();j++){
        		int lenCur = j-i+1;
        		if ( (lenCur==1) || (lenCur==2 && s.charAt(i)==s.charAt(j)) 
        				|| (f[i+1][j-1]==true && s.charAt(j)==s.charAt(i)) ){
        			f[i][j] = true;
        			if (lenCur>maxLen){
        				maxLen = lenCur;
            			targetI = i;
            			targetJ = j;
        			}
        		}
        	}
        }
//        int maxLen=-1;
//        int targetI = -1, targetJ = -1;
//        for (int i=0;i<s.length();i++){
//        	for (int j=s.length()-1;j>=0;j--){//�ɴ�С��ʼ������ǰ��i����󳤶�
//        		int lenCur = j-i;
//        		if (lenCur<=maxLen)//ֱ��������ǰ�е�����
//        			break;
//        		if (f[i][j]){
//        			maxLen = lenCur;
//        			targetI = i;
//        			targetJ = j;
//        		}
//        	}
//        }
        
        return s.substring(targetI, targetJ+1);
    }
	
	public static void main(String[] args) {
		Q005LongestPalindromicSubstring_Solution1 q = new Q005LongestPalindromicSubstring_Solution1();
		String s = "bananas";
		System.out.println(q.longestPalindrome(s));
	}

}
