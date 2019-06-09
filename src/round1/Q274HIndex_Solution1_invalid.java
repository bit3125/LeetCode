package round1;
import java.util.Arrays;

/**问题分析：给定一个数组，
 * 定义Hindex：若数组中有且仅有h个数>=h，那么h即为一个Hindex
 * 输出最大的Hindex
 * 
 * 算法分析：
 * 1.若使用最暴力的算法遍历一遍，最坏情况复杂度是T(n^2)
 * 2.若使用Sn=O(∞)的算法，那么可以达到O(n)的复杂度，但是由于element取值范围未定，Sn无法接受
 * 3.因为具有划分的性质，考虑使用partition，一次partition的复杂度是On，总复杂度是O(n^2),并没有本质区别
 * 4.考虑将O(n^2)复杂度优化到O(n*logn)：将数组进行排序，h∈[0,N]，从N开始进行类二分搜索，故总复杂度为O(nlogn)
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
	 * return :>=target子列的列首idx
	 * */
	
	//实现着发现，类二分查找很难处理此题背景下各种边界条件的情况，如：“数组长度<2”，“左子列可小于亦可小于等于”等特殊情况，故此方案作废，改用线性查找
	//后来又发现也不会很不好处理。。。本题的变种就是直接已经经过排序的数组，直接用类二分搜索复杂度就只有对数级别了
	public int search(int[] array, int target, int front, int rear){//类二分查找
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
