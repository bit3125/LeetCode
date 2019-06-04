/**�㷨���������ǻ�����Trie����ʵ��
 *
 * Trie���Ľṹ��ÿ��Node��isEnd�����sons HashMap��ɡ�isEnd��������ʾ�˽ڵ��Ƿ���ĳ������β��㣨����Ҫ�У���
 * ֮����ʹ��һ��HashMap���洢��������һ���򵥵�List���洢�ӽڵ㣬��Ϊ���ڼ�����һ���ַ���ʱ���ܹ��ﵽO1�ĸ��Ӷȣ�
 * �����ʹ��List�Ļ���Ҫ������Ȼ�����ڸ��ڵ����Ѿ��洢���ӽڵ��data�����ӽڵ��в��ٴ������data�������Ϊʲô
 * TrieNode�ڵ���û��root.val��ԭ��
 *
 * ��Trie���м�������������insert��search��
 * ��Щ����������������ĳ��·���ߣ�������BST�����Ƕ�����������������Ҫ��ȫ�����б�������ʹ��ѭ����ȫ����ʵ�֣�
 * ����ѭ��Ч�ʸ��ߡ�
 *
 * �ڽ��б���������ʱ�򣬿��ܳ������������
 * 1.���ȵ��ף�2.���ȵ��ף�3.������ƥ��
 * ����⣬ʹ�û��ڴ���forѭ�����б����������Ϳ��Լ����⣬forѭ���������Ǵ�������
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
                if (curNode == null)  //���ȵ��� || ���봮��ƥ��
                    return false;
            }
            return curNode.isEnd; //���ȵ���
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
                if (curNode == null)  //���ȵ��� || ���봮��ƥ��
                    return false;
            }
            return true;
        }

    }

}
