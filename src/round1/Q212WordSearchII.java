package round1;

import java.util.*;

public class Q212WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        if (board==null || board.length==0 || words==null || words.length==0)
            return new ArrayList<>();
        //init
        Set<String> set = new HashSet<>();
        Trie trie = createTrie(words);
        int maxSize = Integer.MIN_VALUE;
        for (String word : words)
            if (word.length() > maxSize)
                maxSize = word.length();
        char[] result = new char[maxSize];
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], false);
        //search
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                searchBoard(board, i, j, visited, trie, result, 0, set);

        return new ArrayList<>(set);
    }

    /**recursion
     * */
    private void searchBoard(char[][] board, int i, int j , boolean[][] visited,
                             Trie prevNode, char[] result , int size, Set<String> set){
        if (outOfBound(board, i, j) || visited[i][j]/* || prevNode==null*/)
            return;

        Trie curNode = prevNode.sons.get(board[i][j]);
        if (curNode!=null){ //board[i][j]在Trie上找到了
            result[size] = board[i][j];
            size++;
            visited[i][j] = true;
            if (curNode.isEnd) {
                set.add(new String(result, 0, size));
            }//此处不能立即return，可能再往下走还有别的word
            searchBoard(board, i + 1, j, visited, curNode, result, size, set);
            searchBoard(board, i, j + 1, visited, curNode, result, size, set);
            searchBoard(board, i - 1, j, visited, curNode, result, size, set);
            searchBoard(board, i, j - 1, visited, curNode, result, size, set) ;
            visited[i][j] = false; //size为局部变量 无需回溯；result的后位跟着size变无需回溯
        }
    }

    private boolean outOfBound(char[][] board, int i, int j) {
        return !(0<=i && i <board.length && 0<=j && j<board[0].length);
    }

    private Trie createTrie(String[] words) {
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++)
            root.insert(words[i]);
        return root;
    }

    private class Trie{
        private boolean isEnd;
        private Map<Character, Trie> sons = new HashMap<>();

        public void insert(String str) {
            if (str.equals( "" ))
                return;

            Trie curNode = this, nextNode;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                nextNode = curNode.sons.get(c);
                if (nextNode == null) {
                    nextNode = new Trie();
                    curNode.sons.put(c, nextNode);
                }
                curNode = nextNode;
            }
            curNode.isEnd = true;
        }

    }

}
