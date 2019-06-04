package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q039CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates==null || candidates.length==0)
        	return results;
        
        int[] cnts = new int[candidates.length];
        Arrays.fill(cnts, 0);
        combinationSumCore(candidates, cnts, results, target, 0);
        
        return results;
    }
    
    public void combinationSumCore(int[] candidates, int[] cnts, List<List<Integer>> results, int target, int idx){
    	if (idx==candidates.length){
    		if (target==0){
    			List<Integer> result = new ArrayList<>();
    			for (int i=0;i<candidates.length;i++){
    				for (int j=0;j<cnts[i];j++)
    					result.add(candidates[i]);
    			}
    			results.add(result);
    		}
    		return ;
    	}
    	
    	for (cnts[idx] = target/candidates[idx];cnts[idx]>=0;cnts[idx]--){
    		combinationSumCore(candidates, cnts, results, target-candidates[idx]*cnts[idx], idx+1);
    	}
    	cnts[idx] = 0; //为了抵消其作为迭代器最后变成的-1.好像没必要？
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
