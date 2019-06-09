package round1;
/**使用迭代的方法
 * Tn = Ok
 * 
 * */

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class Q119PascalsTriangleII_Solution1 {

    public List<Integer> getRow(int rowIndex) {
    	List<Integer> row = new ArrayList<>();
    	if (rowIndex<0)
    		return row;
    	
    	int[] arr1 = new int[rowIndex+1];
    	int[] arr2 = new int[rowIndex+1];
    	int[] tmp;
    	for (int i=0;i<rowIndex+1;i++){
    		for (int j=0;j<i+1;j++){
    			if (j==0 || (i!=0 && j==i)){
    				arr2[j] = 1;
    			}else{
    				arr2[j] = arr1[j-1] + arr1[j];
    			}
    		}
    		//swap
    		tmp = arr1;
    		arr1 = arr2;
    		arr2 = tmp;
    	}
    	
    	return Arrays.stream(arr1).boxed().collect(Collectors.toList());
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
