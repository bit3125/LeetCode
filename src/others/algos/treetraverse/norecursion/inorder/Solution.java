/**算法分析：
 * 一路向左，不断压栈
 * 先序则压栈前visit，中序则出栈后visit
 * 出栈后得到mid node，进行转向，通往右树
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

