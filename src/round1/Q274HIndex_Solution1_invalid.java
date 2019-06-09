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
 * 
 * */

public class Q274HIndex_Solution1_invalid {

	public int hIndex(int[] citations) {
		if (citations==null||citations.length==0)
			return 0;
		
		Arrays.sort(citations);
		for (int h=citations.length;h>=0;h--){
			int cnt = citations.length-search(citations, h, 0, citations.length-1);//TODO
			if (cnt==h)
				return h;
		}
		
		return 0;
	}
	
	
	/**
	 * return :>=target���е�����idx
	 * */
	
	//ʵ���ŷ��֣�����ֲ��Һ��Ѵ�����ⱳ���¸��ֱ߽�������������磺�����鳤��<2�����������п�С�����С�ڵ��ڡ�������������ʴ˷������ϣ��������Բ���
	//�����ַ���Ҳ����ܲ��ô�����������ı��־���ֱ���Ѿ�������������飬ֱ����������������ӶȾ�ֻ�ж���������
	public int search(int[] array, int target, int front, int rear){//����ֲ���
		//boundary condition
		if (array[front]>=target)
			return front;
		else if (array[rear]<target)
			return rear+1;
		
		int mid;
		while(rear-front!=1){//***bug: rear-front==1
			mid = (front+rear)/2;
			if (target<array[mid]){
				rear = mid;
			}else if (array[mid]<target){
				front = mid;
			}else{//find
				return mid;
			}
			
		}
		return rear;
	}

	public static void main(String[] args) {

		Q274HIndex_Solution1_invalid q = new Q274HIndex_Solution1_invalid();
//		int[] citations = {3,0,6,1,5};
		int[] citations = {0};
		System.out.println(q.hIndex(citations));;
	}

}
