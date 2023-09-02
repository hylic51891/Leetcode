package _7_binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: postorderTraversal
 * Package: binaryTree
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/29 16:29
 * @Version 1.0
 */
public class postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode lastNode = root;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curNode = stack.peek();
            if(curNode.left!=null && curNode.left!=lastNode && curNode.right!=lastNode){
                stack.push(curNode.left);
            }
            else if(curNode.right!=null && curNode.right!=lastNode){
                stack.push(curNode.right);
            }
            else{
                result.add(stack.pop().val);
                lastNode = curNode;

            }
        }
        return result;

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}