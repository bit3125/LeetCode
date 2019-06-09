package others.sort;

import java.util.Arrays;

public class QuickSortTMP {

	
	public void quickSort(int[] data, int start, int end){
		if (start>=end)
			return;
		
		int pivotIdx = partition(data, start, end);
		quickSort(data, start, pivotIdx-1);
		quickSort(data, pivotIdx+1, end);
	}

	/* return pivotIdx 
	 * */
	public int partition(int[] data, int start, int end){
		if (start>=end)
			return start;
		
		int pivot = data[start];
		int front = start+1;
		int rear = end;
		while(start<end){//TODO
			while(start<end && data[end]>=pivot)
				end--;
			if (start<end)
				data[start] = data[end];
			while(start<end && data[start]<=pivot)
				start++;
			if (start<end)
				data[end] = data[start];
		}
		data[start] = pivot;
		return start;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		QuickSortTMP q = new QuickSortTMP();
		int[] data = {11,5,8,7,5,6,4,1,2,6,9,8,7};
		
		q.quickSort(data, 0, data.length-1);
		System.out.println(Arrays.toString(data));
	}

}
