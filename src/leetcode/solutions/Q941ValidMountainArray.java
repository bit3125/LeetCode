package leetcode.solutions;

public class Q941ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A==null || A.length<3)
            return false;
        
        if (A[0]>A[1] || A[A.length-2]<A[A.length-1])
            return false;
        
        int idx = 1;
        while(idx<A.length && A[idx-1]<A[idx]){
            if (A[idx-1]==A[idx])
                return false;
            idx++;
        }
        while(idx<A.length && A[idx-1]>A[idx]){
            if (A[idx-1]==A[idx])
                return false;
            idx++;
        }        
        return idx==A.length;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
