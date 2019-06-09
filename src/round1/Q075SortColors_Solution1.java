package round1;

import java.util.Arrays;

public class Q075SortColors_Solution1 {

	public void sortColors(int[] nums) {
        if (nums==null||nums.length==0)
        	return;

        int[] cnts = new int[3];
        Arrays.fill(cnts, 0);
        for (int i=0;i<nums.length;i++){
        	cnts[nums[i]]++;
        }
        
        int idx = 0;
        for (int i=0;i<cnts.length;i++){
        	while(cnts[i]>0){
        		nums[idx++] = i;
        		cnts[i]--;
        	}
        }
    }
	
	public static void main(String[] args) {
		Q075SortColors_Solution1 q = new Q075SortColors_Solution1();
		int[] nums = new int[]{1,0};
		q.sortColors(nums);
		
		System.out.println(Arrays.toString(nums));
		
	}

}
