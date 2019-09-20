/**Ëã·¨·ÖÎö£º¼ûinorder
 *
 * */


package others.algos.treetraverse.norecursion.preorder;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                // visit
                result.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }

        return result;
    }
}

