package others.algos.sort;

public class QuickSort {

	public void QuickSort(int[] data, int start, int end){
		if (start>=end)
			return;
		
		int privotIdx = partition(data, start, end);
		QuickSort(data, start, privotIdx);
		QuickSort(data, privotIdx+1, end);
	}
	
	public int partition(int[] data, int start, int end){
		if (start>=end)
			return start;//TODO
		
		int front = start, rear = end-1;
		int privot = data[front];
		while(front<rear){
			while(front<rear && data[rear]>=privot)
				rear--;
//			if (front<rear)//������Ϊ�ڶ��������������˳��ģ���˵��ǰ��ָ����δ�غϣ����Ը�ֵ�����غ���Ҳ�ܸ�ֵ
				data[front] = data[rear];
			while(front<rear && data[front]<=privot)
				front++;
//			if (front<rear)
				data[rear] = data[front];
		}
		data[front] = privot;//��ѭ����ʱ������front==rear
		return front;
	}
	
}
