package round1;
import java.util.List;
import java.util.ArrayList;

public class Q118PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> triangle = new ArrayList<>();
    	if (numRows<=0)
        	return triangle;
    	
    	for (int i=0;i<numRows;i++){
    		List<Integer> row = new ArrayList<>();
    		List<Integer> rowPrev = null;
    		for (int j=0;j<i+1;j++){
    			if (j==0 || (i>0 && j==i+1-1)){//是行首尾
    				row.add(1);
    			}else{//不是行首尾
    				rowPrev = triangle.get(triangle.size()-1);
    				row.add(rowPrev.get(j-1)+rowPrev.get(j));
    			}
    		}
    		triangle.add(row);
    	}
        
        return triangle;
    }
	
    public void toString(List<List<Integer>> tr){
    	for (int i=0;i<tr.size();i++){
    		List<Integer> row = tr.get(i);
    		for (int j=0;j<row.size();j++){
    			System.out.print(row.get(j)+",");
    		}
    		System.out.println();
    	}
    	
    }
    
	public static void main(String[] args) {
		Q118PascalsTriangle q = new Q118PascalsTriangle();
		int numRows = 11;
		
		q.toString(q.generate(numRows));
	}

}
