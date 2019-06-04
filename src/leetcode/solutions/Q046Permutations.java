package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q046Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums==null || nums.length==0)
        	return results;
        
        permutations(nums, results, 0);
        return results;
    }
    
    public void permutations(int[] nums, List<List<Integer>> results, int idx){
    	if (idx==nums.length){
    		List<Integer> result = new ArrayList<Integer>();
    		for (int i=0;i<nums.length;i++) //int[] 实在没有API可以转成 Integer[]
    			result.add(nums[i]);
    		results.add(result);
    		return;
    	}
    	
    	for (int i=idx;i<nums.length;i++){
    		swap(nums, i, idx);
    		permutations(nums, results, idx+1);
    		swap(nums, i, idx);
    	}
    }
    
    public void swap(int[] nums, int idx1, int idx2){
    	int tmp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = tmp;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
