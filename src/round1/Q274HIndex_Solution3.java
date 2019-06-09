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
 * 	后发现类二分查找不好用，故使用线性查找，复杂度依然不变，不必在意
 * 
 * 
 * 此处为Solution3，复杂度为O(n)!!!将第二种思路进行改进，把>=n+1的数都归入n+1，就能使用On的空间复杂度达到目的！
 * */

public class Q274HIndex_Solution3 {

	public int hIndex(int[] citations) {
		if (citations==null||citations.length==0)
			return 0;
		
		int n = citations.length;
		int[] cnts = new int[n+2];//hashatable, [0,citations.length+1],所有大于等于n+1的都归入n+1
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
