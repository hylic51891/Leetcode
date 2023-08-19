import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: Codec
 * Package: PACKAGE_NAME
 * https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/?envType=study-plan-v2&envId=coding-interviews
 * 剑指 Offer 37. 序列化二叉树 hard
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/17 1:01
 * @Version 1.0
 */

/** 我的思路
 *  序列化：正常的BFS
 *  反序列化：同样从上到下BFS
 *      放入queue的时候均为空节点
 *      如果为父节点的左节点，则该节点的左节点指向父节点；右侧同理；这样可以赋值为null
 *  16ms 64%
 */
public class Codec {
    public static void main(String[] args) {
        new Codec().deserialize(",1,2,3,null,null,4,5");
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder ret = new StringBuilder();
        while(!queue.isEmpty()){
            ret.append(',');
            TreeNode curNode = queue.poll();
            if(curNode==null){
                ret.append("null");
                continue;
            }
            queue.offerLast(curNode.left);
            queue.offerLast(curNode.right);
            ret.append(curNode.val);
        }
        return ret.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 空树
        if(data.equals(",null")) return null;

        TreeNode sentinel = new TreeNode();
        TreeNode root = new TreeNode();
        sentinel.right = root;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        String[] nodes = data.split(",");
        for (int i = 1; i < nodes.length; i++) {
            TreeNode curNode = queue.poll();
            if(nodes[i].equals("null")){
                if(curNode.left!=null) curNode.left.left =null;
                else curNode.right.right =null;
                continue;
            }
            curNode.val = Integer.parseInt(nodes[i]);
            curNode.left = new TreeNode(){{left = curNode;}};
            curNode.right = new TreeNode(){{right = curNode;}};
            queue.offerLast(curNode.left);
            queue.offerLast(curNode.right);
        }
        return sentinel.right;
    }
}
