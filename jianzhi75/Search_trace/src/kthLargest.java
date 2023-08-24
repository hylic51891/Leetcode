/**
 * ClassName: kthLargest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/16 19:40
 * @Version 1.0
 */


/** -ms 100% TO
 *
 */
public class kthLargest {
    /** 中序遍历：右-中-左
     找到头节点之后开始计数
     */
    int rank;
    int ret;
    public int kthLargest(TreeNode root, int k) {
        if(root == null) return 0;
        rank = k;
        recur(root);
        return ret;
    }

    public void recur(TreeNode root){
        // 找到最大节点的right
        if(root==null || rank==0) return;
        // 已找到
        // 遍历右边
        recur(root.right);
        // 判断当前是否是第k个
        if(--rank == 0){
            ret = root.val;
            return;
        }
        //遍历左边
        recur(root.left);
    }

}
