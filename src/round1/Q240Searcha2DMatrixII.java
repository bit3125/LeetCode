package round1;

public class Q240Searcha2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0)
        	return false;
        
        int i = 0, j = matrix[0].length-1;
        while(i<=matrix.length-1 && 0<=j){
        	if (matrix[i][j]>target){
        		j--;
        	}else if(matrix[i][j]<target){
        		i++;
        	}else { //matrix[i][j]==target
        		return true;
        	}
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
