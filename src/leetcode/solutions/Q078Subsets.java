package leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Q078Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums==null || nums.length==0)
        	return results;
        
        boolean[] marks = new boolean[nums.length];
        subsetsCore(nums, marks, results, 0);
        return results;
    } 
    
    public void subsetsCore(int[] nums, boolean[] marks, List<List<Integer>> results, int idx){
    	if (idx==nums.length){
    		List<Integer> result = new ArrayList<>();
    		for (int i=0;i<nums.length;i++){
    			if(marks[i])
    				result.add(nums[i]);
    		}
    		results.add(result);
    		return;
    	}
    	
    	marks[idx] = true;
    	subsetsCore(nums, marks, results, idx+1);
    	marks[idx] = false;
    	subsetsCore(nums, marks, results, idx+1);
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
