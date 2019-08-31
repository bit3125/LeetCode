/**�㷨�����������Ͼ��Ƕ�Ŀ�괮���ģʽ����Trie��������ģʽƥ��
 * Ŀ�괮��board����dfs����
 *
 * */

package round2.Q212WordSearchII;

import java.util.*;

class Solution {

    class Trie {
        private boolean isEnd;
        private Map<Character, Trie> sons;

        /** Initialize your data structure here. */
        public Trie() {
            this.isEnd = false;
            this.sons = new HashMap<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word==null || word.length()==0)
                return;

            Trie p = this;
            int idx = 0;
            char curChar;
            while (idx < word.length()) {
                curChar = word.charAt(idx);
                if (!p.sons.containsKey(curChar))
                    p.sons.put(curChar, new Trie());

                p = p.sons.get(curChar);
                idx++;
            }
            p.isEnd = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board==null || board.length==0 || words==null || words.length==0)
            return new ArrayList<>();

        Set<String> results = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], false);

        // build trie
        Trie trie = buildTrie(words);
        // search
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, visited, trie, i, j, results, sb);

        return new ArrayList<>(results);
    }

    /**boardΪĿ�괮��trieΪģʽ��
     * trie������ƥ�����ģʽ���ڵ㣬board[i][j]�Ǳ��ִ�ƥ���Ŀ�괮�ڵ�
     */
    private void dfs(char[][] board, boolean[][] visited, Trie trie, int i, int j, Set<String> results, StringBuilder sb) {
        if (trie.isEnd) // ����ƥ����Ľڵ�
            results.add(new String(sb)); // ���������ߣ�����return
        if (outOfRange(board, i, j) || visited[i][j] ) // Ŀ�괮�ݹ����
            return ;

        // visit
        char curChar = board[i][j];
        if (!trie.sons.containsKey(curChar)) // ģʽ���ݹ����
            return;
        // else: contains
        sb.append(curChar);
        trie = trie.sons.get(curChar); // ģʽ������
        visited[i][j] = true;

        // dfs
        dfs(board, visited, trie, i+1, j, results, sb);
        dfs(board, visited, trie, i-1, j, results, sb);
        dfs(board, visited, trie, i, j+1, results, sb);
        dfs(board, visited, trie, i, j-1, results, sb);

        // backtracking
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean outOfRange(char[][] board, int i, int j) {
        return !(0 <= i && i < board.length && 0 <= j && j < board[0].length);
    }

    public Trie buildTrie(String[] words) {
        if (words==null || words.length==0)
            return null;

        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++)
            trie.insert(words[i]);
        return trie;
    }
}