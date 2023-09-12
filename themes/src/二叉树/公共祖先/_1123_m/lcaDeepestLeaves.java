package 二叉树.公共祖先._1123_m;

import javafx.util.*;



/**
 * ClassName: lcaDeepestLeaves
 * Package: 二叉树.公共祖先._1123_m
 * Description:
 *
 * @Author hylic
 * @Create 2023/9/6 10:45
 * @Version 1.0
 */
public class lcaDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getValue();
    }
    public Pair<Integer,TreeNode> dfs(TreeNode root){
        if(root==null){
            return new Pair<>(0,null);
        }
        Pair<Integer,TreeNode> left = dfs(root.left);
        Pair<Integer,TreeNode> right = dfs(root.right);
        if(left.getKey().equals(right.getKey())){
            return new Pair<>(left.getKey()+1,root);
        }
        if(left.getKey() > right.getKey()){
            return new Pair<>(left.getKey()+1,left.getValue());
        }
        else {
            return new Pair<>(right.getKey() + 1, right.getValue());
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
