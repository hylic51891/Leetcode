import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: isSymmetric
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/6 16:37
 * @Version 1.0
 */
public class isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
//        return isSymmetric1(root.left,root.right);
        return isSymmetric2(root,root);
    }
    /**
     * 递归
     * 0ms
     * 击败 100%
     * 39.5mb
     * 击败 79.52%
     */
    public boolean isSymmetric1(TreeNode left,TreeNode right) {
        if(left==null && right==null){
            return true;
        }
        else if(left!=null && right!=null && left.val==right.val){
            return isSymmetric1(left.left,right.right) && isSymmetric1(left.right,right.left);
        }
        else return false;
    }

    /**
     * 迭代，用一个queue来维护放入的节点，每次放入左右节点，拿出的时候一次pop两个来进行比较。
     * 1ms
     * 击败 20.27%
     * 39.93mb
     * 击败 10.31%
     */
    public boolean isSymmetric2(TreeNode left,TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        TreeNode l;
        TreeNode r;
        while(!queue.isEmpty()){
            l = queue.poll();
            r = queue.poll();
            if(l==null&& r==null) continue;
            if(l==null || r==null || l.val != r.val) return false;

            queue.offer(l.left);
            queue.offer(r.right);
            queue.offer(l.right);
            queue.offer(r.left);
        }
        return true;
    }
}
