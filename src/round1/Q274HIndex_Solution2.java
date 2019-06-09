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
 * */

public class Q274HIndex_Solution2 {

	public int hIndex(int[] citations) {
		if (citations==null||citations.length==0)
			return 0;
		
		Arrays.sort(citations);
		for (int h=citations.length;h>=0;h--){
			if (isHIdex(citations, h))
				return h;
		}
		
		return 0;
	}
	
	public boolean isHIdex(int[] sortedArray, int h){
		if (h==0)
			return sortedArray[sortedArray.length-1]<=h;
		else if (h==sortedArray.length)
			return sortedArray[0]>=h;
			
		int firstIdx = sortedArray.length-h;
		return (sortedArray[firstIdx]>=h && sortedArray[firstIdx-1]<=h);
	}
	
	public static void main(String[] args) {

		Q274HIndex_Solution2 q = new Q274HIndex_Solution2();
		int[] citations = {3,0,6,1,5};
//		int[] citations = {0};
		System.out.println(q.hIndex(citations));;
	}

}
