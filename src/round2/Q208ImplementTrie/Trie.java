package round2.Q208ImplementTrie;

import java.util.HashMap;
import java.util.Map;

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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word==null)
            return false;
        if (word.length()==0)
            return true;

        Trie p = this;
        int idx = 0;
        char curChar;
        while (idx<word.length()) {
            curChar = word.charAt(idx);
            if (!p.sons.containsKey(curChar))
                return false;
            p = p.sons.get(word.charAt(idx));
            idx++;
        }
        return p.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix==null)
            return false;
        if (prefix.length()==0)
            return true;

        Trie p = this;
        int idx = 0;
        char curChar ;
        while (idx < prefix.length()) {
            curChar = prefix.charAt(idx);
            if (!p.sons.containsKey(curChar))
                return false;

            p = p.sons.get(curChar);
            idx++;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */