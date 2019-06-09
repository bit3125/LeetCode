package round1;
import java.util.Arrays;

/**�������������һ�����飬
 * ����Hindex�������������ҽ���h����>=h����ôh��Ϊһ��Hindex
 * �������Hindex
 * 
 * �㷨������
 * 1.��ʹ��������㷨����һ�飬�������Ӷ���T(n^2)
 * 2.��ʹ��Sn=O(��)���㷨����ô���ԴﵽO(n)�ĸ��Ӷȣ���������elementȡֵ��Χδ����Sn�޷�����
 * 3.��Ϊ���л��ֵ����ʣ�����ʹ��partition��һ��partition�ĸ��Ӷ���On���ܸ��Ӷ���O(n^2),��û�б�������
 * 4.���ǽ�O(n^2)���Ӷ��Ż���O(n*logn)���������������h��[0,N]����N��ʼ������������������ܸ��Ӷ�ΪO(nlogn)
 * 	��������ֲ��Ҳ����ã���ʹ�����Բ��ң����Ӷ���Ȼ���䣬��������
 * 
 * 
 * �˴�ΪSolution3�����Ӷ�ΪO(n)!!!���ڶ���˼·���иĽ�����>=n+1����������n+1������ʹ��On�Ŀռ临�ӶȴﵽĿ�ģ�
 * */

public class Q274HIndex_Solution3 {

	public int hIndex(int[] citations) {
		if (citations==null||citations.length==0)
			return 0;
		
		int n = citations.length;
		int[] cnts = new int[n+2];//hashatable, [0,citations.length+1],���д��ڵ���n+1�Ķ�����n+1
		//cnt
		for (int i=0;i<n;i++){
			if (citations[i]>=n+1)
				cnts[n+1]++;
			else
				cnts[citations[i]]++;
		}
		//accum
		int[] cntsAccum = new int[cnts.length];
		cntsAccum[cntsAccum.length-1] = cnts[cnts.length-1];
		for (int i=cntsAccum.length-2;i>=0;i--){
			cntsAccum[i] = cnts[i]+cntsAccum[i+1];
		}
		//search
		for (int h=n;h>=0;h--){
			if (cntsAccum[h]>=h)
				return h;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {

		Q274HIndex_Solution3 q = new Q274HIndex_Solution3();
//		int[] citations = {3,0,6,1,5};
		int[] citations = {0};
		System.out.println(q.hIndex(citations));;
	}

}
