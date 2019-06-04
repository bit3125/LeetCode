package leetcode.solutions;

import java.util.Arrays;

public class Q079WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board==null || board.length==0 || word==null || word.length()==0)
        	return false;
        
        //init
        boolean[][] visited = new boolean[board.length][board[0].length];
    	for (int i=0;i<visited.length;i++)
    		Arrays.fill(visited[i], false);
        hasFound = false;
        
        //search
        for (int i=0;i<board.length;i++){
        	for (int j=0;j<board[0].length;j++){
        		DFS(board, word, visited, 0, i, j);
        		if (hasFound)
        			break;
        	}
        	if (hasFound)
        		break;
        }
    	
        return hasFound;
    }
    
    boolean hasFound = false;
    public void DFS(char[][] board, String word,boolean[][] visited, int curIdx, int i, int j){
    	if (hasFound || outOfRange(board, i, j) || visited[i][j])
    		return;
    	
    	//visit
    	if (word.charAt(curIdx)!=board[i][j])
    		return ;
    		//else
		curIdx++;
		if (curIdx==word.length()){
			hasFound = true;
			return; //¼ôÖ¦
		}
				//else
		visited[i][j] = true; 
    	
    	//DFS
    	DFS(board, word, visited, curIdx, i+1, j);
    	DFS(board, word, visited, curIdx, i-1, j);
    	DFS(board, word, visited, curIdx, i, j+1);
    	DFS(board, word, visited, curIdx, i, j-1);
    	//backtracking
    	visited[i][j] = false;
    }
    
    public boolean outOfRange(char[][] board, int i, int j){
    	return !(0<=i && i<board.length && 0<=j && j<board[0].length) ;
    }
	
	public static void main(String[] args) {

	}

}
