/**算法分析：
 * 基本思路是对List进行遍历，取出相邻两个Interval a（左边界较小者）和b（左边界较大者）进行交集判断然后合并
 * 如果采取无序List遍历的话，复杂度为O(n^2)
 * 
 * 考虑先进行排序（复杂度O(nlogn)）再遍历。以左端点大小为key进行排序
 * 不断合并intervals[i] intervals[i+1]区间，直到无法合并，然后让i++，循环
 * 这样的话，只需线性遍历即可，因为区间们是有序的，相邻两个区间无交集的虎牙，intervals[i]与后面的所有区间定都无交集
 * 故只需遍历一次复杂度On，总复杂度为O(nlogn)
 * 
 * 区间判断合并有三种情况：1.无交集，a.end<b.start
 * 					2.有交集且不包含，a.end>=b.start && b.end>a.end
 * 					3.有交集且b含于a，a.end>=b.start && b.end<a.end
 * */

package round1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import structures.Interval;



public class Q056MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
    	if (intervals==null||intervals.size()==0){
    		List<Interval> result = new LinkedList<>();
    		return result;
    	}
    	
    	//others.sort O(nlogn)
    	intervals.sort(new Comparator<Interval>(){
    		@Override
    		public int compare(Interval o1, Interval o2){
    			if (o1.start<o2.start)
    				return -1;
    			else if (o1.start==o2.start)
    				return 0;
    			else
    				return 1;
    		}
		});
    	
    	//merge On
    	for (int i=0;i<intervals.size()-1;i++){
    		Interval a = intervals.get(i), b = intervals.get(i+1);
    		if (a.end>=b.start){ //***bug:a.end>b.start
    			Interval c = new Interval(a.start, Math.max(a.end, b.end));
    			intervals.remove(a);
    			intervals.remove(b);
    			intervals.add(i, c);
    			i--;
    		}
    	}
    	
    	return intervals;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
