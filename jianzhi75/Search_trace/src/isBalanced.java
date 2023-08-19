/**
 * ClassName: isBalanced
 * Package: PACKAGE_NAME
 * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/solutions/159235/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/?envType=study-plan-v2&envId=coding-interviews7
 * 平衡二叉树
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/17 0:05
 * @Version 1.0
 */
public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        return depth(root)!=-1;
    }
    /**
     返回当前root节点的深度
     */
    public int depth(TreeNode root){
        // 空节点
        if(root==null) return 0;
        // 左节点深度
        int l = depth(root.left);
        if(l==-1) return -1;
        // 右节点深度
        int r = depth(root.right);
        if(r==-1) return -1;
        // 当前节点判断
        if( l-r<-1 || l-r>1 ) return -1;

        return 1+((l>r)?l:r);
    }
}
