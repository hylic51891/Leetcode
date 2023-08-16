/**
 * ClassName: treeToDoublyList
 * Package: PACKAGE_NAME
 *https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/?envType=study-plan-v2&envId=coding-interviews
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/16 16:41
 * @Version 1.0
 */

import java.util.Deque;
import java.util.LinkedList;

/** 我的分析
 * 中序遍历+dfs
 * 静态参数：deque
 * 递推参数：当前节点
 * 终止条件：当前节点中序遍历结束
 * 递推工作：
 *  1. 遍历左节点
 *  2. 放入当前节点
 *  3. 遍历右节点
 * 边界条件： 使用sentinel节点，最右的前驱，最左的后驱先指向sentinel
 */

/** -ms 100% OT
 * 可优化：
 *  1. 不需要deque保存所有node，只需要保留最后一个节点和第一个节点
 */
public class treeToDoublyList {
    Deque<Node> queue  = new LinkedList<>();
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        queue.add(new Node());
        inorderTraversal(root);
        Node head =  queue.peekFirst().right;
        head.left = queue.peekLast();
        head.left.right = head;
        return head;
    }

    public void inorderTraversal(Node root){
        if(root == null ) return;
        inorderTraversal(root.left);
        Node lastNode = queue.peekLast();
        lastNode.right = root;
        root.left = lastNode;
        queue.offerLast(root);
        inorderTraversal(root.right);
    }
}

/**
 * 优化：用pre和cur修改为双向链表
 */
class treeToDoublyListOpt {
    Node pre ;
    Node head ;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        inorderTraversal(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void inorderTraversal(Node cur){
        if(cur == null ) return;
        inorderTraversal(cur.left);
        if(pre==null) head = cur;
        else pre.right = cur;
        cur.left = pre;
        pre = cur;
        inorderTraversal(cur.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};