package round1;

import structures.TreeNode;

public class Q297SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuffer sb = new StringBuffer();
        serializeCore(root, sb);
        return new String(sb);
    }

    public void serializeCore(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val + ",");
        serializeCore(root.left, sb);
        serializeCore(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null || data.length()==0)
            return null;

        String[] strs = data.split(","); //***bug:有可能是多位数，不能使用char必须得用String数组
        curIdx = 0;
        return deserializeCore(strs);
    }

    private int curIdx = 0;
    public TreeNode deserializeCore(String[] strs){
        if (curIdx >= strs.length)
            return null;

        if ( strs[curIdx].equals("#") ){
            curIdx +=1;
            return null;
        }
        //else
        TreeNode root = new TreeNode( Integer.valueOf(strs[curIdx]) );
        curIdx += 1;
        root.left = deserializeCore(strs);
        root.right = deserializeCore(strs);
        return root;
    }

}
