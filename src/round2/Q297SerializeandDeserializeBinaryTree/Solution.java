package round2.Q297SerializeandDeserializeBinaryTree;

import structures.TreeNode;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null)
            return "";

        StringBuilder sb = new StringBuilder();
        serializeCore(root, sb);
        return new String(sb);
    }

    private void serializeCore(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("*,");
            return;
        }

        sb.append(root.val+",");
        serializeCore(root.left, sb);
        serializeCore(root.right, sb);
    }


    private int curIdx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null || data.equals(""))
            return null;

        String[] nodes = data.split(",");

        curIdx = 0;
        return deserializeCore(nodes);
    }

    /** construct subtree whose root is nodes[curIdx]
     * */
    public TreeNode deserializeCore(String[] nodes) {
        if (curIdx>=nodes.length)
            return null;

        //visit
        if (nodes[curIdx].equals("*")){
            curIdx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[curIdx]));
        curIdx++;
        root.left = deserializeCore(nodes);
        root.right = deserializeCore(nodes);

        return root;
    }

}
