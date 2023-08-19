/**
 * ClassName: lowestCommonAncestor
 * Package: PACKAGE_NAME
 * 面试题68 - I. 二叉搜索树的最近公共祖先（迭代 / 递归，清晰图解
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solutions/216894/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/?envType=study-plan-v2&envId=coding-interviews
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/17 0:38
 * @Version 1.0
 */

/**
 * 我的写法 6ms 40%
 * 没看到二叉搜索树条件，对普通二叉树适用
 * 可优化
 */
public class lowestCommonAncestor {

    int value1;
    int value2;
    TreeNode ret;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        value1 = p.val;
        value2 = q.val;
        lowestCommonAncestor(root);
        return ret;
    }
    public int lowestCommonAncestor(TreeNode root){
        if(root == null) return 0;
        int l = lowestCommonAncestor(root.left);
        if(l==-1) return -1;
        int r = lowestCommonAncestor(root.right);
        if(r==-1) return -1;
        int merge = l+r;
        int curValue = root.val;
        if(curValue == value1) merge+=1;
        if(curValue == value2) merge+=2;

        if(merge == 3){
            ret = root;
            return -1;
        }
        return merge;
    }
}

/**
 * 看完题解的优化
 * 5ms 100%
 */
class lowestCommonAncestorOpt {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int value1,value2;
        if(p.val < q.val){
            value1 = p.val;
            value2 = q.val;
        }
        else{
            value1 = q.val;
            value2 = p.val;
        }

        while(true){
            if(root.val < value1) root = root.right;
            else if(root.val > value2) root = root.left;
            else break;
        }
        return root;
    }

}
