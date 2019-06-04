/**算法分析：就是基础的Trie树的实现
 *
 * Trie树的结构：每个Node由isEnd标记与sons HashMap组成。isEnd是用来表示此节点是否是某个串的尾结点（必须要有）。
 * 之所以使用一个HashMap来存储而不是用一个简单的List来存储子节点，是为了在检索下一个字符的时候能够达到O1的复杂度，
 * 而如果使用List的话需要遍历。然后由于父节点中已经存储了子节点的data，故子节点中不再存冗余的data，这就是为什么
 * TrieNode节点内没有root.val的原因。
 *
 * 对Trie数有几个基本操作：insert，search。
 * 这些基本操作都是沿着某条路径走，类似于BST，而非二叉树、树那样的需要对全树进行遍历，故使用循环完全可以实现，
 * 而且循环效率更高。
 *
 * 在进行遍历操作的时候，可能出现三种情况：
 * 1.树先到底；2.串先到底；3.串树不匹配
 * 针对这，使用基于串的for循环进行遍历，这样就可以简化问题，for循环结束就是串到底了
 *
 * */

package leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class Q208ImplementTrie {

    class Trie{

        boolean isEnd;
        Map<Character, Trie> sons ;

        /** Initialize your data structure here. */
        public Trie() {
            sons = new HashMap<>();
            isEnd = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word.length()==0)
                return ;

            Trie curNode = this, nextNode;
            char c;
            for (int i = 0; i < word.length(); i++) {
                c = word.charAt(i);
                nextNode = curNode.sons.get(c);
                if (nextNode==null){ //doesn't contain
                    nextNode = new Trie();
                    curNode.sons.put(c, nextNode);
                }
                curNode = nextNode;
            }
            curNode.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word.length()==0)
                return false;

            Trie curNode = this, nextNode;
            char c;
            for (int i = 0; i < word.length(); i++) {
                c = word.charAt(i);
                curNode = curNode.sons.get(c);
                if (curNode == null)  //树先到底 || 树与串不匹配
                    return false;
            }
            return curNode.isEnd; //串先到底
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix.length()==0)
                return false;

            Trie curNode = this;
            char c;
            for (int i = 0; i < prefix.length(); i++) {
                c = prefix.charAt(i);
                curNode = curNode.sons.get(c);
                if (curNode == null)  //树先到底 || 树与串不匹配
                    return false;
            }
            return true;
        }

    }

}
