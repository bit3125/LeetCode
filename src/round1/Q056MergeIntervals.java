/**�㷨������
 * ����˼·�Ƕ�List���б�����ȡ����������Interval a����߽��С�ߣ���b����߽�ϴ��ߣ����н����ж�Ȼ��ϲ�
 * �����ȡ����List�����Ļ������Ӷ�ΪO(n^2)
 * 
 * �����Ƚ������򣨸��Ӷ�O(nlogn)���ٱ���������˵��СΪkey��������
 * ���Ϻϲ�intervals[i] intervals[i+1]���䣬ֱ���޷��ϲ���Ȼ����i++��ѭ��
 * �����Ļ���ֻ�����Ա������ɣ���Ϊ������������ģ��������������޽����Ļ�����intervals[i]�������������䶨���޽���
 * ��ֻ�����һ�θ��Ӷ�On���ܸ��Ӷ�ΪO(nlogn)
 * 
 * �����жϺϲ������������1.�޽�����a.end<b.start
 * 					2.�н����Ҳ�������a.end>=b.start && b.end>a.end
 * 					3.�н�����b����a��a.end>=b.start && b.end<a.end
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
		// TODO �Զ����ɵķ������

	}

}
