/**�㷨������
 * ��ָofferԭ�⣬�ؼ��㣺
 * 1.����ջ���棻2.��ż��������������push˳��
 *
 * */

package round1;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root==null )
            return results;

        Stack<TreeNode> s1 = new Stack(), s2 = new Stack(), stmp;
        s1.push(root);
        boolean oddLevel = true;
        List<Integer> result = new ArrayList<>();
        TreeNode curNode;
        while (!s1.isEmpty()) {
            //visit
            curNode = s1.pop();
            result.add(curNode.val);
            //push
            if (oddLevel){
                if (curNode.left!=null) s2.push(curNode.left);
                if (curNode.right!=null) s2.push(curNode.right);
            }else{
                if (curNode.right!=null) s2.push(curNode.right);
                if (curNode.left!=null) s2.push(curNode.left);
            }

            if (s1.isEmpty()){
                results.add(result);
                result = new ArrayList<>();

                //swap
                stmp = s1;
                s1 = s2;
                s2 = stmp;
                oddLevel = !oddLevel;
            }
        }
        return results;
    }

}
