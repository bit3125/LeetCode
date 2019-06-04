package leetcode.solutions;

public class Q048RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix==null || matrix[0].length==0)
        	return ;
        
        transpose(matrix);
        flip(matrix);
    }
    
    public void transpose(int[][] matrix){
    	int tmp;
    	for (int i=0;i<matrix.length;i++){
    		for (int j=i+1;j<matrix.length;j++){
    			tmp = matrix[i][j];
    			matrix[i][j] = matrix[j][i];
    			matrix[j][i] = tmp;
    		}
    	}
    	
    }
    
    public void flip(int[][] matrix){
    	int tmp, k;
    	for (int i=0;i<matrix.length;i++){
    		for (int j=0;j<matrix.length/2;j++){
    			k = matrix.length-j-1;
    			tmp = matrix[i][j];
    			matrix[i][j] = matrix[i][k];
    			matrix[i][k] = tmp;
    		}
    	}
    	
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
