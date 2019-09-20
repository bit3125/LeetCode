/**算法分析：依然是以inorder为基础，进行小范围修改
 * 不同之处：
 * 0. 设置一个prev标志来记录上一个访问的节点，这样取到mid node的时候便能判断其右树是否已visit
 * 1. 原先的出栈改为取顶观察。在这里取顶（也即原先的出栈）mid node操作有两个用途：
 *      1. 若prev==p.right则对该mid node进行visit，然后将该mid node出栈丢弃
 *      2. 若非，则以mid node 为中继进行到右树的转向，mid node继续留在栈中，以便后续visit
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
        while (p != null || !stack.isEmpty()) { // 右树不为空 或 栈不空
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            //***diff 在访问到当前mid node的时候先不着急弹出，
            // 判断当前是“以mid node为中继转向到右树”还是“visit mid node”
            p = stack.peek();
            if (p.right == null || prev == p.right) { //***diff 无右子树 或 右子树刚被访问完，visit
                // visit
                result.add(p.val);
                stack.pop(); // mid node使用完毕，弃之

                prev = p; // 记录上一个visit的node
                p = null; // 仅仅是让下轮能进入大while，然后继续弹栈
            } else { // 以mid node为中继进行转向
                p = p.right; //***diff
            }
        }

        return result;
    }
}

