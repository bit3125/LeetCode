/**�㷨��������Ȼ����inorderΪ����������С��Χ�޸�
 * ��֮ͬ����
 * 0. ����һ��prev��־����¼��һ�����ʵĽڵ㣬����ȡ��mid node��ʱ������ж��������Ƿ���visit
 * 1. ԭ�ȵĳ�ջ��Ϊȡ���۲졣������ȡ����Ҳ��ԭ�ȵĳ�ջ��mid node������������;��
 *      1. ��prev==p.right��Ը�mid node����visit��Ȼ�󽫸�mid node��ջ����
 *      2. ���ǣ�����mid node Ϊ�м̽��е�������ת��mid node��������ջ�У��Ա����visit
 *
 * */

package others.algos.treetraverse.norecursion.postorder;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>(), midNodeStack = new Stack<>();
        TreeNode p = root, prev = null; //***diff
        while (p != null || !stack.isEmpty()) { // ������Ϊ�� �� ջ����
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            //***diff �ڷ��ʵ���ǰmid node��ʱ���Ȳ��ż�������
            // �жϵ�ǰ�ǡ���mid nodeΪ�м�ת�����������ǡ�visit mid node��
            p = stack.peek();
            if (p.right == null || prev == p.right) { //***diff �������� �� �������ձ������꣬visit
                // visit
                result.add(p.val);
                stack.pop(); // mid nodeʹ����ϣ���֮

                prev = p; // ��¼��һ��visit��node
                p = null; // �������������ܽ����while��Ȼ�������ջ
            } else { // ��mid nodeΪ�м̽���ת��
                p = p.right; //***diff
            }
        }

        return result;
    }
}

