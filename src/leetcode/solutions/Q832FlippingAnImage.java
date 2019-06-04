package leetcode.solutions;

public class Q832FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
    	if (A==null)
    		return null;

    	for (int[] row : A){
    		int front = 0, rear = row.length-1;
    		while (front<=rear){
    			int tmp = row[front]; 
        		row[front] = row[rear]^1;
        		row[rear] = tmp^1;
        		front++;
        		rear--;
    		}
    	}
    	return A;
    }
	
	public static void main(String[] args) {

	}

}
