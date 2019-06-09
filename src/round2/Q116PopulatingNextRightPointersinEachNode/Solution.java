package round2.Q116PopulatingNextRightPointersinEachNode;


import structures.Node;

class Solution {

    public Node connect(Node root) {
        if (root==null)
            return null;

        connectCore(root, null);
        return root;
    }

    private void connectCore(Node root, Node right) {
        if (root==null)
            return;

        // root, left & right, whichever first

        // right then left || left then right
        connectCore(root.left, root.right);
        connectCore(root.right, right==null?null:right.left);
        // root
        root.next = right;
    }

}