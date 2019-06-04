/**算法分析：top-k 问题都可以考虑使用heap（或者说一个小窗口？）
 * 
 * */
package leetcode.solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Q347TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnts = new HashMap<>();
        PriorityQueue<Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
        		new Comparator<Entry<Integer, Integer>>() {
        			@Override
        			public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2){
        				return e1.getValue().compareTo(e2.getValue());
        			}
        			
		});
        
        //cnt 
    	for (int i=0;i<nums.length;i++){
    		cnts.put(nums[i], cnts.getOrDefault(nums[i], 0)+1);
    	}
    	//find top k freq
    	for (Entry<Integer, Integer> entry : cnts.entrySet()){
    		if (minHeap.size()<k){
    			minHeap.add(entry);
    		}else{
    			if (entry.getValue()>minHeap.peek().getValue()){
    				minHeap.poll();
    				minHeap.add(entry);
    			}
    		}
    	}
    	//get list
    	List<Integer> result = new ArrayList<>();
    	for (Entry<Integer, Integer> entry : minHeap){
    		result.add(entry.getKey());
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
