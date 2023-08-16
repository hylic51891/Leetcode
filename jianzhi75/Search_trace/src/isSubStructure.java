/**
 * ClassName: isSubStructure
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/15 18:54
 * @Version 1.0
 */
public class isSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        return isSubStructure1(A,B,false);
        if(B==null)return false;
        else if(A==null) return false;
        else{
//          return isSubStructure2(A,B,false);
            return (A.val==B.val)&&recur(A.left,B.left)&&recur(A.right,B.right) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
        }
    }

    /**
     * 递归，回溯 TO
     * 1. 包括当前节点
     * 2. 不包括当前节点
     */
    public boolean isSubStructure1(TreeNode A, TreeNode B,boolean include) {
        if(B==null) return false;
        else if(A==null) return false;

        // 包括当前节点
        boolean inclusive;
        if(A.val==B.val){
            boolean subLeft = true;
            boolean subRight = true;
            if(B.left!=null){
                subLeft = isSubStructure1(A.left,B.left,true);
            }
            if(B.right!=null){
                subRight = isSubStructure1(A.right,B.right,true);
            }
            inclusive = subLeft&&subRight;
        }
        else{
            inclusive = false;
        }
        // 如果已经指定必须包括当前A节点
        if(include){
            return inclusive;
        }

        // 不包括当前节点
        boolean exclusive;
        boolean left = false;
        boolean right = false;
        if(A.left!=null){
            left = isSubStructure1(A.left,B,false);
        }
        if(A.right!=null){
            right = isSubStructure1(A.right,B,false);
        }
        exclusive = left||right;
        return inclusive || exclusive;
    }
    /**
     * 递归，回溯 TO，改进
     * 1. 包括当前节点
     * 2. 不包括当前节点
     */
    public boolean isSubStructure2(TreeNode A, TreeNode B,boolean include) {
        if(B==null) return true;
        else if(A==null) return false;

        // 包括当前节点
        boolean inclusive;
        if(A.val==B.val) inclusive = isSubStructure2(A.left,B.left,true)&&isSubStructure2(A.right,B.right,true);
        else inclusive = false;

        // 如果已经指定必须包括当前A节点
        if(include) return inclusive;

        // 不包括当前节点
        boolean exclusive = isSubStructure2(A.left,B,false)||isSubStructure2(A.right,B,false);
        return inclusive || exclusive;
    }
    /**
     * 判断当前A作为根节点，是否和B是一样的树
     */
    public boolean recur(TreeNode A, TreeNode B){
        if(B==null) return true;
        else if(A==null) return false;
        else{
            return (A.val==B.val)&&recur(A.left,B.left)&&recur(A.right,B.right);
        }
    }
}
