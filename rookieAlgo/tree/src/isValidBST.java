import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: isValidBST
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/6 15:27
 * @Version 1.0
 */
public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        // DFS递归
        if(root == null) return true;
        if(root.left!= null && root.val <= root.left.val){
            return false;
        }
        if(root.right!= null && root.val >= root.right.val){
            return false;
        }
        else{
            return isValidBST(root.left,(long)Integer.MIN_VALUE - 1L,root.val)&& isValidBST(root.right,root.val,(long)Integer.MAX_VALUE + 1L);
        }
    }
    /**
     * 判断是否为二叉搜索树，右子节点的所有节点都大于当前节点值，左子节点的所有节点都小于当前节点值
     * 递归需要传递左边界和右边界，所有左节点需要满足右边界条件，右节点同理
     */
    public boolean isValidBST(TreeNode root, long leftBound,long rightBound){
        if(root == null) return true;
        if(root.left!= null){
            if(!(root.left.val < root.val && root.left.val > leftBound)) return false;
        }
        if(root.right!= null){
            if(!(root.right.val > root.val && root.right.val < rightBound)) return false;
        }

        return isValidBST(root.left,leftBound,root.val)&& isValidBST(root.right,root.val,rightBound);
    }

    /**
     * 递归简洁版本
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST2(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST2(node.left, lower, node.val) && isValidBST2(node.right, node.val, upper);
    }

    /**  我写的中序遍历
     * 中序遍历，判断下一个数是否大于上一个数
     */
    public boolean isValidBST3(TreeNode root) {
        // 用deque实现一个FILO的stack
        Deque<TreeNode> stack = new LinkedList<>();
        long lastNum = Long.MIN_VALUE;
        while(root !=null || !stack.isEmpty()){
            // 获得最左边的节点
            while(root!= null){
                stack.push(root);
                root = root.left;
            }
            // 获得最后得到的非null左节点，此时树中未遍历的最左边节点
            root = stack.pop();
            if(root.val <= lastNum) return false;
            lastNum = root.val;
            root = root.right;
        }
        return true;
    }
    /** 比较好的中序遍历递归实现。
     *
     */
    // 最小值初始化为中序序列的第一个节点值
    Integer pre;
    public boolean isValidBST4(TreeNode root) {
        // 结束条件：如果root为null，返回true。
        // 因为空的二叉搜索树也是符合条件的
        if (root == null) return true;
        // 中序遍历：左根右
        // 递归左子树，获取结果
        boolean left = isValidBST4(root.left);
        // 如果当前节点的值大于等于中序序列中上一个值，证明不是二叉搜索树
        // 如果pre为null，证明pre还没有初始化所以首先将pre初始化
        if (pre != null && root.val <= pre){
            return false;
        }
        // 如果当前节点小于中序序列上一个值，证明符合条件，更新pre为
        // 当前值，继续判断下一个值，
        pre = root.val;
        // 递归右子树，获取结果
        boolean right = isValidBST4(root.right);
        //    左右子树都是二叉搜索树，则返回true，否则返回false
        return left && right;
    }
}
