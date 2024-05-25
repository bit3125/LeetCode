package others.algos.sort;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        quickSortCore(data, 0, data.length);
    }

    public void quickSortCore(int[] data, int start, int end) {
        if (end - start <= 1)
            return;

        int pivotIdx = partition(data, start, end);
        quickSortCore(data, start, pivotIdx);
        quickSortCore(data, pivotIdx + 1, end);
    }

    public int partition(int[] data, int start, int end) {
        if (end - start <= 1)
            return start;

        int front = start, rear = end - 1;
        int pivot = data[front];
        while (front < rear) {
            while (front < rear && data[rear] >= pivot)
                rear--;
            if (front < rear)//������Ϊ�ڶ��������������˳��ģ���˵��ǰ��ָ����δ�غϣ����Ը�ֵ�����غ���Ҳ�ܸ�ֵ
                data[front] = data[rear];
            while (front < rear && data[front] < pivot)
                front++;
            if (front < rear)
                data[rear] = data[front];
        }
        data[front] = pivot;//��ѭ����ʱ������front==rear
        return front;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] nums = new int[]{5, 3, 8, 5, 3, 2, 1, 9};
        qs.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
