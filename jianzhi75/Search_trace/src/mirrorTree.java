/**
 * ClassName: mirrorTree
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/15 19:29
 * @Version 1.0
 */
public class mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        /** 递归思路
         * 流程：
         * 1.如果子节点都是null，则返回自身
         * 2.如果其中一个不为null,则递归之后交换节点
         * 特殊情况：
         * 输入的根节点就是null，返回null
         */
        if(root==null) return null;
        TreeNode ml = mirrorTree(root.left);
        TreeNode mr = mirrorTree(root.right);
        root.left = mr;
        root.right = ml;
        return root;
    }
}
