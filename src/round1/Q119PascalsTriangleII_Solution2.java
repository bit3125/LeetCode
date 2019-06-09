package round1;
/**使用通项公式，
 * Tn  = O(1)
 * 
 * A[m,n] = C(m-1,n-1) 
 * */
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class Q119PascalsTriangleII_Solution2 {

	public List<Integer> getRow(int rowIndex) {
    	List<Integer> row = new ArrayList<>();
    	if (rowIndex<0)
    		return row;

    	long res = 1; //***bug:overflow
    	row.add(1);
    	for (int i=1;i<=rowIndex;i++){//rowIndex==m, i==n
    		res = res*(rowIndex-i+1)/i;
    		row.add((int)res);
    	}
    	
    	return row;
    }
    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Q119PascalsTriangleII_Solution2 q = new Q119PascalsTriangleII_Solution2();
		int rowIndex = 5;
		
		System.out.println(q.getRow(rowIndex));
		System.out.println(Integer.MAX_VALUE);
	}

}
