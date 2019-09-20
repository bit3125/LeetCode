/**�㷨������
 * һ·���󣬲���ѹջ
 * ������ѹջǰvisit���������ջ��visit
 * ��ջ��õ�mid node������ת��ͨ������
 *
 * */

package others.algos.treetraverse.norecursion.inorder;

import structures.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            // visit
            result.add(p.val);
            p = p.right;
        }

        return result;
    }
}

