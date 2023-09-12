package 模板;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: serialize
 * Package: 模板
 * Description:
 *  序列化模板
 * @Author hylic
 * @Create 2023/9/4 14:02
 * @Version 1.0
 */

public class serialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 中序遍历
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        StringBuilder s = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if(curNode!=null){
                queue.offerLast(curNode.left);
                queue.offerLast(curNode.right);
                s.append(curNode.val);
            }
            else{
                s.append("null");
            }

            s.append(',');
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null,")) return null;
        TreeNode sentinel = new TreeNode(0);
        String[] nodes = data.substring(0,data.length()-1).split(",");
        sentinel.right = new TreeNode(Integer.parseInt(nodes[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(sentinel.right);
        for (int i = 1; i < nodes.length; i+=2) {
            TreeNode curNode = queue.poll();
            if(nodes[i].equals("null")){
                curNode.left = null;
            }
            else{
                curNode.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offerLast(curNode.left);
            }

            if(nodes[i+1].equals("null")){
                curNode.right = null;
            }
            else{
                curNode.right = new TreeNode(Integer.parseInt(nodes[i+1]));
                queue.offerLast(curNode.right);
            }

        }
        return sentinel.right;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
