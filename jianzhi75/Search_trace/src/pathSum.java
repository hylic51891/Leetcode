import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: pathSum
 * Package: PACKAGE_NAME
 * 剑指offer 34
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/16 15:48
 * @Version 1.0
 */

/** 1ms 99.88%
 *  题解：先序遍历+路径记录的二叉树搜索问题
 */
public class pathSum {
    static List<List<Integer>> ret;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ret = new ArrayList<>();
        if(root==null) return ret;
        Deque<Integer> l = new LinkedList<>();
        recur(root,l,target);
        return ret;
    }

    /** 先序遍历+ dfs递归分析
     * 返回条件：
     *  当前节点为null（叶子节点的子节点） 直接return
     * 递归：
     *  1.传递 target-当前节点val 到子节点
     *  2.传递 加入当前节点val的path 到子节点
     *  3.回溯到当前递归栈的时候，从path中移除当前节点的val
     */
    public void recur(TreeNode root, Deque<Integer> path, int target){
        if(root == null) return;
        path.offerLast(root.val);
        target-=root.val;
        if(root.left == null && root.right == null && target==0){
            ret.add(new LinkedList<Integer>(path));
        }
        recur(root.left,path,target);
        recur(root.right,path,target);

        path.pollLast();
    }
}
